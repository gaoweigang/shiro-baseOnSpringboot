package com.gwg.shiro.web.mapper;

import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.model.RoleResource;
import com.gwg.shiro.web.vo.CusMapVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleResourceMapper extends Mapper<RoleResource> {

    public List<Resource> queryResourceListByRoleId(RoleDto dto) throws BusinessException;

    /**
     * 获取所有的角色与资源的映射
     * @return
     * @throws BusinessException
     */
    public List<CusMapVo> queryAllRoleResourceMap() throws BusinessException;
}