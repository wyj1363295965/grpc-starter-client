package com.wyj.demo.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        //自定义过滤器
        filterMap.put("authc", new MyFilter());
        factoryBean.setFilters(filterMap);

//        设置安全管理器
        factoryBean.setSecurityManager(securityManager);
//            添加Shiro内置过滤器
//            anon：无需认证就可以访问
//            authc：必须认证才可以访问
//            user：必须拥有记住我功能才可以访问
//            perms：拥有对某个资源的权限才能访问
        Map<String, String> definitionFilterMap = new LinkedHashMap<>();
//        匿名访问
        definitionFilterMap.put("/login", "anon");
        definitionFilterMap.put("/loginOut", "anon");
        //definitionFilterMap.put("/listen", "anon");
        //definitionFilterMap.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(definitionFilterMap);
        return factoryBean;
    }

    //  DefaultWebSecurityManager 2 安全管理器
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            @Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //    创建UserRealm类 需要自定义 1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
