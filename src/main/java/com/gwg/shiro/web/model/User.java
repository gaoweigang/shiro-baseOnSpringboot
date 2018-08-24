package com.gwg.shiro.web.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tbl_user")
public class User implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
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
    @Column(name = "card_no")
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
    @Column(name = "valid_flag")
    private Boolean validFlag;

    /**
     * 入职时间
     */
    @Column(name = "entry_time")
    private Date entryTime;

    /**
     * 离职日期
     */
    @Column(name = "resign_time")
    private Date resignTime;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取员工姓名
     *
     * @return username - 员工姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置员工姓名
     *
     * @param username 员工姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取身份证号
     *
     * @return card_no - 身份证号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置身份证号
     *
     * @param cardNo 身份证号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话
     *
     * @return mobile - 电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置电话
     *
     * @param mobile 电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取职位
     *
     * @return position - 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取记录是否有效 1:有效, 0:无效(销户)
     *
     * @return valid_flag - 记录是否有效 1:有效, 0:无效(销户)
     */
    public Boolean getValidFlag() {
        return validFlag;
    }

    /**
     * 设置记录是否有效 1:有效, 0:无效(销户)
     *
     * @param validFlag 记录是否有效 1:有效, 0:无效(销户)
     */
    public void setValidFlag(Boolean validFlag) {
        this.validFlag = validFlag;
    }

    /**
     * 获取入职时间
     *
     * @return entry_time - 入职时间
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * 设置入职时间
     *
     * @param entryTime 入职时间
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * 获取离职日期
     *
     * @return resign_time - 离职日期
     */
    public Date getResignTime() {
        return resignTime;
    }

    /**
     * 设置离职日期
     *
     * @param resignTime 离职日期
     */
    public void setResignTime(Date resignTime) {
        this.resignTime = resignTime;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}