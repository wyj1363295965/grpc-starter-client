package com.wyj.demo;


import com.wyj.demo.entity.MyPo;
import com.wyj.demo.entity.MyPo1;
import com.wyj.demo.service.MyGrpcService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@SpringBootTest
@Slf4j
public class CommonTest {

    @Autowired
    private MyGrpcService myGrpcService;
    @Autowired
    private MessageSource messageSource;
    List<String> list;


    @Test
    public void test4() {
        BigDecimal one = new BigDecimal(0);
        BigDecimal two = null;
        //System.out.println(one.add(two));
        list = Lists.newArrayList("1");
        for (String tmp : list) {
            tmp += "+";
        }
        System.out.println(list);
    }

    @Test
    public void test3() {

        String[] langCountry = Locale.SIMPLIFIED_CHINESE.toString().split("_");
        Locale locale = new Locale(langCountry[0], langCountry[1]);
        try {
            String result = messageSource.getMessage("CLIENT_RESPONSE.NO_MAP_SPECIFIED", null, locale);
            log.info(result);
        } catch (Exception e) {
            log.error("Get i18n value occurs ex: {}", e.getMessage(), e);
        }
    }

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
        MyPo myPo = new MyPo().setName("1");
        System.out.println(myPo.toString());
        MyPo1 myPo1 = new MyPo1().setName("1");
        System.out.println(myPo1.toString());
    }
}
