package com.atguigu.springboot.test;

import java.util.ArrayList;
import java.util.List;

public class digui {
    public static void main(String[] args) {
        List<Org> list = new ArrayList<Org>();
        list.add(new Org("1","0","总部"));
        list.add(new Org("2","1","技术部"));
        //list.add(new Org("3","2","开发部"));
        //list.add(new Org("4","2","运维部"));
        list.add(new Org("5","2","测试部"));
        list.add(new Org("6","1","人事部"));
        list.add(new Org("7","6","出纳部"));
        list.add(new Org("8","6","会计部"));
        list.add(new Org("9","1","销售部"));
        list.add(new Org("10","9","公关部"));
        list.add(new Org("11","9","陪酒部"));

        List<Org> newOrg = new ArrayList<Org>();
        digui(list,"2",newOrg);
    }

    public static void digui(List<Org>orgs, String num,List<Org> newOrg){
        for (Org o:orgs){
            if(num.equals(o.parentId)){
                newOrg.add(o);
                digui(orgs,o.id,newOrg);


            }
        }
        for(Org temp:newOrg){
            System.out.println(temp);
        }
    }
}
