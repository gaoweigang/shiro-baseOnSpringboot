package com.gwg.shiro.web.service.impl;

import com.gwg.shiro.web.common.ReturnCode;
import com.gwg.shiro.web.dao.ResourceDao;
import com.gwg.shiro.web.dao.RoleDao;
import com.gwg.shiro.web.dao.RoleResourceDao;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.model.Role;
import com.gwg.shiro.web.service.ResourceService;
import com.gwg.shiro.web.vo.RoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author
 *
 */
@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private RoleResourceDao roleResourceDao;


	/**
	 * 1.权限展示有两部分
	 * 1.查询所有的资源， 2.查询该角色有哪些资源的id
	 */
	public List<Resource> queryAllResources() {

		//1.查询所有的资源信息，在内存中处理
		return resourceDao.queryAllResources();

	}

	@Override
	public List<Resource> queryCurrentUserMenu(String userId) {
		return resourceDao.queryCurrentUserMenu(userId);
	}
}
