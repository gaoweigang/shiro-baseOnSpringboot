package com.gwg.shiro.web.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "tbl_user_role")
public class UserRole implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 角色id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    private String roleCode;

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
     * 获取角色id
     *
     * @return user_id - 角色id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置角色id
     *
     * @param userId 角色id
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
}