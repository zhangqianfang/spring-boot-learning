package com.tmhp.platform.module.role.domain;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.tmhp.platform.module.permission.domain.Permission;

/***
 * @author zqf
 * @date 2018年5月3日
 * 
 */
@Table(name = "t_role")
public class Role {

    /** 角色ID */
    private Integer id;
    /** 角色名称 */
    private String roleName;
    /** 权限列表 */
    private List<Permission> permissionList;

    @Transient
    public List<String> getPermissionNames() {
        return this.getPermissionList().stream().map(p -> p.getPermissionName()).collect(Collectors.toList());
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissionList() {
        return this.permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

}
