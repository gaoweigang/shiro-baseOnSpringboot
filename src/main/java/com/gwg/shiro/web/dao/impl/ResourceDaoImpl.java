package com.gwg.shiro.web.dao.impl;

import com.gwg.shiro.web.dao.ResourceDao;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.mapper.ResourceMapper;
import com.gwg.shiro.web.mapper.UserMapper;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.model.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class ResourceDaoImpl implements ResourceDao {

    @Autowired
    private ResourceMapper resouceMapper;

    public List<Resource> queryAllResources() throws BusinessException{
        Example example = new Example(Resource.class);
        example.createCriteria().andEqualTo("validFlag", true);
        return resouceMapper.selectByExample(example);

    }

    public List<Resource> queryResourceListByIds(List<Long> idList) throws BusinessException{
        Example example = new Example(Resource.class);
        example.createCriteria().andIn("id", idList);
        return resouceMapper.selectByExample(example);
    }


    public List<Resource> queryCurrentUserMenu(String userId) throws BusinessException {
        return resouceMapper.queryCurrentUserMenu(userId);
    }
}
