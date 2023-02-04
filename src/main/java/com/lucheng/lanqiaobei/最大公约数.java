package com.lucheng.lanqiaobei;

/**
 * 题目链接：https://www.dotcpp.com/oj/problem2709.html
 */

/**
 * 求最少操作次数就是求得获取某两个相邻数得最大公约数为1的最少操作次数
 */
public class 最大公约数 {
    public static void main(String[] args) {

    }

    /**
     * 求x和y的最大公约数
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x,int y){
        return y == 0 ? x:gcd(y,x%y);
    }
}
