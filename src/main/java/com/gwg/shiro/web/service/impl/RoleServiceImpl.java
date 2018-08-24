package com.gwg.shiro.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.common.ReturnCode;
import com.gwg.shiro.web.dao.ResourceDao;
import com.gwg.shiro.web.dao.RoleDao;
import com.gwg.shiro.web.dao.RoleResourceDao;
import com.gwg.shiro.web.dao.UserDao;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.model.Role;
import com.gwg.shiro.web.model.RoleResource;
import com.gwg.shiro.web.service.RoleService;
import com.gwg.shiro.web.vo.RoleVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * service进行页面逻辑处理
 */
@Component
@Transactional
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private RoleResourceDao roleResourceDao;
    @Autowired
    private UserDao userDao;


    @Override
    public boolean addRole(RoleDto dto) throws BusinessException {

        return roleDao.addRole(dto);
    }

    @Override
    public boolean updateRoleById(RoleDto dto) throws BusinessException{

        return roleDao.updateRoleById(dto);
    }

    @Override
    public PageInfo<Role> queryRoleByLimit(RoleDto dto) throws BusinessException{
        return roleDao.queryRoleByLimit(dto);
    }

    @Override
    public boolean delRoleById(RoleDto dto) throws BusinessException{

        return roleDao.delRoleById(dto);
    }

    /**
     * 根据条件查询用户角色
     */
    public Role queryRoleById(RoleDto dto) throws BusinessException{
        return roleDao.queryRoleById(dto);
    }

    /**
     * 获取角色相关的所有资源
     */
    public RoleVo queryRoleRelatedAllResById(RoleDto dto) throws BusinessException {

        Role role = roleDao.queryRoleById(dto);
        if(role == null){
            throw new BusinessException(ReturnCode.BUSSINESS_ERROR.getCode(), ReturnCode.BUSSINESS_ERROR.getMessage());
        }
        List<Resource> resourceList = roleResourceDao.queryResourceListByRoleId(dto);
        List<Long> resourceIdList = resourceList.stream().map(x -> x.getId()).collect(Collectors.toList());

        RoleVo vo = new RoleVo();
        BeanUtils.copyProperties(role, vo);
        vo.setResourceIdList(resourceIdList);
        return vo;

    }

    /**
     * 授权
     * @param dto
     * @throws BusinessException
     */
    public void grantResources(RoleDto dto) throws BusinessException{
        List<Long> newResIdList = dto.getResourceIdList();
        List<Resource> resourceList = roleResourceDao.queryResourceListByRoleId(dto);
        List<Long> oldResIdList = resourceList.stream().map(x -> x.getId()).collect(Collectors.toList());

        //需要删除的
        List<Long> delResIdList = oldResIdList.stream().filter(x -> !newResIdList.contains(x)).collect(Collectors.toList());

        //需要新增的
        List<Long> addResIdList = newResIdList.stream().filter(x -> !oldResIdList.contains(x)).collect(Collectors.toList());
        logger.info("角色：{},需要删除的资源集合:{}, 需要新增的资源集合：{}", dto.getRoleCode(), JSON.toJSON(delResIdList), JSON.toJSON(addResIdList));

        if(!CollectionUtils.isEmpty(delResIdList)){
            //需要删除的角色资源关系
            List<String> delResCodeList = resourceList.stream().filter(x -> delResIdList.contains(x.getId())).map(x -> x.getResCode()).collect(Collectors.toList());
            //批量删除
            roleResourceDao.batchDelRoleResource(dto.getRoleCode(), delResCodeList);
        }
        if(!CollectionUtils.isEmpty(addResIdList)){
            //根据resourceId查询资源
            List<Resource> addResourceList = resourceDao.queryResourceListByIds(addResIdList);
            //需要新增的角色资源关系
            List<String> addResCodeList = addResourceList.stream().map(x -> x.getResCode()).collect(Collectors.toList());
            for(String resCode : addResCodeList){
                //新怎角色资源映射
                roleResourceDao.addRoleResource(dto.getRoleCode(), resCode);
            }
        }

    }

}
