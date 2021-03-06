package com.wyj.demo.controller;

import com.wyj.demo.entity.MyPo;
import com.wyj.demo.entity.base.AppResponse;
import com.wyj.demo.event.MyEvent;
import com.wyj.demo.service.MyGrpcService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@Api(value = "事件接口", tags = {"1"})
public class EventController {

    private final MyGrpcService myGrpcService;
    private final ApplicationEventPublisher publisher;

    @RequestMapping(value = "/grpcTest", method = RequestMethod.GET)
    public void grpcTest() {
        myGrpcService.test2();
    }

    @RequestMapping(value = "/listen", method = RequestMethod.GET)
    public void listenDemo() {

        MyEvent myEvent = new MyEvent(this);
        myEvent.setMyPo(new MyPo().setName("wyj"));
        publisher.publishEvent(myEvent);
        System.out.println("success");
    }

    @RequestMapping(value = "/returnString", method = RequestMethod.POST)
    public AppResponse returnStringForPost(@Validated @RequestBody MyPo myPo) {
        return AppResponse.SUCCESS(myPo.getName());
    }

    @RequestMapping(value = "/returnString", method = RequestMethod.GET)
    public String returnStringForGet(
            @NotNull(message = "信息不可为空！") String message,
            @NotNull(message = "test不可为空！") String test) {
        log.info("test:{}", test);
        return message;
    }
}
