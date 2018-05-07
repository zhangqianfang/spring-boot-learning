package com.tmhp.platform.core.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/***
 * @author zqf
 * @date 2018年5月4日
 * 
 */
public class BaseController {

    /***
     * 获取当前的登录用户名
     * @return
     */
    public String getUsername() {
        Subject subject = SecurityUtils.getSubject();
        if ((subject == null) || (subject.getPrincipals() == null)) {
            return null;
        }
        return (String) subject.getPrincipals().getPrimaryPrincipal();
    }
}
