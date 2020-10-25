package com.atguigu.springboot.test;

import java.util.ArrayList;
import java.util.List;

public class aaa {

    static List<Org> newOrg = new ArrayList<Org>();

    public static List<Org> digui(List<Org>orgs, String pid){
        for (Org o:orgs){
            if(pid.equals(o.parentId)){
                digui(orgs,o.id);
                newOrg.add(o);
            }
        }
        return newOrg;
    }

    public static void main(String[] args) {
        List<Org> list = new ArrayList<Org>();
        list.add(new Org("1","0","总部"));
        list.add(new Org("2","1","技术部"));
        //list.add(new Org("3","2","开发部"));
        //list.add(new Org("4","2","运维部"));
        list.add(new Org("5","2","测试部"));
        list.add(new Org("6","1","人事部"));
        list.add(new Org("7","6","出纳部"));
        //list.add(new Org("8","6","会计部"));
        list.add(new Org("9","1","销售部"));
        list.add(new Org("10","9","公关部"));
        //list.add(new Org("11","9","陪酒部"));
        List<Org> orgs = digui(list,"2");
        for (Org m : orgs) {
            System.out.println(m);
        }
    }


}
