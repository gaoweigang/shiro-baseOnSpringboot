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
	 * @param userid
	 * @return
	 */
	public boolean isSaleStuff(String userid) {

		return true;
	}

	/**
	 *根据userid获取用户角色
	 */
	public List<String> getRoleListByUserid(String userid){
		return userRoleDao.queryRoleListByUserid(userid);
	}
}
