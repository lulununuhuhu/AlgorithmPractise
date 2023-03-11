package com.lucheng.search;

import org.junit.Test;

public class testLeetcode300 {

    @Test
    public void test(){
        int minValue = Integer.MIN_VALUE;
        Leetcode300 method = new Leetcode300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int res = method.Method(nums);
        System.out.println("最长递增子序列的长度是:"+res);
    }
}
