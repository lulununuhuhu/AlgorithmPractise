package com.lucheng.divideAndConque;

import org.junit.Test;

public class testLeetcode4 {

    @Test
    public void test(){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        leetcode4 method = new leetcode4();
        System.out.println((double) ((2+3)*0.5));
        double midValue = method.findMedianSortedArrays(nums1, nums2);
        System.out.println("nums1数组和nums2数组的中位数是："+midValue);
    }
}
