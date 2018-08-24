package com.gwg.shiro.web.dao;

import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.User;
import com.gwg.shiro.web.vo.UserVo;

import java.util.List;

public interface UserDao {

    public User queryUserByUserid(String userid);

    /**
     * 分页查询-根据条件查询用户信息
     */
    public PageInfo<UserVo> queryUserInfoByLimit(UserDto dto) throws BusinessException;

    /**
     * 新增-用户
     */
    public boolean addUser(UserDto dto) throws BusinessException;

    /**
     * 根据userid查询用户信息
     */
    public UserVo queryUserInfoById(UserDto dto) throws BusinessException;

    /**
     * 根据userId更新User
     */
    public boolean updateUserByUserId(UserDto dto) throws BusinessException;

}
