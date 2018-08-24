package com.gwg.shiro.web.service;

import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Role;
import com.gwg.shiro.web.vo.RoleVo;

import java.util.List;

public interface RoleService {

    /**
     * 新增角色
     */
    public boolean addRole(RoleDto dto) throws BusinessException;

    /**
     * 更新角色
     */
    public boolean updateRoleById(RoleDto dto) throws BusinessException;

    /**
     * 分页查询-角色
     * @return
     */
    public PageInfo<Role> queryRoleByLimit(RoleDto dto) throws BusinessException;


    /**
     * 删除角色
     */
    public boolean delRoleById(RoleDto dto) throws BusinessException;

    /**
     * 根据ID查询角色
     * @param dto
     * @return
     * @throws BusinessException
     */
    public Role queryRoleById(RoleDto dto) throws BusinessException;

    /**
     * 获取角色相关的所有资源
     * @param dto
     * @return
     * @throws BusinessException
     */
    public RoleVo queryRoleRelatedAllResById(RoleDto dto) throws BusinessException;


    public void grantResources(RoleDto dto) throws BusinessException;

}
