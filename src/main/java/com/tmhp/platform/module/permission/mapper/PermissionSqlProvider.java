package com.tmhp.platform.module.permission.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.tmhp.platform.module.permission.domain.Permission;

public class PermissionSqlProvider {

    public String insertSelective(Permission record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_permission");

        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=INTEGER}");
        }

        if (record.getPermissionName() != null) {
            sql.VALUES("PERMISSION_NAME", "#{permissionName,jdbcType=VARCHAR}");
        }

        if (record.getRoleId() != null) {
            sql.VALUES("ROLE_ID", "#{roleId,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Permission record) {
        SQL sql = new SQL();
        sql.UPDATE("t_permission");

        if (record.getPermissionName() != null) {
            sql.SET("PERMISSION_NAME = #{permissionName,jdbcType=VARCHAR}");
        }

        if (record.getRoleId() != null) {
            sql.SET("ROLE_ID = #{roleId,jdbcType=INTEGER}");
        }

        sql.WHERE("ID = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }
}