package com.gwg.shiro.web.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.dao.RoleDao;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.mapper.RoleMapper;
import com.gwg.shiro.web.model.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Component
public class RoleDaoImpl implements RoleDao{

    @Autowired
    private RoleMapper roleMapper;


    public boolean addRole(RoleDto dto) throws BusinessException {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        role.setCreateTime(new Date());
        return roleMapper.insertSelective(role) > 0;

    }

    public boolean updateRoleById(RoleDto dto) throws BusinessException {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        role.setCreateTime(new Date());
        return roleMapper.updateByPrimaryKeySelective(role) > 0 ;
    }

    public boolean delRoleById(RoleDto dto) throws BusinessException {
        Role role = new Role();
        role.setId(dto.getId());
        return roleMapper.deleteByPrimaryKey(role) > 0;
    }

    public Role queryRoleById(RoleDto dto) throws BusinessException {
        Role role = new Role();
        role.setId(dto.getId());
        return roleMapper.selectByPrimaryKey(role);
    }

    public PageInfo<Role> queryRoleByLimit(RoleDto dto) throws BusinessException{
        PageHelper.startPage(dto.getPageIndex(), dto.getPageSize());
        Role condition = new Role();
        BeanUtils.copyProperties(dto, condition);
        List<Role> roleList = roleMapper.select(condition);
        return new PageInfo<Role>(roleList);
    }

}
