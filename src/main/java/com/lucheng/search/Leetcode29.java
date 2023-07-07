package com.lucheng.search;



public class Leetcode29 {
    private int INF = Integer.MAX_VALUE;

    public int divide(int dividend, int divisor) {
        long a = dividend;long b = divisor;
        boolean isPositive = false;//结果符号的标记.false:负数  true:正数
        if((a>0&&b>0)||(a<0&&b<0))  isPositive = true;
        a = a<0?-a:a;b = b<0?-b:b;//将a和b转化为大于0的数
//        a/b的范围:[0,dividend]
        /*  设a/b=x,x为整数，且范围是[0,dividend]
        * 二段性：x在整数数轴坐标中，当小于x的数y*b < a
        *                       大于x的数y*b > a
        * 通过二分查找，找到满足y*b<= a 的最大一个值
        * */
        long left = 0;long right = a;
        long x = 0;
        while(left <= right){
            long middle = left + ((right-left)>>1);
            if(mul(middle,b) > a){
                right = middle-1;
            }
            else{
                left = middle+1;
            }
        }
        right = isPositive == true ? right:-right;
        if(right > INF-1 || right < -INF) right = INF;
        return (int)right;
    }

    /**
     * 使用倍增法进行乘法计算
     * @param a
     * @param k
     * @return
     */
    public long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k >>= 1;
            a += a;
        }
        return ans;
    }
}
