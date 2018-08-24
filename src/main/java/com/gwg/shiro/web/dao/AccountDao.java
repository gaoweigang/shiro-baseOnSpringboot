package com.gwg.shiro.web.dao;

import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Account;

public interface AccountDao {

    public Account queryAccountByUserid(String userid) throws BusinessException;

    public boolean addAccount(UserDto dto) throws BusinessException;

    public boolean updateAccountByUserId(UserDto dto) throws BusinessException;


}
