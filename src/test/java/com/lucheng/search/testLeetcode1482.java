package com.lucheng.search;

import com.lucheng.search.Leetcode1482;
import org.junit.Test;

public class testLeetcode1482 {


    @Test
    public void test(){
        Leetcode1482 method = new Leetcode1482();
        int max = Integer.MAX_VALUE;
        int[] nums = new int[]{7,7,7,7,12,7,7};
        int m = 2, k = 3;
        int minDays = method.minDays(nums, m, k);
        System.out.println("所需要的最小天数是:"+minDays);
    }
}
