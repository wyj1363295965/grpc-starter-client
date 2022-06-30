package com.wyj.demo.entity.base;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AppResponse {

    private static final String OPERATION_FAILED = "操作失败！";
    private static final String OPERATION_SUCCESS = "操作成功！";
    private static final Integer OPERATION_SUCCESS_CODE = 200;
    private static final Integer OPERATION_FAILED_CODE = 500;

    private Integer code;
    private String message;
    private Object data;

    public static AppResponse FAIL(String message) {
        return new AppResponse()
                .setCode(OPERATION_FAILED_CODE).setData(null)
                .setMessage(message);
    }

    public static AppResponse FAIL(Object data) {
        return new AppResponse()
                .setCode(OPERATION_FAILED_CODE).setData(data)
                .setMessage(OPERATION_FAILED);
    }

    public static AppResponse SUCCESS(Object data) {
        return new AppResponse()
                .setCode(OPERATION_SUCCESS_CODE).setData(data)
                .setMessage(OPERATION_SUCCESS);
    }

    public static AppResponse SUCCESS() {
        return new AppResponse()
                .setCode(OPERATION_SUCCESS_CODE).setData(null)
                .setMessage(OPERATION_SUCCESS);
    }

    public static AppResponse FAIL() {
        return new AppResponse()
                .setCode(OPERATION_FAILED_CODE).setData(null)
                .setMessage(OPERATION_FAILED);
    }

}
