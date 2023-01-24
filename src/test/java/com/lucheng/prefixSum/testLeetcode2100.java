package com.lucheng.prefixSum;

import java.util.List;

public class testLeetcode2100 {
    public static void main(String[] args) {
        int[] security = new int[]{1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8};
        int time = 2;
        Leetcode2100 method = new Leetcode2100();
        List<Integer> integers = method.goodDaysToRobBank(security, time);
        System.out.println("适合打劫银行的天数有："+integers);
    }
}
