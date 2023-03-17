package com.lucheng;

/**
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer65 {
    public static void main(String[] args) {
        Offer65 offer65 = new Offer65();
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int res = offer65.add(a, b);
        System.out.println("结果是:"+res);
    }
    public int add(int a, int b) {
        //a+b等于不进位结果+进位结果
        //不进位的结果 a^b
        //进位的结果  (a&b)<<1
        while (b != 0) {
            int carry = (a&b)<<1;
            a = a^b;
            b = carry;
        }
        return a;
    }
}
