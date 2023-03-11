package com.lucheng.search;

import org.junit.Test;

public class testLeetcode378 {

    @Test
    public void test(){
        Leetcode378 method = new Leetcode378();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        int res = method.theKthSmallest(matrix, 8);
        System.out.println("第"+k+"小的元素是:"+res);

    }
}
