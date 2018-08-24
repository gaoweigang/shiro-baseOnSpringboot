package com.gwg.shiro.web.service;

import java.util.List;

/**
 * 
 * @author
 *
 */
public interface UserRoleService {

	/**
	 * 判断用户是不是坐席，如果是坐席，则允许登陆系统
	 */
	public boolean isSaleStuff(String userid);

	/**
	 *根据用户ID获取用户角色
	 */
	public List<String> getRoleListByUserid(String userid);

}
