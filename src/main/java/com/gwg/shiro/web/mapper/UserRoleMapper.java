package com.gwg.shiro.web.mapper;

import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.UserRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {

    public List<String> queryRoleListByUserid(String userid) throws BusinessException;
}