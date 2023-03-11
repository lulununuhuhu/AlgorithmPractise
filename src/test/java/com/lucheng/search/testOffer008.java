package com.lucheng.search;

public class testOffer008 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int s = 7;
        Offer008 method = new Offer008();
        int res = method.minSubArrayLen(s, nums);
        System.out.println("大于等于"+s+"的最小连续子序列长度是:"+res);
    }
}
