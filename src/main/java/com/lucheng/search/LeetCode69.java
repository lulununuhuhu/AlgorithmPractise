package com.lucheng.search;

/**
 * 求X的平方根的整数部分
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        //找到满足k^2 <= x条件的最大k值
        int left = 0;int right = x;//下界为0，上界为x
        while(left <= right){
            int middle = left + ((right-left)>>1);
            if((long)middle*middle < x)
                left = middle+1;
            else if((long)middle*middle > x)
                right = middle-1;
            else return middle;
        }
        return right;
    }
}
