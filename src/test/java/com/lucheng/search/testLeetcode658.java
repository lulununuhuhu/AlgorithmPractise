package com.lucheng.search;

import com.lucheng.search.Leetcode658;
import org.junit.Test;

import java.util.List;

public class testLeetcode658 {
    @Test
    public void test(){
        int[] arr = new int[]{0,1,1,1,2,3,6,7,8,9};
        int k = 9;int x = 4;
        Leetcode658 method = new Leetcode658();
        List<Integer> elements = method.findClosestElements(arr, k, x);
        System.out.println(elements);
    }
}
