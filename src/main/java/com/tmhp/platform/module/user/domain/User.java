package com.tmhp.platform.module.user.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tmhp.platform.core.annotation.Invisible;
import com.tmhp.platform.module.role.domain.Role;

/***
 * 
 * @author zqf
 * @date 2018-5-2
 */
@Table(name = "t_user")
public class User {

    /** 用户ID */
    @Column(name = "user_id")
    private Integer userId;
    /** 用户名称 */
    @Column(name = "username")
    private String username;
    /** 密码 */
    @Column(name = "password")
    private String password;
    /** 邮箱 */
    @Column(name = "email")
    private String email;
    /** 手机号 */
    @Column(name = "mobile")
    private String mobile;
    /** 状态 0锁定，1启用 */
    @Column(name = "status")
    private String status;
    /** 性别 0女，1男 */
    @Column(name = "sex")
    private String sex;
    /** 头像 */
    @Column(name = "avatar")
    private String avatar;
    /** 备注 */
    @Column(name = "remark")
    private String remark;
    /** 创建人ID */
    @Column(name = "create_user_id")
    private Integer createUserId;
    /** 修改人ID */
    @Column(name = "update_user_id")
    private Integer updateUserId;
    /** 创建时间 */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;
    /** 修改时间 */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;
    /** 最后登录时间 */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /** 角色列表 */
    @JsonIgnore
    @Invisible
    private List<Role> roleList;

    @JsonIgnore
    @Invisible
    private List<Integer> userIdList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Transient
    public Set<String> getRolesName() {
        List<Role> roles = this.getRoleList();
        return roles.stream().map(role -> role.getRoleName()).collect(Collectors.toSet());
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getUpdateUserId() {
        return this.updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<Integer> getUserIdList() {
        return this.userIdList;
    }

    public void setUserIdList(List<Integer> userIdList) {
        this.userIdList = userIdList;
    }

    public List<Role> getRoleList() {
        return this.roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

}
