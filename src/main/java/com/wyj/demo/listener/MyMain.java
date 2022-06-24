package com.wyj.demo.listener;

public class MyMain {

    static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        synchronized (o) {
            o.wait(5 * 1000L);
        }
        System.out.println(o);
    }

}
