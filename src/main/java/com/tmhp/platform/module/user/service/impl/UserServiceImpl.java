package com.tmhp.platform.module.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmhp.platform.module.user.domain.User;
import com.tmhp.platform.module.user.mapper.UserMapper;
import com.tmhp.platform.module.user.service.UserService;

/***
 * 用户管理 service层实现类
 * @author zqf
 * @date 2018年5月3日
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserInfo(String username) {
        this.logger.info("根据用户名 " + username + " 查询用户");
        this.logger.debug("根据用户名 " + username + " 查询用户");
        this.logger.error("根据用户名 " + username + " 查询用户");
        return this.userMapper.getByName(username);
    }

    @Override
    public List<User> listAll() {
        return this.userMapper.listAll();
    }

    @Override
    public List<User> listByCondition(User user) {
        return this.userMapper.listByCondition(user);
    }

    @Override
    public List<User> listByIds(List<Integer> userIdList) {
        return this.userMapper.listByUserIds(userIdList);
    }

    @Override
    public boolean insert(User user) {
        return this.userMapper.insert(user) > 0;
    }

    @Override
    public boolean updateById(User user) {
        return this.userMapper.updateById(user) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        return this.userMapper.deleteById(id) > 0;
    }

}
