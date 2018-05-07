package com.tmhp.platform.module.role.mapper;

import com.tmhp.platform.module.role.domain.Role;
import org.apache.ibatis.jdbc.SQL;

public class RoleSqlProvider {

    public String insertSelective(Role record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_role");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRoleName() != null) {
            sql.VALUES("ROLE_NAME", "#{roleName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Role record) {
        SQL sql = new SQL();
        sql.UPDATE("t_role");
        
        if (record.getRoleName() != null) {
            sql.SET("ROLE_NAME = #{roleName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}