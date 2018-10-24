package com.gwg.shiro.web.service.impl;

import com.gwg.shiro.web.dao.RoleResourceDao;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.service.RoleResourceService;
import com.gwg.shiro.web.vo.CusMapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    private RoleResourceDao roleResourceDao;

    @Override
    public List<CusMapVo> queryAllRoleResourceMap() throws BusinessException {
        return roleResourceDao.queryAllRoleResourceMap();
    }
}
