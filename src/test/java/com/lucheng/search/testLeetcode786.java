package com.lucheng.search;

import com.lucheng.search.Leetcode786;
import org.junit.Test;

public class testLeetcode786 {

    @Test
    public void test(){
        Leetcode786 method = new Leetcode786();
        int arr[] = new int[]{1,2,3,5};
        int k = 4;
        int[] res = method.kthSmallestPrimeFraction(arr, k);
        System.out.println("数组中第"+k+"小的素数分数是："+res[0]+"/"+res[1]);
    }
}
