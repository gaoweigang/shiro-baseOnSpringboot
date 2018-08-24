package com.gwg.shiro.web.dao.impl;

import com.gwg.shiro.web.dao.RoleResourceDao;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.mapper.RoleResourceMapper;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.model.RoleResource;
import com.gwg.shiro.web.vo.RoleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class RoleResourceDaoImpl implements RoleResourceDao{

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public List<Resource> queryResourceListByRoleId(RoleDto dto) throws BusinessException {

        return roleResourceMapper.queryResourceListByRoleId(dto);

    }

    public boolean batchDelRoleResource(String roleCode, List<String> resCodeList) throws BusinessException{
        Example example = new Example(RoleResource.class);
        example.createCriteria().andEqualTo("roleCode", roleCode).andIn("resCode", resCodeList);
        return roleResourceMapper.deleteByExample(example) > 0;
    }

    public boolean addRoleResource(String roleCode, String resCode) throws BusinessException{
        if(StringUtils.isEmpty(roleCode) || StringUtils.isEmpty(resCode)){
            return false;
        }
        RoleResource roleResource = new RoleResource();
        roleResource.setRoleCode(roleCode);
        roleResource.setResCode(resCode);
        return roleResourceMapper.insertSelective(roleResource) > 0;
    }


}
