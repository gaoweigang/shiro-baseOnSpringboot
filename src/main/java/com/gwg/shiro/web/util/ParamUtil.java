package com.gwg.shiro.web.util;

import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.vo.UserVo;
import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class ParamUtil {

    /*
     * 参数非空校验:
     * String类型
     * 非String
     */
    public static boolean isEmpty(Object... objs){
        //非空校验
        if(objs == null || objs.length == 0){
            return true;
        }
        return Stream.of(objs).filter(obj -> {return (obj instanceof String)? StringUtils.isEmpty((String)obj) : obj == null;}).count() > 0;
    }

    /**
     * 字符串去前后空格
     */
    public static void trim(Object obj){
        if(obj == null){
            return;
        }
        try {
            BeanInfo bi = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] pds = bi.getPropertyDescriptors();
            for(PropertyDescriptor p : pds){
                Method getMethod = p.getReadMethod();
                Method setMethod = p.getWriteMethod();
                Object value = getMethod.invoke(obj, null);
                if(null != value && StringUtils.equals(p.getPropertyType().getTypeName(), String.class.getTypeName())){//同一个类加载器加载的class对象相同
                    setMethod.invoke(obj, ((String) value).trim());
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws Exception{
        System.out.println(String.class.getTypeName());

        UserVo userVo = new UserVo();
        userVo.setCardNo("123132  ");
        userVo.setUserId(null);
        userVo.setUsername("");
        System.out.println(userVo.getCardNo().length());
        trim(userVo);
        System.out.println(userVo.getCardNo().length());


       /* BeanInfo bi = Introspector.getBeanInfo(UserVo.class);
        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        for(PropertyDescriptor p : pds){
            Method getMethod = p.getReadMethod();
            Method setMethod = p.getWriteMethod();
            Object obj = getMethod.invoke(userVo, null);
            if(obj instanceof String){
                setMethod.invoke(userVo, ((String) obj).trim());
            }
        }*/
    }

}
