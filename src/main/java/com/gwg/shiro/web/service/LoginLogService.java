package com.gwg.shiro.web.service;

import com.gwg.shiro.web.model.User;

public interface LoginLogService {

    /**
     * 记录登陆日志
     * @param user
     */
    public void recordLoginLog(User user);

}
