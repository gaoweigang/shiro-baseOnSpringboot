package com.gwg.shiro.web.config.shiro;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class AuthUser implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "USERID")
    private String userid;

    /**
     * 密码
     */
    private String password;

    /**
     * 机构id
     */
    @Column(name = "BRANCHID")
    private String branchid;

    /**
     * 坐席别名
     */
    @Column(name = "BYNAME")
    private String byname;

    /**
     * 创建时间
     */
    @Column(name = "CREATETIME")
    private Date createtime;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 电话
     */
    @Column(name = "MOBILE")
    private String mobile;

    /**
     * 办公电话
     */
    @Column(name = "OFFICEPHONE")
    private String officephone;

    /**
     * 职位
     */
    @Column(name = "POSITION")
    private String position;

    /**
     * 性别
     */
    @Column(name = "SEX")
    private String sex;

    /**
     * 坐席等级（12345对应ABCDE, 存储于字典表中。DICTYPEID='SKILLLEVELDIC'）
     */
    @Column(name = "SKILLLEVEL")
    private String skilllevel;

    /**
     * 座席姓名
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * acd技能组
     */
    @Column(name = "VALIDCHGREASON")
    private String validchgreason;

    /**
     * 可用标志 1:有效, 0:无效(销户)
     */
    @Column(name = "VALIDFLAG")
    private String validflag;

    /**
     * 缺省的aftercallwork时长(秒)
     */
    @Column(name = "ACDQUEUE")
    private String acdqueue;

    /**
     * 电话中心参数定义
     */
    @Column(name = "ACDUSERID")
    private String acduserid;

    /**
     *
     */
    @Column(name = "ACDUSERPWD")
    private String acduserpwd;

    /**
     * 变更原因
     */
    @Column(name = "ACWSECONDS")
    private String acwseconds;

    /**
     * 是否是班长
     */
    @Column(name = "USERTYPE")
    private String usertype;

    /**
     * 是否初审（1为要初审，0为不初审可直接提核）
     */
    private String trial;

    /**
     * 订单号
     */
    @Column(name = "orderNo")
    private String orderno;

    /**
     * 记录 有效的 职工 的 入职月份
     */
    @Column(name = "entryMonth")
    private Integer entrymonth;

    /**
     * 入职时间
     */
    @Column(name = "entryTime")
    private Date entrytime;

    /**
     * 注销时间
     */
    @Column(name = "destoryTime")
    private Date destorytime;

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
     * @return USERID - 用户id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取机构id
     *
     * @return BRANCHID - 机构id
     */
    public String getBranchid() {
        return branchid;
    }

    /**
     * 设置机构id
     *
     * @param branchid 机构id
     */
    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    /**
     * 获取坐席别名
     *
     * @return BYNAME - 坐席别名
     */
    public String getByname() {
        return byname;
    }

    /**
     * 设置坐席别名
     *
     * @param byname 坐席别名
     */
    public void setByname(String byname) {
        this.byname = byname;
    }

    /**
     * 获取创建时间
     *
     * @return CREATETIME - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取邮箱
     *
     * @return EMAIL - 邮箱
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
     * @return MOBILE - 电话
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
     * 获取办公电话
     *
     * @return OFFICEPHONE - 办公电话
     */
    public String getOfficephone() {
        return officephone;
    }

    /**
     * 设置办公电话
     *
     * @param officephone 办公电话
     */
    public void setOfficephone(String officephone) {
        this.officephone = officephone;
    }

    /**
     * 获取职位
     *
     * @return POSITION - 职位
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
     * 获取性别
     *
     * @return SEX - 性别
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
     * 获取坐席等级（12345对应ABCDE, 存储于字典表中。DICTYPEID='SKILLLEVELDIC'）
     *
     * @return SKILLLEVEL - 坐席等级（12345对应ABCDE, 存储于字典表中。DICTYPEID='SKILLLEVELDIC'）
     */
    public String getSkilllevel() {
        return skilllevel;
    }

    /**
     * 设置坐席等级（12345对应ABCDE, 存储于字典表中。DICTYPEID='SKILLLEVELDIC'）
     *
     * @param skilllevel 坐席等级（12345对应ABCDE, 存储于字典表中。DICTYPEID='SKILLLEVELDIC'）
     */
    public void setSkilllevel(String skilllevel) {
        this.skilllevel = skilllevel;
    }

    /**
     * 获取座席姓名
     *
     * @return USERNAME - 座席姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置座席姓名
     *
     * @param username 座席姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取acd技能组
     *
     * @return VALIDCHGREASON - acd技能组
     */
    public String getValidchgreason() {
        return validchgreason;
    }

    /**
     * 设置acd技能组
     *
     * @param validchgreason acd技能组
     */
    public void setValidchgreason(String validchgreason) {
        this.validchgreason = validchgreason;
    }

    /**
     * 获取可用标志 1:有效, 0:无效(销户)
     *
     * @return VALIDFLAG - 可用标志 1:有效, 0:无效(销户)
     */
    public String getValidflag() {
        return validflag;
    }

    /**
     * 设置可用标志 1:有效, 0:无效(销户)
     *
     * @param validflag 可用标志 1:有效, 0:无效(销户)
     */
    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    /**
     * 获取缺省的aftercallwork时长(秒)
     *
     * @return ACDQUEUE - 缺省的aftercallwork时长(秒)
     */
    public String getAcdqueue() {
        return acdqueue;
    }

    /**
     * 设置缺省的aftercallwork时长(秒)
     *
     * @param acdqueue 缺省的aftercallwork时长(秒)
     */
    public void setAcdqueue(String acdqueue) {
        this.acdqueue = acdqueue;
    }

    /**
     * 获取电话中心参数定义
     *
     * @return ACDUSERID - 电话中心参数定义
     */
    public String getAcduserid() {
        return acduserid;
    }

    /**
     * 设置电话中心参数定义
     *
     * @param acduserid 电话中心参数定义
     */
    public void setAcduserid(String acduserid) {
        this.acduserid = acduserid;
    }

    /**
     * 获取密码
     *
     * @return ACDUSERPWD - 密码
     */
    public String getAcduserpwd() {
        return acduserpwd;
    }

    /**
     * 设置密码
     *
     * @param acduserpwd 密码
     */
    public void setAcduserpwd(String acduserpwd) {
        this.acduserpwd = acduserpwd;
    }

    /**
     * 获取变更原因
     *
     * @return ACWSECONDS - 变更原因
     */
    public String getAcwseconds() {
        return acwseconds;
    }

    /**
     * 设置变更原因
     *
     * @param acwseconds 变更原因
     */
    public void setAcwseconds(String acwseconds) {
        this.acwseconds = acwseconds;
    }

    /**
     * 获取是否是班长
     *
     * @return USERTYPE - 是否是班长
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * 设置是否是班长
     *
     * @param usertype 是否是班长
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * 获取是否初审（1为要初审，0为不初审可直接提核）
     *
     * @return trial - 是否初审（1为要初审，0为不初审可直接提核）
     */
    public String getTrial() {
        return trial;
    }

    /**
     * 设置是否初审（1为要初审，0为不初审可直接提核）
     *
     * @param trial 是否初审（1为要初审，0为不初审可直接提核）
     */
    public void setTrial(String trial) {
        this.trial = trial;
    }

    /**
     * 获取订单号
     *
     * @return orderNo - 订单号
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 设置订单号
     *
     * @param orderno 订单号
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    /**
     * 获取记录 有效的 职工 的 入职月份
     *
     * @return entryMonth - 记录 有效的 职工 的 入职月份
     */
    public Integer getEntrymonth() {
        return entrymonth;
    }

    /**
     * 设置记录 有效的 职工 的 入职月份
     *
     * @param entrymonth 记录 有效的 职工 的 入职月份
     */
    public void setEntrymonth(Integer entrymonth) {
        this.entrymonth = entrymonth;
    }

    /**
     * 获取入职时间
     *
     * @return entryTime - 入职时间
     */
    public Date getEntrytime() {
        return entrytime;
    }

    /**
     * 设置入职时间
     *
     * @param entrytime 入职时间
     */
    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    /**
     * 获取注销时间
     *
     * @return destoryTime - 注销时间
     */
    public Date getDestorytime() {
        return destorytime;
    }

    /**
     * 设置注销时间
     *
     * @param destorytime 注销时间
     */
    public void setDestorytime(Date destorytime) {
        this.destorytime = destorytime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}