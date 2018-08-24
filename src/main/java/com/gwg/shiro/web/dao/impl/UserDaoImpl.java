package com.gwg.shiro.web.dao.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.dao.UserDao;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.mapper.UserMapper;
import com.gwg.shiro.web.model.Role;
import com.gwg.shiro.web.model.User;
import com.gwg.shiro.web.vo.UserVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserMapper userMapper;

    public User queryUserByUserid(String userid) {
        if(StringUtils.isEmpty(userid)){
            return null;
        }
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid", userid);
        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)){
            return null;
        }

        return userList.get(0);
    }


    public PageInfo<UserVo> queryUserInfoByLimit(UserDto dto) throws BusinessException {
        PageHelper.startPage(dto.getPageIndex(), dto.getPageSize());
        List<UserVo> userVoList = userMapper.queryUserInfo(dto);
        PageInfo<UserVo> page = new PageInfo<UserVo>(userVoList);
        return page;

    }

    public boolean addUser(UserDto dto) throws BusinessException {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return userMapper.insertSelective(user) > 0;
    }

    public UserVo queryUserInfoById(UserDto dto) throws BusinessException {
        List<UserVo> userVoList = userMapper.queryUserInfo(dto);
        if(CollectionUtils.isEmpty(userVoList)){
            return null;
        }
        return userVoList.get(0);
    }

    public boolean updateUserByUserId(UserDto dto) throws BusinessException{
        Example example = new Example(User.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", dto.getUserId());
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return userMapper.updateByExampleSelective(user, example) > 0;
    }
}
