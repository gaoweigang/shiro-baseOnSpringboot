package com.gwg.shiro.web.exception;


public class BusinessException extends BaseException {

    public static final String ERR_DEF="ERR001";

    public BusinessException(String code, String msg) {
        super(code,msg);
    }
    public static BusinessException getInstance(String patterm, Object... args) {
        String msg = java.text.MessageFormat.format(patterm,args);
        return new BusinessException(ERR_DEF,msg);
    }
    public static BusinessException getInstance(Throwable e,String patterm, Object... args) {
        String msg = java.text.MessageFormat.format(patterm,args);
        return new BusinessException(ERR_DEF,msg,e);
    }

    public BusinessException(String code, String msg,Throwable e) {
        super(code,msg,e);
    }
    public BusinessException(Throwable e,String msg) {
        super(ERR_DEF,msg,e);
    }
    public BusinessException(Throwable e,String msg,Object... objects) {

        super(ERR_DEF,msg,e);
    }
}
