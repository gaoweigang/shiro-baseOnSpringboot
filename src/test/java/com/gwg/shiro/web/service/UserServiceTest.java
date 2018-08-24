package com.gwg.shiro.web.service;

import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testAddUserInfo() throws BusinessException {

        UserDto dto = new UserDto();
        dto.setUserId("13817191469");
        dto.setUsername("高伟刚");
        dto.setCardNo("420881199101095174");
        dto.setPassword("weiganggao");
        dto.setConfirmPassword("weiganggao");
        dto.setEmail("13817191469@163.com");
        dto.setEntryTime(new Date());
        dto.setMobile("13817191469");
        dto.setRoleCode("test2");
        dto.setRoleName("测试2");
        userService.addUserInfo(dto);

    }



    @Test
    public void testUpdateUserInfo() throws BusinessException{

        UserDto dto = new UserDto();
        dto.setUserId("13817191469");
        dto.setUsername("曾宪洲");
        dto.setCardNo("420881199101095173");
        dto.setPassword("weiganggao111");
        dto.setConfirmPassword("weiganggao");
        dto.setEmail("13817191469@163.com");
        dto.setEntryTime(new Date());
        dto.setMobile("13817191469");
        dto.setRoleCode("test4");
        dto.setRoleName("测试4");

        userService.updateUserInfo(dto);
    }
}
