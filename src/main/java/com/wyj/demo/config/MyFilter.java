package com.wyj.demo.config;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class MyFilter extends AccessControlFilter {


    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String sid = httpServletRequest.getHeader("sid");
        return Objects.equals(sid, "wyj");
    }

    //返回false执行下面逻辑
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        JSONObject o = new JSONObject();
        o.put("error", "未认证");
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(o.toString().getBytes());
        } catch (IOException e) {
            log.error("权限校验异常", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    log.error("权限校验,关闭连接异常", e);
                }
            }
        }
        return false;
    }


}
