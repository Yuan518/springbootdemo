package com.atguigu.springboot.test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Test0914 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int reverse(int a) {
         String b= String.valueOf(a);
         StringBuffer c = new StringBuffer();
         c.append(b);
         c.reverse();
         int h = Integer.parseInt(c.toString());
        return h;
    }



    public static void main(String[] args) {
        /*int[] nums = {2,4,1,6};
        int[] b = twoSum(nums,8);
        System.out.println(b[0]+""+ b[1]);*/
        int v = reverse(123);
        System.out.println(v);

    }

}
