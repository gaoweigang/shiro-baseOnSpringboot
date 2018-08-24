package com.gwg.shiro.web.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVo implements Serializable{

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 员工姓名
     */
    private String username;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 身份证号
     */
    private String cardNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 职位
     */
    private String position;

    /**
     * 状态： 1,在职， 0,离职
     */
    private Integer status;

    /**
     * 记录是否有效 1:有效, 0:无效(销户)
     */
    private Boolean validFlag;

    /**
     * 入职时间
     */
    private Date entryTime;

    /**
     * 离职日期
     */
    private Date resignTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 描述
     */
    private String desc;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;



}
