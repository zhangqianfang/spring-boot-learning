package com.tmhp.platform.module.role.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.tmhp.platform.module.role.domain.Role;

/***
 * 
 * @author zqf
 * @date 2018年5月3日
 */
public interface RoleMapper {

    @Select({ "select", "a.ROLE_ID, b.ROLE_NAME", "from t_user_role a left join t_role b on a.ROLE_ID=b.ID",
            "where a.USER_ID = #{userId,jdbcType=INTEGER}" })
    @Results({ @Result(property = "id", column = "ROLE_ID"),
            @Result(property = "permissionList", column = "ROLE_ID", many = @Many(select = "com.tmhp.platform.module.permission.mapper.listByRoleId")) })
    List<Role> listByUserId(Integer userId);

    @Delete({ "delete from t_role", "where ID = #{id,jdbcType=INTEGER}" })
    int deleteByPrimaryKey(Integer id);

    @Insert({ "insert into t_role (ID, ROLE_NAME)", "values (#{id,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Role record);

    @InsertProvider(type = RoleSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(Role record);

    @Select({ "select", "ID, ROLE_NAME", "from t_role", "where ID = #{id,jdbcType=INTEGER}" })
    @Results({ @Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "ROLE_NAME", property = "roleName", jdbcType = JdbcType.VARCHAR) })
    Role selectByPrimaryKey(Integer id);

    @UpdateProvider(type = RoleSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Role record);

    @Update({ "update t_role", "set ROLE_NAME = #{roleName,jdbcType=VARCHAR}", "where ID = #{id,jdbcType=INTEGER}" })
    int updateByPrimaryKey(Role record);
}