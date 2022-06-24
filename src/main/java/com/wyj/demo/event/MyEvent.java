package com.wyj.demo.event;

import com.wyj.demo.entity.MyPo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Getter
@Setter
public class MyEvent extends ApplicationEvent {

    private MyPo myPo;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, Clock clock, MyPo myPo) {
        super(source, clock);
        this.myPo = myPo;
    }
}
