//package com.tmhp.platform.core.config;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import javax.servlet.Filter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
///***
// * *
// * @author zqf
// * @date 2018年5月4日
// */
//@Configuration
//public class ShiroCasConfiguration {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroCasConfiguration.class);
//
//    private static final String CAS_FILTER_URL_PATTERN = "/shiro-cas";
//
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
//        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
//        filterRegistration.setEnabled(true);
//        filterRegistration.addUrlPatterns("/*");
//        return filterRegistration;
//    }
//
//    @Bean(name = "lifecycleBeanPostProcessor")
//    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Value("${shiro.cas}") String casServerUrlPrefix,
//            @Value("${shiro.server}") String shiroServerUrlPrefix) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        //        CasRealm casRealm = new CasRealm();
//        //        casRealm.setDefaultRoles("ROLE_USER");
//        //        casRealm.setCasServerUrlPrefix(casServerUrlPrefix);
//        //        casRealm.setCasService(shiroServerUrlPrefix + CAS_FILTER_URL_PATTERN);
//        //        securityManager.setRealm(casRealm);
//        securityManager.setRealm(this.getMyShiroCasRealm(casServerUrlPrefix, shiroServerUrlPrefix));
//        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
//        securityManager.setSubjectFactory(new CasSubjectFactory());
//        return securityManager;
//    }
//
//    private MyShiroCasRealm getMyShiroCasRealm(String casServerUrlPrefix, String shiroServerUrlPrefix) {
//        MyShiroCasRealm casRealm = new MyShiroCasRealm();
//        casRealm.setCasServerUrlPrefix(casServerUrlPrefix);
//        casRealm.setCasService(shiroServerUrlPrefix + CAS_FILTER_URL_PATTERN);
//        return casRealm;
//    }
//
//    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        LOGGER.info("###### 从数据库读取权限规则，加载到shiroFilter中 ######");
//        // TODO 从数据库读取权限规则
//        filterChainDefinitionMap.put(CAS_FILTER_URL_PATTERN, "casFilter");
//        filterChainDefinitionMap.put("/login", "authc");
//        filterChainDefinitionMap.put("/logout", "logout");
//        filterChainDefinitionMap.put("/user/edit/**", "authc,perms[user:edit]");
//        filterChainDefinitionMap.put("/**", "authc");
//        // 不需要拦截的静态文件请求
//        filterChainDefinitionMap.put("/static", "anon");
//        // 不过滤其他业务系统请求
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//    }
//
//    /**
//     * CAS Filter
//     */
//    @Bean(name = "casFilter")
//    public CasFilter getCasFilter(@Value("${shiro.cas}") String casServerUrlPrefix, @Value("${shiro.server}") String shiroServerUrlPrefix) {
//        CasFilter casFilter = new CasFilter();
//        casFilter.setName("casFilter");
//        casFilter.setEnabled(true);
//        String loginUrl = casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix + CAS_FILTER_URL_PATTERN;
//        //String successUrl = shiroServerUrlPrefix + "/user";
//        casFilter.setFailureUrl(loginUrl);
//        //casFilter.setSuccessUrl(successUrl);
//        return casFilter;
//    }
//
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager, CasFilter casFilter,
//            @Value("${shiro.cas}") String casServerUrlPrefix, @Value("${shiro.server}") String shiroServerUrlPrefix) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        String loginUrl = casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix + CAS_FILTER_URL_PATTERN;
//        //shiroFilterFactoryBean.setLoginUrl(casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix + "/user");
//        shiroFilterFactoryBean.setLoginUrl(loginUrl);
//        shiroFilterFactoryBean.setSuccessUrl("/user");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//        Map<String, Filter> filters = new HashMap<>();
//        filters.put("casFilter", casFilter);
//        LogoutFilter logoutFilter = new LogoutFilter();
//        logoutFilter.setRedirectUrl(casServerUrlPrefix + "/logout?service=" + shiroServerUrlPrefix);
//        filters.put("logout", logoutFilter);
//        shiroFilterFactoryBean.setFilters(filters);
//
//        this.loadShiroFilterChain(shiroFilterFactoryBean);
//        return shiroFilterFactoryBean;
//    }
//}
