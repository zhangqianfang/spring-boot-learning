package com.tmhp.platform.module.permission.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.tmhp.platform.module.permission.domain.Permission;

/***
 * 
 * @author zqf
 * @date 2018年5月3日
 */
public interface PermissionMapper {

    /**
     * 根据角色ID查询权限列表
     * @param roleId
     * @return List<Permission>
     */
    @Select({ "select", "ID, PERMISSION_NAME, ROLE_ID", "from t_permission", "where ROLE_ID = #{roleId,jdbcType=INTEGER}" })
    List<Permission> listByRoleId(Integer roleId);

    @Delete({ "delete from t_permission", "where ID = #{id,jdbcType=INTEGER}" })
    int deleteByPrimaryKey(Integer id);

    @Insert({ "insert into t_permission (ID, PERMISSION_NAME, ", "ROLE_ID)", "values (#{id,jdbcType=INTEGER}, #{permissionName,jdbcType=VARCHAR}, ",
            "#{roleId,jdbcType=INTEGER})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Permission record);

    @InsertProvider(type = PermissionSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(Permission record);

    @Select({ "select", "ID, PERMISSION_NAME, ROLE_ID", "from t_permission", "where ID = #{id,jdbcType=INTEGER}" })
    @Results({ @Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "PERMISSION_NAME", property = "permissionName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ROLE_ID", property = "roleId", jdbcType = JdbcType.INTEGER) })
    Permission selectByPrimaryKey(Integer id);

    @UpdateProvider(type = PermissionSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Permission record);

    @Update({ "update t_permission", "set PERMISSION_NAME = #{permissionName,jdbcType=VARCHAR},", "ROLE_ID = #{roleId,jdbcType=INTEGER}",
            "where ID = #{id,jdbcType=INTEGER}" })
    int updateByPrimaryKey(Permission record);
}