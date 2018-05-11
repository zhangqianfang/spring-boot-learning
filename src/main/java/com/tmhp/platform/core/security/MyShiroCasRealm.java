//package com.tmhp.platform.core.security;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.cas.CasRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.tmhp.platform.module.user.domain.User;
//import com.tmhp.platform.module.user.mapper.UserMapper;
//
///***
// * @author zqf
// * @date 2018年5月3日
// *
// */
//public class MyShiroCasRealm extends CasRealm {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroCasRealm.class);
//
//    @Autowired
//    private UserMapper userDao;
//
//    /**
//     * 登录验证
//     * @param authcToken 当前登录用户的token
//     * @return AuthenticationInfo
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//        // UsernamePasswordToken对象用来存放提交的登录信息
//        //UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//        LOGGER.info("开始进行登录验证");
//        AuthenticationInfo token = super.doGetAuthenticationInfo(authcToken);
//        String username = (String) token.getPrincipals().getPrimaryPrincipal();
//        LOGGER.info("当前Subject时获取到用户名为" + username);
//        User user = this.userDao.getByName(username);
//        if (user != null) {
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            //return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), this.getName());
//            SecurityUtils.getSubject().getSession().setAttribute("user", user);
//        }
//        LOGGER.error("登录认证失败！！！" + username);
//        return null;
//    }
//
//    /**
//     * 权限认证
//     * @param principalCollection
//     * @return AuthorizationInfo
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        LOGGER.info("################## 执行Shiro权限认证 ##################");
//        // 获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
//        String userName = (String) super.getAvailablePrincipal(principalCollection);
//        // 到数据库查是否有此对象
//        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        User user = this.userDao.getByName(userName);
//        if (user != null) {
//            // 权限信息对象info，用来存放查出的用户的所有的角色（role）及权限（permission）
//            SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
//            // 用户的角色集合
//            auth.setRoles(user.getRolesName());
//            // 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
//            user.getRoleList().forEach(role -> {
//                auth.addStringPermissions(role.getPermissionNames());
//            });
//            return auth;
//        }
//        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
//        return null;
//    }
//}
