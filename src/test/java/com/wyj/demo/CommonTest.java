package com.wyj.demo;


import com.example.grpc.TestRequest;
import com.example.grpc.TestResponse;
import com.example.grpc.TestServiceGrpc;
import com.wyj.demo.service.MyGrpcService;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
@Slf4j
public class CommonTest {

    @Autowired
    private MyGrpcService myGrpcService;

    @Test
    public void test2() {
        myGrpcService.test2();
    }

    @Test
    public void test1() {
        List<String> list1 = Lists.newArrayList("1", "2");
        List<String> list2 = Lists.newArrayList("3", "2");
        //并集
        //list1.addAll(list2);
        //交集
        //list1.retainAll(list2);
        //差集
        //list1.removeAll(list2);
        //无重复并集
        list2.removeAll(list1);
        list1.addAll(list2);
        System.out.println(list1);
        System.out.println(list2);
        List<String> list3 = Lists.newArrayList("1", "2");
    }

    @Test
    public void test() {
        if (Objects.equals("2", "1")) {

        }
        log.info("myTest");
    }
}
