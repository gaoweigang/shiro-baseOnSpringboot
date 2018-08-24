package com.gwg.shiro.web.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.common.PageResult;
import com.gwg.shiro.web.common.Result;
import com.gwg.shiro.web.common.ReturnCode;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Resource;
import com.gwg.shiro.web.model.Role;
import com.gwg.shiro.web.service.ResourceService;
import com.gwg.shiro.web.service.RoleService;
import com.gwg.shiro.web.util.ParamUtil;
import com.gwg.shiro.web.vo.RoleVo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({ "/resource" })
public class ResourceController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

	@Autowired
	private ResourceService resourceService;

	/**
	 * 在登陆之后调用 -- 初始化资源
	 * @return
	 */
	@RequestMapping(value = "/queryAllResources", method = RequestMethod.GET)
	public Result queryAllResources() {

		try {
			List<Resource> resourceList = resourceService.queryAllResources();
			return new Result(true, ReturnCode.SUCCESS.getMessage(), resourceList, ReturnCode.SUCCESS.getCode());
		} catch (BusinessException e) {
			logger.error("异常:{}", e.getMessage());
			return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());

		}
	}


	/**
	 * 登陆成功之后根据用户角色获取菜单
	 */
	@ApiOperation(value = "加载菜单")
	@RequestMapping(value = "/queryCurrentUserMenu", method = RequestMethod.GET)
	public Result queryCurrentUserMenu(){

		try {
			List<Resource> resourceList = resourceService.queryCurrentUserMenu(this.getCurrentUserId());
			return new Result(true, ReturnCode.SUCCESS.getMessage(), resourceList, ReturnCode.SUCCESS.getCode());
		} catch (Exception e) {
			logger.error("异常:{}", e.getMessage());
			return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());
		}

	}



}
