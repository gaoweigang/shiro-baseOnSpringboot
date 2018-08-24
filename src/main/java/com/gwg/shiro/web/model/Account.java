package com.gwg.shiro.web.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tbl_account")
public class Account implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户登录id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 密码连续错误次数
     */
    private Boolean errpwdcount;

    /**
     * 最近成功登陆时间
     */
    private Date lastlogintime;

    /**
     * 最近密码更换时间
     */
    private Date lastupdatepwdtime;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户起用日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 用户停用日期
     */
    @Column(name = "stop_date")
    private Date stopDate;

    /**
     * 用户当前状态(0：正常，1：密码过期，2：账户已冻结，3：已销户)
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 有效标志 1：有效，0：无效 表示停用
     */
    @Column(name = "valid_flag")
    private Boolean validFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
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
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户登录id
     *
     * @return user_id - 用户登录id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户登录id
     *
     * @param userId 用户登录id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取密码连续错误次数
     *
     * @return errpwdcount - 密码连续错误次数
     */
    public Boolean getErrpwdcount() {
        return errpwdcount;
    }

    /**
     * 设置密码连续错误次数
     *
     * @param errpwdcount 密码连续错误次数
     */
    public void setErrpwdcount(Boolean errpwdcount) {
        this.errpwdcount = errpwdcount;
    }

    /**
     * 获取最近成功登陆时间
     *
     * @return lastlogintime - 最近成功登陆时间
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * 设置最近成功登陆时间
     *
     * @param lastlogintime 最近成功登陆时间
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * 获取最近密码更换时间
     *
     * @return lastupdatepwdtime - 最近密码更换时间
     */
    public Date getLastupdatepwdtime() {
        return lastupdatepwdtime;
    }

    /**
     * 设置最近密码更换时间
     *
     * @param lastupdatepwdtime 最近密码更换时间
     */
    public void setLastupdatepwdtime(Date lastupdatepwdtime) {
        this.lastupdatepwdtime = lastupdatepwdtime;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户起用日期
     *
     * @return start_date - 用户起用日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置用户起用日期
     *
     * @param startDate 用户起用日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取用户停用日期
     *
     * @return stop_date - 用户停用日期
     */
    public Date getStopDate() {
        return stopDate;
    }

    /**
     * 设置用户停用日期
     *
     * @param stopDate 用户停用日期
     */
    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    /**
     * 获取用户当前状态(0：正常，1：密码过期，2：账户已冻结，3：已销户)
     *
     * @return user_status - 用户当前状态(0：正常，1：密码过期，2：账户已冻结，3：已销户)
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户当前状态(0：正常，1：密码过期，2：账户已冻结，3：已销户)
     *
     * @param userStatus 用户当前状态(0：正常，1：密码过期，2：账户已冻结，3：已销户)
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取有效标志 1：有效，0：无效 表示停用
     *
     * @return valid_flag - 有效标志 1：有效，0：无效 表示停用
     */
    public Boolean getValidFlag() {
        return validFlag;
    }

    /**
     * 设置有效标志 1：有效，0：无效 表示停用
     *
     * @param validFlag 有效标志 1：有效，0：无效 表示停用
     */
    public void setValidFlag(Boolean validFlag) {
        this.validFlag = validFlag;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}