package com.gwg.shiro.web.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.gwg.shiro.web.common.Result;
import com.gwg.shiro.web.common.ReturnCode;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */
public class MyAccessControlFilter extends FormAuthenticationFilter {

	private static final Logger logger = LoggerFactory.getLogger(MyAccessControlFilter.class);

	/**
	 * 重写：如果用户没有登陆，则直接提示用户没有登陆，不进行跳转登陆页面
	 */
	@Override
	protected void saveRequestAndRedirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		logger.info("saveRequestAndRedirectToLogin start....");
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			Result<?> result = new Result();
			result.setStatus(false);
			result.setStatusCode(ReturnCode.NO_LOGON.getCode());
			result.setMessage(ReturnCode.NO_LOGON.getMessage());
			writer.write(JSONObject.toJSONString(result));
		} catch(Exception e){
			e.printStackTrace();
		}
		return;
	}

}