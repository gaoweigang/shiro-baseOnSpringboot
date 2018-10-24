package com.gwg.shiro.web.service;


import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.vo.CusMapVo;


import java.util.List;

public interface RoleResourceService {

    //查询角色与资源的映射
    public List<CusMapVo> queryAllRoleResourceMap() throws BusinessException;
}
