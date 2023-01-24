package com.lucheng.search;

import com.lucheng.search.LIS;
import org.junit.Test;

public class testLIS {
    @Test
    public void test(){
        int[] nums = new int[]{1,2,2147483647};
        LIS method = new LIS();
        int res = method.increasingTriplet(nums);
        System.out.println("nums数组的最长递增子序列长度是:"+res);

    }
}
