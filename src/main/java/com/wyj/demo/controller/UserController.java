package com.wyj.demo.controller;

import com.wyj.demo.entity.base.AppResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhihui
 * @since 2022-07-01
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口", tags = {"1"})
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AppResponse login() {
        UsernamePasswordToken token = new UsernamePasswordToken("sid", "token");
        SecurityUtils.getSubject().login(token);
        return AppResponse.SUCCESS("token");
    }

}
