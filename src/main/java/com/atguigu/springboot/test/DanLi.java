package com.atguigu.springboot.test;

public class DanLi {
    private static   DanLi danLi = null;
    private DanLi(){
        System.out.println(Thread.currentThread().getName()+"我是构造方法");
    }

    public static DanLi getDanLi(){
        if(danLi == null){
            synchronized (DanLi.class){
                if(danLi == null){
                    danLi = new DanLi();
                }
            }
        }
        return danLi;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            System.out.println("第"+i+"次");
            new Thread(() ->{
                DanLi.getDanLi();
            },"线程"+String.valueOf(i)).start();
        }
    }
}
