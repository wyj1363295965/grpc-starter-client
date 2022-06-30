package com.wyj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Getter
@Setter
@Accessors(chain = true)
public class MyPo implements Serializable {

    private static final long serialVersionUID = 7440519756790235410L;
    @NotNull(message = "名称不可为空！")
    private String name;
    @NotNull(message = "id不可为空！")
    private Integer id;

}
