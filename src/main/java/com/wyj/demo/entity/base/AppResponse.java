package com.wyj.demo.entity.base;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AppResponse {

    private Integer code;
    private String message;
    private Object data;

    public static AppResponse FAIL(String message) {
        return new AppResponse()
                .setCode(500).setData(null)
                .setMessage(message);
    }

    public static AppResponse FAIL(Object data) {
        return new AppResponse()
                .setCode(500).setData(data)
                .setMessage(OPERATION_FAILED);
    }

    public static AppResponse SUCCESS(Object data) {
        return new AppResponse()
                .setCode(500).setData(data)
                .setMessage(OPERATION_SUCCESS);
    }

    public static AppResponse SUCCESS() {
        return new AppResponse()
                .setCode(500).setData(null)
                .setMessage("");
    }

    public static AppResponse FAIL() {
        return new AppResponse()
                .setCode(500).setData(null)
                .setMessage(OPERATION_FAILED);
    }


    private static final String OPERATION_FAILED = "操作失败！";
    private static final String OPERATION_SUCCESS = "操作成功！";
}
