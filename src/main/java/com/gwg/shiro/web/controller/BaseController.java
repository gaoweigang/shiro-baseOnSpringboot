package com.gwg.shiro.web.controller;

import com.gwg.shiro.web.common.Constant;
import com.gwg.shiro.web.config.shiro.AuthUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class BaseController {

    /**
     * 获取当前登录用户信息
     * @return
     */
    protected AuthUser getCurrentUser() {
        Session session = SecurityUtils.getSubject().getSession();
        AuthUser authUser = (AuthUser) session.getAttribute(Constant.AUTH_USER_KEY);
        return authUser;
    }

    /**
     * 获取当前登录userid
     * @return
     */
    protected String getCurrentUserId() {
        AuthUser authUser = getCurrentUser();
        if (null != authUser) {
            return authUser.getUserId();
        }
        return null;
    }

    /**
     * 获取当前登录用户名
     * @return
     */
    protected String getCurrentUsername() {
        AuthUser authUser = getCurrentUser();
        if (null != authUser) {
            return authUser.getUsername();
        }
        return null;
    }

}
