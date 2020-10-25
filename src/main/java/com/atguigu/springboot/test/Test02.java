package com.atguigu.springboot.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean FLAG = true; //默认开启
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(this.blockingQueue.getClass().getName());
    }

    //生产者
    public void prod() throws Exception{
        String data = null;
        Boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t"+"插入队列"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t"+"插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"大老板叫停了，表示FLAG=false,生产动作结束");
    }

    //消费者
    public void customer() throws Exception{
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(result == null || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t" + "超过2秒钟没有取到，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"消费队列"+result+"成功");
        }

    }

    //叫停方法
    public void stop(){
        this.FLAG=false;
    }
}


public class Test02 {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"生产线程启动");
            try {
                myResource.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"消费线程启动");
            System.out.println();
            System.out.println();
            try {
                myResource.customer();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Custom").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板叫停，活动结束");
        myResource.stop();

    }
}
