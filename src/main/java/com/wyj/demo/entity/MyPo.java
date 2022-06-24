package com.wyj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Getter
@Setter
@Accessors(chain = true)
public class MyPo implements Serializable {

    private static final long serialVersionUID = 7440519756790235410L;
    private String name;

}
