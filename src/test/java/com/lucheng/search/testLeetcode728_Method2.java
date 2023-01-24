package com.lucheng.search;

import com.lucheng.search.Leetcode728_Method2;
import org.junit.Test;

import java.util.List;

public class testLeetcode728_Method2 {
    @Test
    public void test(){
        int left = 1;int right = 22;
        Leetcode728_Method2 method = new Leetcode728_Method2();
        List<Integer> integerList = method.selfDividingNumbers(left, right);
        System.out.println("["+left+","+right+"]"+"范围内的自除数有:");
        integerList.forEach(System.out::print);
    }
}
