package com.lucheng.search;

import org.junit.Test;

public class testLeetcode33 {

    @Test
    public void test(){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        Leetcode33 method = new Leetcode33();
        int target = 0;
        int index = method.search(nums,target);
        System.out.println(target+"的索引是:"+index);
    }
}
