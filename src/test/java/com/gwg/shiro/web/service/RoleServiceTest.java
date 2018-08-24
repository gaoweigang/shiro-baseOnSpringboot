package com.gwg.shiro.web.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Role;
import com.gwg.shiro.web.vo.RoleVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceTest.class);

    @Autowired
    private RoleService roleService;

    @Test
    public void testAddRole() throws BusinessException {
        RoleDto dto = new RoleDto();
        dto.setRoleCode("test");
        dto.setRoleName("测试");
        dto.setRemark("测试");
        boolean flag = roleService.addRole(dto);
        logger.info("添加角色，参数：{}, 结果：{}", JSON.toJSON(dto), JSON.toJSON(flag));

    }

    @Test
    public void testUpdateRole() throws BusinessException{
        RoleDto dto = new RoleDto();
        dto.setId(1L);
        dto.setRoleCode("test1");
        dto.setRoleName("测试1");
        dto.setRemark("测试1");
        boolean flag = roleService.updateRoleById(dto);
        logger.info("根据id更新， 参数：{}, 结果：{}", JSON.toJSON(dto), JSON.toJSON(flag));
    }

    @Test
    public void testQueryRoleByLimit() throws BusinessException{
        RoleDto dto = new RoleDto();
        dto.setPageIndex(1);
        dto.setPageSize(2);
        PageInfo<Role> pageInfo = roleService.queryRoleByLimit(dto);
        logger.info("分页查询， 参数：{}, 结果：{}", JSON.toJSON(dto), JSON.toJSON(pageInfo));
    }

    @Test
    public void testDelRole() throws BusinessException{
        RoleDto dto = new RoleDto();
        dto.setId(29L);
        boolean flag  = roleService.delRoleById(dto);
        logger.info("根据ID删除，参数：{}, 结果：{}", JSON.toJSON(dto), JSON.toJSON(flag));

    }
    @Test
    public void testQueryRoleById() throws BusinessException{
        RoleDto dto = new RoleDto();
        dto.setId(1L);
        Role role = roleService.queryRoleById(dto);
        logger.info("根据id查询，参数：{}, 结果：{}", JSON.toJSON(dto), JSON.toJSON(role));


    }


    @Test
    public void testQueryRoleRelatedAllResById(){
        RoleDto dto = new RoleDto();
        dto.setId(2L);
        RoleVo vo = roleService.queryRoleRelatedAllResById(dto);
        logger.info("根据id查询，参数：{}, 结果：{}", JSON.toJSON(dto), JSON.toJSON(vo));

    }

    @Test
    public void testGrantResources(){
        RoleDto dto = new RoleDto();
        dto.setId(1L);
        dto.setRoleCode("test");
        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);
        dto.setResourceIdList(idList);
        roleService.grantResources(dto);
        logger.info("根据id查询，参数：{}, 结果：{}", JSON.toJSON(dto));
    }


}
