package com.tmhp.platform.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmhp.platform.core.bean.Result;
import com.tmhp.platform.core.bean.ResultGenerator;
import com.tmhp.platform.module.user.domain.User;
import com.tmhp.platform.module.user.service.UserService;

/***
 * 
 * @author zqf
 * @date 2018年5月3日
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get/{username}")
    public Result getUser(@PathVariable String username) {
        User userInfo = this.userService.getUserInfo(username);
        return ResultGenerator.genSuccessResult("根据 " + username + " 查询成功", userInfo);
    }

    @RequestMapping("/getall")
    public Result getAllUser() {
        List<User> resultList = this.userService.listAll();
        return ResultGenerator.genSuccessResult("查询所有用户成功", resultList);
    }

    @RequestMapping("/getByCondition")
    public Result getUsersByConditon(User user) {
        List<User> resultList = this.userService.listByCondition(user);
        return ResultGenerator.genSuccessResult("根据条件查询户成功", resultList);
    }

    @RequestMapping("/getByUserIds")
    public Result getByUserIds(List<Integer> userIdList) {
        List<User> resultList = this.userService.listByIds(userIdList);
        return ResultGenerator.genSuccessResult("根据" + userIdList + "查询户成功", resultList);
    }

    @RequestMapping("/insert")
    public Result insert(User user) {
        boolean success = this.userService.insert(user);
        return ResultGenerator.getResult(success);
    }

    @RequestMapping("/update")
    public Result updateUser(User user) {
        boolean success = this.userService.updateById(user);
        return ResultGenerator.getResult(success);
    }

    @RequestMapping("/del/{userId}")
    public Result deleteById(@PathVariable Integer userId) {
        boolean success = this.userService.deleteById(userId);
        return ResultGenerator.getResult(success);
    }
}
