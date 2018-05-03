package com.tmhp.platform.module.user.service;

import java.util.List;

import com.tmhp.platform.module.user.domain.User;

/***
 * 用户管理 service层接口
 * @author zqf
 * @date 2018年5月3日
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return User
     */
    public User getUserInfo(String username);

    /**
     * 查询所有用户信息列表
     * @return List<User>
     */
    public List<User> listAll();

    /**
     * 根据条件查询用户信息列表
     * @param user
     * @return List<User>
     */
    public List<User> listByCondition(User user);

    /**
     * 根据用户ID列表查询用户信息列表
     * @param userIdList
     * @return List<User>
     */
    public List<User> listByIds(List<Integer> userIdList);

    /**
     * 插入用户信息
     * @param user
     * @return boolean
     */
    public boolean insert(User user);

    /**
     * 根据用户ID修改用户信息
     * @param user
     * @return boolean
     */
    public boolean updateById(User user);

    /**
     * 根据用户ID删除用户信息
     * @param id
     * @return boolean
     */
    public boolean deleteById(int id);

}
