package com.gwg.shiro.web.config.shiro;

import com.gwg.shiro.web.config.RedisSessionDAO;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author April.Chen
 */
@Configuration
public class ShiroConfig {

	@Autowired
	private MyShiroRealm myShiroRealm;

	@Autowired
	private RedisSessionDAO sessionDAO;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Bean
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 缓存管理器
	 * @return
	 */
	@Bean
	public CustomShiroCacheManager redisCacheManager() {
		CustomShiroCacheManager redisCacheManager = new CustomShiroCacheManager();
		redisCacheManager.setRedisTemplate(redisTemplate);
		return redisCacheManager;
	}

	/**
	 * 会话管理器
	 * @return
	 */
	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionDAO(this.sessionDAO);
		sessionManager.setCacheManager(redisCacheManager());
		/**
		 * 设置系统范围内的默认时间(以毫秒为单位)，任何会话在终止之前都可能保持空闲。此值是所有会话的主要默认值，
		 * 如果需要的话可以通过调用Subject.getSession().setTimeout(long)在每个会话的基础上重写
		 * 1.负返回值意味着会话永远不会过期
		 * 2.非负返回值(0或更大)表示会话超时将按预期发生
		 * 除非通过调用此方法重写，否则默认值为DEFAULT_GLOBAL_SESSION_TIMEOUT(即30分钟)。
		 */
		sessionManager.setGlobalSessionTimeout(5 * 60 * 1000);//session的失效时长，单位毫秒
		/**
		 * 设置在发现会话无效后是否应该自动删除会话。默认值是true，以确保底层数据存储中不存在孤儿。
		 * 如果您要手动删除会话(quartz, cron，等等)，那么只能将此值设置为false,参考isDeleteInvalidSessions()
		 */
		sessionManager.setDeleteInvalidSessions(true);//删除失效的session
		return sessionManager;
	}

	/**
	 * securityManager安全管理器
	 * @return
	 */
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//注入session管理器
		securityManager.setSessionManager(sessionManager());
		securityManager.setRealm(myShiroRealm);
		//注入缓存管理器
		securityManager.setCacheManager(redisCacheManager());
		return securityManager;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(securityManager());
		return new AuthorizationAttributeSourceAdvisor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean() {

		//1.shiro核心拦截器DelegatingFilterProxy对应的bean
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//管理器，必须设置
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		/**
		 * 将应用程序的登录URL分配给所有获得的过滤器(AccessControlFilter的子类)。这是一种方便的机制:对于所有配置的filters，
		 * 以及任何默认的继承了AccessControlFilter的过滤器(authc、user等)，这个值将通过AccessControlFilter#setLoginUrl(String)
		 * 方法传递给每个过滤器。这样就不需要在每个筛选器实例上手动配置'loginUrl'属性，而是可以通过此属性配置一次。
		 *
		 * 如果一个过滤器已经显式地配置了一个值，它将不会接收到这个值。单个过滤器配置覆盖这个全局便利属性。
		 *
		 * 'loginUrl': 用于对用户进行身份验证的登录url，如果需要身份验证，则在重定向用户时使用。
		 *
		 * 大多数Shiro过滤器使用这个url作为位置，以便在过滤器需要身份验证时重定向用户。除非被重写，否则假定使用DEFAULT_LOGIN_URL默认
		 * 登录URL(/login.jsp)，可以通过以下方式重写它

		 * 总结：配置身份认证跳转，可以是页面(eg:/login.jsp),也可以服务地址(/user/ajaxLogin),在需要进行身份认证的时候，
		 * 进行跳转，由于是前后端分离的项目，因此这里配置的是服务地址，如果用户没有登陆就访问受限资源，则会提示用户未登陆
		 */
		//shiroFilterFactoryBean.setLoginUrl("/user/ajaxLogin");
		//shiroFilterFactoryBean.setSuccessUrl("/success");

		/**
		 * 2.自定义filter，可用来更改默认的表单名称配置
		 * 如下配置会添加到DefaultFilterChainManager.filters，filters还有会有其他默认过滤器
		 * key:过滤器的名称 ， value: 过滤器的全路径类名
		 * --默认的
		 * key ----------------------value
		 * --默认的
		 * anon              org.apache.shiro.web.filter.authc.AnonymousFilter
		 * authc             org.apache.shiro.web.filter.authc.FormAuthenticationFilter
		 * authcBasic        org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter
		 * logout            org.apache.shiro.web.filter.authc.LogoutFilter
		 * noSessionCreation org.apache.shiro.web.filter.session.NoSessionCreationFilter
		 * perms             org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter
		 * port              org.apache.shiro.web.filter.authz.PortFilter
		 * rest              org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter
		 * roles             org.apache.shiro.web.filter.authz.RolesAuthorizationFilter
		 * ssl               org.apache.shiro.web.filter.authz.SslFilter
		 * user              org.apache.shiro.web.filter.authc.UserFilter
		 * --自定义的
		 * myauthc           com.gwg.shiro.web.config.MyAccessControlFilter
		 */
		Map<String, Filter> filters = new HashMap<String, Filter>();
		filters.put("myauthc", new MyAccessControlFilter());
		//将自定义 的FormAuthenticationFilter注入shiroFilter中
		shiroFilterFactoryBean.setFilters(filters);

		/**
		 * 3.指定访问路径由那个过滤器来处理
		 * 如下配置会转换成DefaultFilterChainManager.filterChains
		 * key ： 访问路径， value:过滤器的名称 对应的 过滤器
		 */
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

		//filterChainDefinitionMap.put("/logon.html", "anon");
		//filterChainDefinitionMap.put("/", "anon");
		//登陆可以匿名访问，否者登陆服务无法访问。尝试访问登陆，由于用户不能访问登陆，提示用户没有登陆无法访问
		filterChainDefinitionMap.put("/user/ajaxLogin", "anon");
		// 请求logout地址，shiro去清除session
		filterChainDefinitionMap.put("/user/logout", "logout");
		//对静态资源设置匿名访问
		//filterChainDefinitionMap.put("/js/**", "anon");
		//filterChainDefinitionMap.put("/page/**", "anon");
		//配置服务访问权限,eg：以/role为前缀的服务只有ADMIN能够访问 这段代码能不能动态生成
		filterChainDefinitionMap.put("/role/**", "perms[ADMIN]");
		//  /** = authc 所有url都必须认证通过才可以访问
		filterChainDefinitionMap.put("/**", "myauthc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}



}