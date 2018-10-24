package com.gwg.shiro.web.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.gwg.shiro.web.common.Constant;
import com.gwg.shiro.web.service.RoleResourceService;
import com.gwg.shiro.web.vo.CusMapVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.*;


public class ShiroDelegate {

	private static final Logger logger = LoggerFactory.getLogger(ShiroDelegate.class);

	public static Map<String, String> wrapFilterChain(RoleResourceService roleResourceService) {

		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

		filterChainDefinitionMap.put("/user/ajaxLogin", "anon");
		filterChainDefinitionMap.put("/user/logout", "logout");
		//swagger-ui start...
		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
		filterChainDefinitionMap.put("/webjars/**", "anon");
		filterChainDefinitionMap.put("/swagger-resources/**", "anon");
		filterChainDefinitionMap.put("/v2/**", "anon");
		//swagger-ui end....
		filterChainDefinitionMap.put("/", "anon");

		List<CusMapVo> cusMapVoList = roleResourceService.queryAllRoleResourceMap();
		if(!CollectionUtils.isEmpty(cusMapVoList)){
			Map<String, String> resRoleMap = new HashMap<String, String>();

			//获取
			cusMapVoList.stream().forEach(x -> {
				String resUrl = x.getCusKey();
				String roleCode = x.getCusValue();
				if(resRoleMap.containsKey(resUrl)){
					resRoleMap.put(resUrl, StringUtils.join(roleCode, Constant.COMMA, resRoleMap.get(resUrl)));
				}else{
					resRoleMap.put(resUrl, roleCode);
				}
			});
			Set<String> keySet = resRoleMap.keySet();
			keySet.stream().forEach(x -> {
				if(StringUtils.contains(resRoleMap.get(x), Constant.COMMA)){
					filterChainDefinitionMap.put(x, "roleFilter[\"" + resRoleMap.get(x) + "\"]");
				}else{
					filterChainDefinitionMap.put(x, MessageFormat.format(Constant.ROLE_FORMAT, resRoleMap.get(x)));
				}

			});

		}

		filterChainDefinitionMap.put("/**", "myauthc");
		logger.info("shiro权限列表为:" + JSONObject.toJSONString(filterChainDefinitionMap));
		return filterChainDefinitionMap;
	}

	/**
	 * 重新加载权限,当修改权限之后调用
	 */
	public static void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean, RoleResourceService roleResourceService) {

		synchronized (shiroFilterFactoryBean) {

			AbstractShiroFilter shiroFilter = null;
			try {
				shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
			} catch (Exception e) {
				throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
			}

			PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
					.getFilterChainResolver();
			DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

			// 清空老的权限控制
			manager.getFilterChains().clear();

			shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
			shiroFilterFactoryBean.setFilterChainDefinitionMap(ShiroDelegate.wrapFilterChain(roleResourceService));
			// 重新构建生成
			Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
			for (Map.Entry<String, String> entry : chains.entrySet()) {
				String url = entry.getKey();
				String chainDefinition = entry.getValue().trim().replace(" ", "");
				manager.createChain(url, chainDefinition);
			}

			logger.info("更新权限成功！！");
		}
	}
}
