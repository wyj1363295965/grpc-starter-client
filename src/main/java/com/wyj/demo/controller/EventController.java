package com.wyj.demo.controller;

import com.wyj.demo.entity.MyPo;
import com.wyj.demo.event.MyEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventController {


    private final ApplicationEventPublisher publisher;

    @RequestMapping(value = "/listen", method = RequestMethod.GET)
    public void listenDemo() {

        MyEvent myEvent = new MyEvent(this);
        myEvent.setMyPo(new MyPo().setName("wyj"));
        publisher.publishEvent(myEvent);
        System.out.println("success");
    }
}
