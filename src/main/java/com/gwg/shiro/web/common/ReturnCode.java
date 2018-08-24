package com.gwg.shiro.web.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回码枚举类
 */
public enum ReturnCode {

	SUCCESS("success", "200"), //
	NO_LOGON("该用户未登录", "9560"), //
	PASSWORD_ERROR("密码错误", "9563"), //
	LOGIN_FAIED("登录失败，该用户已被冻结", "9564"), //
	LOGIN_ERR("登录用户权限不对,只允许坐席登录", "9566"),
	UNKOWN_USER("该用户不存在", "9565"), //
	PARAMETER_ERROR("参数有误", "9562"), //
	BUSSINESS_ERROR("业务异常", "8000"), //
	ERROR("系统异常", "9999");

	@Setter
	@Getter
	private String message;
	@Setter
	@Getter
	private String code;

	private ReturnCode(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public static String getMessage(String code) {
		for (ReturnCode c : ReturnCode.values()) {
			if (c.getCode().equals(code)) {
				return c.message;
			}
		}
		return null;
	}
}
