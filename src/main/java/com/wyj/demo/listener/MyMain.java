package com.wyj.demo.listener;

import java.util.ArrayList;
import java.util.List;

public class MyMain {

    static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
//        synchronized (o) {
//            o.wait(5 * 1000L);
//        }
//        System.out.println(o);

        Double d = 0.25;
        System.out.println(d.intValue() + "");

        List<String> scrubberBattery = new ArrayList<>(); // 洗地耗电量
        double a = Double.parseDouble("0") + 6.7 / 36;
        System.out.println(a);
    }

}
