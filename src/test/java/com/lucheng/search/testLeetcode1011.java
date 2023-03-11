package com.lucheng.search;

import org.junit.Test;

public class testLeetcode1011 {

    @Test
    public void test(){
        int[] weights = new int[]{1,2,3,1,1};
        int days = 4;
        Leetcode1011 method = new Leetcode1011();
        int minCarry = method.shipWithinDays(weights, days);
        System.out.println("最低运载能力是:"+minCarry);
    }
}
