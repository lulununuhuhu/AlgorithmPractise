package com.lucheng.search;

import org.junit.Test;

public class testLeetcode410 {
    @Test
    public void test(){
        int[] nums = new int[]{7,2,5,10,8};
        int k = 2;
        Leetcode410 method = new Leetcode410();
        int res = method.splitArray(nums, k);
        System.out.println("分割连续子数组的和的最小值是："+res);
    }
}
