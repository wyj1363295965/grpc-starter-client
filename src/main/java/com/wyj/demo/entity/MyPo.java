package com.wyj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Getter
@Setter
@ToString
public class MyPo implements Serializable {

    private String name;

}
