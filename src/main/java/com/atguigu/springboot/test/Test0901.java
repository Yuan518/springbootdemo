package com.atguigu.springboot.test;

import java.util.SortedMap;

public class Test0901 {
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] =a[j+1];
                    a[j+1] =temp;
                }

            }
        }
        for(int s:a){
            System.out.println(s);
        }
    }

}
