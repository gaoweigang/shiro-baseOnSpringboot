package com.gwg.shiro.web.dao;

import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.UserRole;

import java.util.List;

public interface UserRoleDao {
    /**
     * 根据用户ID获取用户角色
     */
    public List<String> queryRoleListByUserid(String userid) throws BusinessException;

    /**
     * 添加用户角色关联信息
     */
    public boolean addUserRole(UserDto dto) throws BusinessException;

    /**
     * 根据userid更新用户角色
     * @param dto
     * @return
     * @throws BusinessException
     */
    public boolean updateUserRoleByUserId(UserDto dto) throws BusinessException;

}
