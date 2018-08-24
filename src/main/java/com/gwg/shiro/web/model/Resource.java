package com.gwg.shiro.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Table(name = "tbl_resource")
public class Resource implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 资源名称
     */
    @Column(name = "res_code")
    private String resCode;

    /**
     * 资源名称-英文
     */
    @Column(name = "res_name")
    private String resName;

    /**
     * 资源url
     */
    @Column(name = "res_url")
    private String resUrl;

    /**
     * 资源类型   1:菜单    2：按钮
     */
    private Integer type;

    /**
     * 父资源
     */
    private Integer pid;

    /**
     * 排序
     */
    private Integer sort;

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
     * 获取资源名称
     *
     * @return res_code - 资源名称
     */
    public String getResCode() {
        return resCode;
    }

    /**
     * 设置资源名称
     *
     * @param resCode 资源名称
     */
    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    /**
     * 获取资源名称-英文
     *
     * @return res_name - 资源名称-英文
     */
    public String getResName() {
        return resName;
    }

    /**
     * 设置资源名称-英文
     *
     * @param resName 资源名称-英文
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * 获取资源url
     *
     * @return res_url - 资源url
     */
    public String getResUrl() {
        return resUrl;
    }

    /**
     * 设置资源url
     *
     * @param resUrl 资源url
     */
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    /**
     * 获取资源类型   1:菜单    2：按钮
     *
     * @return type - 资源类型   1:菜单    2：按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置资源类型   1:菜单    2：按钮
     *
     * @param type 资源类型   1:菜单    2：按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取父资源
     *
     * @return pid - 父资源
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父资源
     *
     * @param pid 父资源
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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