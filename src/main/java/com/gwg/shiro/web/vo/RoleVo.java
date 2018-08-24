package com.gwg.shiro.web.vo;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

@Data
public class RoleVo implements Serializable{

    /**
     * 主键
     */
    private Long id;

    private String roleCode;

    private String roleName;

    /**
     * 该角色拥有的资源集合
     */
    private List<Long> resourceIdList;
}
