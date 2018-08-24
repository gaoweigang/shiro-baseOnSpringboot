package com.gwg.shiro.web.dao.impl;

import com.gwg.shiro.web.dao.UserRoleDao;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.mapper.UserMapper;
import com.gwg.shiro.web.mapper.UserRoleMapper;
import com.gwg.shiro.web.model.User;
import com.gwg.shiro.web.model.UserRole;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

@Component
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<String> queryRoleListByUserid(String userid) throws BusinessException{
        if(StringUtils.isEmpty(userid)){
            return null;
        }
        return userRoleMapper.queryRoleListByUserid(userid);
    }

    public boolean addUserRole(UserDto dto) throws BusinessException{
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(dto, userRole);
        return userRoleMapper.insert(userRole) > 0;
    }

    public boolean updateUserRoleByUserId(UserDto dto) throws BusinessException{
        Example example = new Example(UserRole.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", dto.getUserId());
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(dto, userRole);
        return userRoleMapper.updateByExampleSelective(userRole, example) > 0;
    }

}
