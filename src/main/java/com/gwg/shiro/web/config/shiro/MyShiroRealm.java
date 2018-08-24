package com.gwg.shiro.web.config.shiro;


import com.alibaba.fastjson.JSON;
import com.gwg.shiro.web.config.shiro.AuthUser;
import com.gwg.shiro.web.service.UserRoleService;
import com.gwg.shiro.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 授权,只有成功通过doGetAuthenticationInfo方法的认证后才会执行。
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		LOGGER.info("doGetAuthorizationInfo start ...");
		// 从 principals获取主身份信息
		AuthUser user = (AuthUser) SecurityUtils.getSubject().getPrincipal();//User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
		//AuthUser user = (AuthUser) principalCollection.getPrimaryPrincipal();

		// 根据身份信息获取权限信息
		// 从数据库获取到权限数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", user.getUserid());
		List<String> userRoles = userRoleService.getRoleListByUserid(user.getUserid());
		LOGGER.info("用户权限信息：{}", JSON.toJSON(userRoles));
		// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		info.addStringPermissions(userRoles);

		return info;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		LOGGER.info("doGetAuthenticationInfo start ...");
		// token中包含用户输入的用户名和密码
		// 第一步从token中取出用户名
		String username = (String) token.getPrincipal();
		// 第二步：根据用户输入的userCode从数据库查询
		AuthUser authUser = userService.getAuthUserByUserid(username);
		// 如果查询不到返回null
		if (authUser == null)
			throw new UnknownAccountException();
		if (!"1".equals(authUser.getValidflag())) {
			throw new LockedAccountException(); // 帐号锁定
		}
		/**
		 * 认证的用户,正确的密码
		 */
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(authUser, //用户
				authUser.getPassword(), //密码
				ByteSource.Util.bytes(username), getName() //realm name
		);
		// 当验证都通过后，把用户信息放在session里
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("userSession", authUser);
		LOGGER.info("登陆用户sessionId:{}", session.getId());
		session.setAttribute("userSessionId", session.getId());
		return authenticationInfo;
	}

}