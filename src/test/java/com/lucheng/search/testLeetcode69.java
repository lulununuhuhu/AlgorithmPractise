package com.lucheng.search;

import com.lucheng.search.LeetCode69;
import org.junit.Test;

public class testLeetcode69 {

    @Test
    public void test(){
        LeetCode69 method = new LeetCode69();
        int x = 2147395599;
        System.out.println();
        int sqrt = method.mySqrt(x);
        System.out.println(x+"的平方根的整数部分："+sqrt);
    }
}
