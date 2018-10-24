package com.gwg.shiro.web.common;

public class Constant {

    //坐席角色，有这个角色说明是坐席
    public static final String TSR_OPERATOR = "TSR";

    public static final String COMMA = ",";

    public static final String ROLE_FORMAT = "roles[{0}]";

    //用户当前状态(0：正常，1：密码过期，2：账户已冻结，3：已销户)
    public static final String ACCOUNT_VALID = "0";//正常
    public static final String ACCOUNT_EXPIRE = "1";//密码过期
    public static final String ACCOUNT_SUSPEND = "2";//账户已冻结
    public static final String ACCOUNT_CLOSE = "3";//已销户
}
