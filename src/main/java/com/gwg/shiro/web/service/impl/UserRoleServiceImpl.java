package com.gwg.shiro.web.service.impl;

import com.gwg.shiro.web.dao.UserRoleDao;
import com.gwg.shiro.web.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author
 *
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {


	@Autowired
	private UserRoleDao userRoleDao;

	/**
	 * 判断用户是不是坐席人员
	 * @param userId
	 * @return
	 */
	public boolean isSaleStuff(String userId) {

		return true;
	}

	/**
	 *根据userid获取用户角色
	 */
	public List<String> getRoleListByUserId(String userId){
		return userRoleDao.queryRoleListByUserId(userId);
	}
}
