package com.gwg.shiro.web.mapper;

import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.User;
import com.gwg.shiro.web.vo.UserVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    /**
     * 根据条件分页查询用户信息
     * @param dto
     * @return
     */
    public List<UserVo> queryUserInfo(UserDto dto) throws BusinessException;


}