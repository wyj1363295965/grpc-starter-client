package com.wyj.demo.config.shiro;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class MyFilter extends AccessControlFilter {


    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String sid = httpServletRequest.getHeader("sid");
        return Objects.equals(sid, "wyj");
    }

    //返回false执行下面逻辑
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        loginFail(response);
        //认证
//        try {
//            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//            String sid = httpServletRequest.getHeader("sid");
//            UsernamePasswordToken token = new UsernamePasswordToken(sid, "token");
//            this.getSubject(request, response).login(token);
//        }catch (Exception e){
//
//        }

        return false;
    }

    /**
     * 登录失败时默认返回 401 状态码
     **/
    private void loginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        JSONObject o = new JSONObject();
        o.put("error", "未认证");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setCharacterEncoding("utf-8");
        httpResponse.getWriter().write(o.toString());
    }
}
