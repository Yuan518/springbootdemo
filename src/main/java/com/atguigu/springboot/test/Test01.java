package com.atguigu.springboot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test01 {
    volatile List<Object> list = new ArrayList<Object>();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        final Object o = new Object();

        //监控线程T2
        Thread t2 = new Thread(()->{
            synchronized (o){
                System.out.println("T2线程启动了。。。。");
                if(test01.size() !=5){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T2线程结束了。。。。");
                o.notify();
            }
        },"T2检测线程");

        Thread t1 = new Thread(()->{
            synchronized (o){
                System.out.println("T1线程启动了。。。。");
                for (int i = 0; i <10 ; i++) {
                    test01.add(new Object());
                    System.out.println("T1线程添加了。。"+i);
                    if(test01.size() ==5){
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("T1线程结束了。。。。");

            }
        },"T1添加线程");

        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
    }
}
