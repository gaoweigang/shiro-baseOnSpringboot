package com.gwg.shiro.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Table(name = "tbl_login_log")
public class LoginLog implements Serializable {
    /**
     * 主键流水号
     */
    @Id
    private Long id;

    /**
     * 客户端登陆ip
     */
    @Column(name = "client_ip")
    private String clientIp;

    /**
     * 登入时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 登出时间
     */
    @Column(name = "logout_time")
    private Date logoutTime;

    /**
     * 服务器ip
     */
    @Column(name = "server_ip")
    private String serverIp;

    /**
     * 服务器端口
     */
    @Column(name = "server_port")
    private String serverPort;

    /**
     * 服务系统 0 业务系统 1支撑系统
     */
    @Column(name = "service_id")
    private String serviceId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 描述
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键流水号
     *
     * @return id - 主键流水号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键流水号
     *
     * @param id 主键流水号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取客户端登陆ip
     *
     * @return client_ip - 客户端登陆ip
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * 设置客户端登陆ip
     *
     * @param clientIp 客户端登陆ip
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * 获取登入时间
     *
     * @return login_time - 登入时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登入时间
     *
     * @param loginTime 登入时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取登出时间
     *
     * @return logout_time - 登出时间
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * 设置登出时间
     *
     * @param logoutTime 登出时间
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * 获取服务器ip
     *
     * @return server_ip - 服务器ip
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 设置服务器ip
     *
     * @param serverIp 服务器ip
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    /**
     * 获取服务器端口
     *
     * @return server_port - 服务器端口
     */
    public String getServerPort() {
        return serverPort;
    }

    /**
     * 设置服务器端口
     *
     * @param serverPort 服务器端口
     */
    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * 获取服务系统 0 业务系统 1支撑系统
     *
     * @return service_id - 服务系统 0 业务系统 1支撑系统
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * 设置服务系统 0 业务系统 1支撑系统
     *
     * @param serviceId 服务系统 0 业务系统 1支撑系统
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户姓名
     *
     * @return username - 用户姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户姓名
     *
     * @param username 用户姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}