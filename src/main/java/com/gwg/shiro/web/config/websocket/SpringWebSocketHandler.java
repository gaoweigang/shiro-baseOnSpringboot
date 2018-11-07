package com.gwg.shiro.web.config.websocket;

import com.alibaba.fastjson.JSON;
import com.gwg.shiro.web.common.Constant;
import com.gwg.shiro.web.config.shiro.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.WebSocketSession无法序列化
 * 2.WebSocketSession没必要放到Redis中,因为WebSocket是与具体的某台服务器建立的长连接。
 * 3.Websocket的长连接通道一但关闭了websocket session就失效了。不像http协议每次用就去新建一个连接。
 * 你是可以知道是哪个用户，也知道要发哪些数据，但是问题在于。连接关闭后你发不过去。这也是websocketsession不能序列化的原因。自己构建的session不能解决长连接的问题。
 * 參考：https://www.sojson.com/blog/238.html
 */
public class SpringWebSocketHandler extends TextWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(SpringWebSocketHandler.class);

    private static final Map<String, WebSocketSession> users;  //Map来存储WebSocketSession，key用USER_ID 即在线用户列表

    //用户标识
    //private static final String USER_ID = "WEBSOCKET_USERID";   //对应监听器从的key


    static {
        users =  new HashMap<String, WebSocketSession>();
    }

    public SpringWebSocketHandler() {}

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        log.info("成功建立websocket连接!");
        AuthUser authUser= (AuthUser) session.getAttributes().get(Constant.AUTH_USER_KEY);
        log.info("从WebSocketSession中获取登陆用户信息：{}", JSON.toJSON(authUser));
        users.put(authUser.getUserId(), session);
        log.info("afterConnectionEstablished end ....");
        //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
        //TextMessage returnMessage = new TextMessage("成功建立socket连接，你将收到的离线");
        //session.sendMessage(returnMessage);
    }

    /**
     * 关闭连接时触发
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        AuthUser authUser= (AuthUser) session.getAttributes().get(Constant.AUTH_USER_KEY);
        System.out.println("用户"+authUser.getUserId()+"已退出！");
        users.remove(authUser.getUserId());
        log.info("剩余在线用户"+users.size());//如果是多节点部署，这个统计在线用户不准确
    }

    /**
     * ***前端给后端推送消息******************
     * js调用websocket.send时候，会调用该方法
     * *************************************
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        super.handleTextMessage(session, message);

        /**
         * 收到消息，自定义处理机制，实现业务
         */
        log.info("服务器收到消息：{}",message);

        if(message.getPayload().startsWith("#anyone#")){ //单发某人

            sendMessageToUser((AuthUser) session.getAttributes().get(Constant.AUTH_USER_KEY), new TextMessage("服务器单发：" +message.getPayload())) ;

        }else if(message.getPayload().startsWith("#everyone#")){

            sendMessageToUsers(new TextMessage("服务器群发：" +message.getPayload()));

        }else{

        }

    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        log.info("传输出现异常，关闭websocket连接... ");
        AuthUser authUser = (AuthUser) session.getAttributes().get(Constant.AUTH_USER_KEY);
        users.remove(authUser.getUserId());
    }

    public boolean supportsPartialMessages() {

        return false;
    }


    /**
     * 给某个用户发送消息
     *
     * @param authUser
     * @param message
     */
    public void sendMessageToUser(AuthUser authUser, TextMessage message) {

                try {
                    if (users.get(authUser.getUserId()).isOpen()) {
                        users.get(authUser.getUserId()).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (String userId : users.keySet()) {
            try {
                if (users.get(userId).isOpen()) {
                    users.get(userId).sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}