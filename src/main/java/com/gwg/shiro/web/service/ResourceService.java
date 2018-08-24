package com.gwg.shiro.web.service;

import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.vo.RoleVo;

import java.util.List;

/**
 *
 */
public interface ResourceService {

	/**
	 * 获取全部资源
	 */
	public List<Resource> queryAllResources();


	/**
	 * 根据登陆用户user_id获取菜单
	 */
	public List<Resource> queryCurrentUserMenu(String userId);




}
