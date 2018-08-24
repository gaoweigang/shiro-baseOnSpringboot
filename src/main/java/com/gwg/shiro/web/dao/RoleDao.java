package com.gwg.shiro.web.dao;

import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Role;
import com.gwg.shiro.web.vo.RoleVo;

import java.util.List;

public interface RoleDao {

    /**
     * 添加角色
     */
    public boolean addRole(RoleDto dto) throws BusinessException;


    /**
     * 更新角色
     */
    public boolean updateRoleById(RoleDto dto) throws BusinessException;


    /**
     * 根据条件查询用户角色
     */
    public Role queryRoleById(RoleDto dto) throws BusinessException;

    /**
     * 分页查询-角色
     * @param dto
     * @return
     * @throws BusinessException
     */
    public PageInfo<Role> queryRoleByLimit(RoleDto dto) throws BusinessException;



    /**
     * 删除用户角色
     */
    public boolean delRoleById(RoleDto dto) throws BusinessException;


}
