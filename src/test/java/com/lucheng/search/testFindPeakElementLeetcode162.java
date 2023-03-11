package com.lucheng.search;

import org.junit.Test;


public class testFindPeakElementLeetcode162 {
    @Test
    public void test(){
        int[] case1 = new int[]{1,2,3,4,5};
        FindPeakElementLeetcode162 solution = new FindPeakElementLeetcode162();
        int peakElement1 = solution.findPeakElement(case1);
        System.out.println("case1的的峰值索引位置是："+peakElement1);
    }

}
