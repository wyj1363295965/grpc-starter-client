package com.wyj.demo.listener;

import com.wyj.demo.event.MyEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyListener implements ApplicationListener<MyEvent> {


    @SneakyThrows
    @Override
    @Async
    public void onApplicationEvent(MyEvent event) {
        Thread.sleep(5 * 1000);
        log.info("监听到的参数：{}", event.getMyPo().getName());
    }
}
