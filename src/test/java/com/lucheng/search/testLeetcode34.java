package com.lucheng.search;

import org.junit.Test;

public class testLeetcode34 {

    @Test
    public void test(){
        int[] nums = new int[]{1, 2, 5, 6, 9, 10, 15, 14};
        int[] nums1 = new int[]{10, 10, 10, 10, 10, 10, 10, 10};
        Leetcode34 method = new Leetcode34();
        int[] searchRange = method.searchRange(nums1, 10);
        System.out.println("返回结果是:"+searchRange[0]+" "+searchRange[1]);

    }
}
