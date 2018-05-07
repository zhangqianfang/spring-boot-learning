package com.tmhp.platform.module.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tmhp.platform.core.dao.mybatis.SimpleInsertLangDriver;
import com.tmhp.platform.core.dao.mybatis.SimpleSelectInLangDriver;
import com.tmhp.platform.core.dao.mybatis.SimpleSelectLangDriver;
import com.tmhp.platform.core.dao.mybatis.SimpleUpdateLangDriver;
import com.tmhp.platform.module.user.domain.User;

/***
 * 用户管理mapper层接口
 * @author zqf
 * @date 2018年5月3日
 */
public interface UserMapper {

    /**
     * 查询所有用户信息列表
     * @return List<User>
     */
    @Select("SELECT * FROM t_user")
    @Results({ @Result(property = "roleList", column = "USER_ID", many = @Many(select = "com.tmhp.platform.module.role.mapper.listByUserId")) })
    List<User> listAll();

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return User
     */
    @Select("SELECT * FROM t_user WHERE USERNAME = #{username}")
    User getByName(@Param("username") String username);

    /**
     * 根据条件查询用户信息列表
     * @param user
     * @return List<User>
     */
    @Select("SELECT USER_ID,USERNAME,PASSWORD FROM t_user (#{user})")
    @Lang(SimpleSelectLangDriver.class)
    @Results({ @Result(property = "roleList", column = "USER_ID", many = @Many(select = "com.tmhp.platform.module.role.mapper.listByUserId")) })
    List<User> listByCondition(User user);

    /**
     * 根据用户ID列表查询用户信息列表
     * @param userIdList
     * @return List<User>
     */
    @Select("SELECT * FROM t_user WHERE USER_ID IN (#{userIdList})")
    @Lang(SimpleSelectInLangDriver.class)
    @Results({ @Result(property = "roleList", column = "USER_ID", many = @Many(select = "com.tmhp.platform.module.role.mapper.listByUserId")) })
    List<User> listByUserIds(@Param("userIdList") List<Integer> userIdList);

    /**
     * 插入用户信息
     * @param user
     * @return Integer
     */
    @Insert("INSERT INTO t_user (#{user})")
    @Lang(SimpleInsertLangDriver.class)
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Integer insert(User user);

    /**
     * 根据用户ID修改用户信息
     * @param user
     * @return Integer
     */
    @Update("UPDATE t_user (#{user}) WHERE USER_ID = #{userId}")
    @Lang(SimpleUpdateLangDriver.class)
    Integer updateById(User user);

    /**
     * 根据用户ID删除用户信息
     * @param userId
     * @return Integer
     */
    @Delete("DELETE FROM t_user WHERE USER_ID = #{userId}")
    Integer deleteById(int userId);

}
