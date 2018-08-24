package com.gwg.shiro.web.dao;

import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.model.RoleResource;
import com.gwg.shiro.web.vo.RoleVo;
import org.springframework.stereotype.Component;

import java.util.List;


public interface RoleResourceDao {

    public List<Resource> queryResourceListByRoleId(RoleDto dto) throws BusinessException;

    public boolean batchDelRoleResource(String roleCode, List<String> resCode) throws BusinessException;

    public boolean addRoleResource(String roleCode, String resCode) throws BusinessException;


}
