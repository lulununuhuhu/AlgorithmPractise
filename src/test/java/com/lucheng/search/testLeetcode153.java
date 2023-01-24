package com.lucheng.search;

import com.lucheng.search.Leetcode153;
import org.junit.Test;

public class testLeetcode153 {

    @Test
    public void test(){
        int[] nums = new int[]{8,9,1,2,3,4,5,6,7};
        Leetcode153 method = new Leetcode153();
        int min = method.findMin(nums);
        System.out.println("nums[]的最小值是:"+min);
    }

    @Test
    public void test1(){
        int[] nums = new int[]{1,2,3,4,5};
        Leetcode153 method = new Leetcode153();
        int min = method.findMin3(nums);
        System.out.println("nums[]的最小值是:"+min);
    }
}
