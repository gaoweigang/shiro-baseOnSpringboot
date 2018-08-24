package com.gwg.shiro.web.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "tbl_role_resource")
public class RoleResource implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 资源编码
     */
    @Column(name = "res_code")
    private String resCode;

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
     * 获取角色编码
     *
     * @return role_code - 角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编码
     *
     * @param roleCode 角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取资源编码
     *
     * @return res_code - 资源编码
     */
    public String getResCode() {
        return resCode;
    }

    /**
     * 设置资源编码
     *
     * @param resCode 资源编码
     */
    public void setResCode(String resCode) {
        this.resCode = resCode;
    }
}