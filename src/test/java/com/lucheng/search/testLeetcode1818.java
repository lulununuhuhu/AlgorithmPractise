package com.lucheng.search;

import org.junit.Test;

public class testLeetcode1818 {
    @Test
    public void test(){
        Leetcode1818 method = new Leetcode1818();
        int[] nums1 = new int[]{1,7,5};
        int[] nums2 = new int[]{2,3,5};
        long a = 2152685899L;int b = 256540;
        int res = method.minAbsoluteSumDiff(nums1, nums2);
        System.out.println("最小绝对值差和是"+res);
    }
}
