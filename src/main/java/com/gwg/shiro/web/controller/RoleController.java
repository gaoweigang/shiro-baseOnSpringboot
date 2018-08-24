package com.gwg.shiro.web.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.common.PageResult;
import com.gwg.shiro.web.common.Result;
import com.gwg.shiro.web.common.ReturnCode;
import com.gwg.shiro.web.dto.RoleDto;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.Role;
import com.gwg.shiro.web.model.UserRole;
import com.gwg.shiro.web.service.RoleService;
import com.gwg.shiro.web.util.ParamUtil;
import com.gwg.shiro.web.vo.RoleVo;
import com.gwg.shiro.web.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({ "/role" })
public class RoleController {

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public Result addRole(@RequestBody RoleDto dto) {

		try {
			//参数去除空格
			ParamUtil.trim(dto);
			//参数校验
			if(ParamUtil.isEmpty(dto.getRoleCode(), dto.getRoleName())){
                 return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());
			}
			roleService.addRole(dto);
			return new Result(true, ReturnCode.SUCCESS.getMessage(), null, ReturnCode.SUCCESS.getCode());
		} catch (BusinessException e) {
			logger.error("异常，请求参数：{}，异常信息：{}", JSON.toJSON(dto), e.getMessage());
			return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());

		}
	}

	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public Result updateRole(@RequestBody RoleDto dto) {
		try {
			//参数去除空格
			ParamUtil.trim(dto);
			//参数校验
			if(ParamUtil.isEmpty(dto.getRoleCode(), dto.getRoleName())){
				return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());
			}
			roleService.updateRoleById(dto);
			return new Result(true, ReturnCode.SUCCESS.getMessage(), null, ReturnCode.SUCCESS.getCode());
		} catch (BusinessException e) {
			logger.error("异常，请求参数：{}，异常信息：{}", JSON.toJSON(dto), e.getMessage());
			return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());

		}
	}

	/**
	 * 根据条件查询角色信息
	 */
  	@RequestMapping(value = "/queryRoleByLimit", method = RequestMethod.GET)
	public Result queryRoleByLimit(@RequestBody RoleDto dto) {
		try {
			//参数去除空格
			ParamUtil.trim(dto);
			//参数校验
			if(ParamUtil.isEmpty(dto.getRoleCode(), dto.getRoleName())){
				return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());
			}
			PageInfo<Role> page = roleService.queryRoleByLimit(dto);
			return new Result(true, ReturnCode.SUCCESS.getMessage(), new PageResult(page.getTotal(), page.getList()), ReturnCode.SUCCESS.getCode());
		} catch (BusinessException e) {
			logger.error("异常，请求参数：{}，异常信息：{}", JSON.toJSON(dto), e.getMessage());
			return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());

		}

	}

	/**
	 * 删除角色
	 */
	@RequestMapping(value = "/delRole", method = RequestMethod.POST)
	public Result delRole(@RequestBody RoleDto dto) {
		try {
			//参数校验
			if(ParamUtil.isEmpty(dto.getId())){
				return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());
			}
			roleService.delRoleById(dto);
			return new Result(true, ReturnCode.SUCCESS.getMessage(), null, ReturnCode.SUCCESS.getCode());
		} catch (BusinessException e) {
			logger.error("异常，请求参数：{}，异常信息：{}", JSON.toJSON(dto), e.getMessage());
			return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());

		}

	}

	/**
	 * 查询角色具有哪些资源权限- 用于前端显示用
	 * @return
	 */
	@RequestMapping(value = "/queryRoleRelatedAllResById", method = RequestMethod.POST)
	public Result queryRoleRelatedAllResById(@RequestBody RoleDto dto) {

		try {
			//参数校验
			if(ParamUtil.isEmpty(dto.getId())){
				return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());

			}
			RoleVo vo = roleService.queryRoleRelatedAllResById(dto);
			return new Result(true, ReturnCode.SUCCESS.getMessage(), vo, ReturnCode.SUCCESS.getCode());
		} catch (BusinessException e) {
			logger.error("异常，请求参数：{}，异常信息：{}", JSON.toJSON(dto), e.getMessage());
			return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());

		}
	}

	/**
	 * 给角色授予资源权限
	 * @param dto
	 * @return
	 */
	@ApiOperation(value = "授予权限")
	@RequestMapping(value = "/grantResources", method = RequestMethod.POST)
	public Result<?> grantResources(@RequestBody RoleDto dto) {

		try {
			if(ParamUtil.isEmpty(dto.getId())){
				return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());
			}
			roleService.grantResources(dto);
			//shiroService.updatePermission(); 刷新shiro权限
			return new Result(true, ReturnCode.SUCCESS.getMessage(), null, ReturnCode.SUCCESS.getCode());
		} catch (BusinessException e) {
			logger.error("异常，请求参数：{}，异常信息：{}", JSON.toJSON(dto), e.getMessage());
			return new Result(false, ReturnCode.PARAMETER_ERROR.getMessage(), null, ReturnCode.PASSWORD_ERROR.getCode());

		}
	}
}
