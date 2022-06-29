package com.wyj.demo.config;

import com.google.common.collect.Lists;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import java.util.List;

public class UserRealm extends AuthorizingRealm {


    //    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String account = (String) principals.getPrimaryPrincipal();
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
