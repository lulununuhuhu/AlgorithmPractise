package com.lucheng.search;

import com.lucheng.search.Leetcode475;
import org.junit.Test;

public class testLeetcode475 {
    @Test
    public void test(){
        int[] houses = new int[]{1,2,3};
        int[] heaters = new int[]{2};
        Leetcode475 method = new Leetcode475();
        int radius = method.findRadius(houses, heaters);
        System.out.println("最小半径是"+radius);
    }
}
