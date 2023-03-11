package com.lucheng.search;

import org.junit.Test;

public class testInterview1003 {

    @Test
    public void test(){
        Interview1003 method = new Interview1003();
        int[] nums = new int[]{5,5,5,1,2,3,4,5};
        int target = 5;
        int index = method.search(nums, target);
        System.out.println(target+"的索引位置是："+index);
    }
}
