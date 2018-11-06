package com.gwg.shiro.web.dao.impl;

import com.gwg.shiro.web.common.Constant;
import com.gwg.shiro.web.dao.AccountDao;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.mapper.AccountMapper;
import com.gwg.shiro.web.model.Account;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.Date;
import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountMapper accountMapper;

    public Account queryAccountByUserId(String userId) throws BusinessException {
        if(StringUtils.isEmpty(userId)){
            return null;
        }
        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        criteria.andEqualTo("validFlag", true);//有效
        criteria.andEqualTo("userStatus", Constant.ACCOUNT_VALID);//有效
        List<Account> userList = accountMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)){
            return null;
        }

        return userList.get(0);
    }

    public boolean addAccount(UserDto dto) throws BusinessException{
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        account.setCreateTime(new Date());
        account.setModifyTime(new Date());
        return accountMapper.insertSelective(account) > 0;

    }

    public boolean updateAccountByUserId(UserDto dto) throws BusinessException{
        Example example = new Example(Account.class);
        Criteria criteria =example.createCriteria();
        criteria.andEqualTo("userId", dto.getUserId());
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        return accountMapper.updateByExampleSelective(account, example) > 0;
    }


}
