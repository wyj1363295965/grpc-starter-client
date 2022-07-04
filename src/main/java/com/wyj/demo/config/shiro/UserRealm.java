package com.wyj.demo.config.shiro;

import com.google.common.collect.Lists;
import com.wyj.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回 null 即可。
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String account = (String) principals.getPrimaryPrincipal();
        log.info("用户账号：{}", account);
//        UserPermission permission = permissionService.getUserPermission(account);
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<String> permissions = Lists.newArrayList("/listen");
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    //    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("执行了认证...........");
//        获取当前登录账户
        UsernamePasswordToken accountToken = (UsernamePasswordToken) token;
        String username = accountToken.getUsername(); // 获取当前账号
//        连接数据库进行登录验证
        //Account account = accountController.selectByName(username);

//         密码认证 shiro做 存在泄密
        return new SimpleAuthenticationInfo(username,
                token.getCredentials(),
                this.getName());
    }

}
