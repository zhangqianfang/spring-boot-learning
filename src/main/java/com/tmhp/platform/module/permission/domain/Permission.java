package com.tmhp.platform.module.permission.domain;

import javax.persistence.Table;

/***
 * @author zqf
 * @date 2018年5月3日
 * 
 */
@Table(name = "t_permission")
public class Permission {

    /** 权限ID */
    private Integer id;
    /** 权限名称 */
    private String permissionName;
    /** 角色ID */
    private Integer roleId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return this.permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
