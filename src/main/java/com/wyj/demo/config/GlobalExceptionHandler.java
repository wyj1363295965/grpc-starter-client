package com.wyj.demo.config;

import com.wyj.demo.entity.base.AppResponse;
import com.wyj.demo.entity.base.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ControllerAdvice + @ExceptionHandler 实现全局的 Controller 层的异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    AppResponse handleException(Exception e) {
        log.error(e.getMessage(), e);
        return AppResponse.FAIL();
    }

    /**
     * 处理所有业务异常
     *
     * @param e 异常
     * @return 结果
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    AppResponse handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return AppResponse.FAIL();
    }

    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    AppResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        List<String> messages = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return AppResponse.FAIL(messages);
    }

    //get请求
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    AppResponse handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        return AppResponse.FAIL(e.getMessage());
    }

}
