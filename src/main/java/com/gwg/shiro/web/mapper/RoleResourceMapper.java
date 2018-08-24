package com.gwg.shiro.web.mapper;

import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.model.RoleResource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleResourceMapper extends Mapper<RoleResource> {

    public List<Resource> queryResourceListByRoleId(RoleDto dto) throws BusinessException;
}