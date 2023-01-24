package com.lucheng.search;

import java.util.Arrays;
import java.util.Collections;

/**
 * 贪心地模拟分割的过程，从前到后遍历数组，用 sum 表示当前分割子数组的和，cnt表示已经分割出的子数组的数量（包括当前子数组），
 * 那么每当 sum 加上当前值超过了 x，我们就把当前取的值作为新的一段分割子数组的开头，
 * 并将cnt加1。遍历结束后验证是否cnt不超过k。
 *
 * 二分查找策略:二分查找的上界是数组之和,二分查找的下界是数组的最大值。
 *            check函数:返回分割数组后子数组数量cnt是否大于k  大于k返回true  小于等于k返回false
 *
 *           check函数返回true，说明最小值在左半段[middle+1,right)；返回false，说明最小值在右半段[left,middle]
 */
public class Leetcode410 {
    public int splitArray(int[] nums, int k) {
        //确定二分查找的上下界[left,right)
        int left = maxValue(nums);int right = sumValue(nums)+1;
        while(left < right){
            int middle = left + ((right-left)>>1);
            if(check(nums,k,middle))
                left = middle+1;
            else
                right = middle;
        }
        return right;
    }

    private boolean check(int[] nums,int k,int x){
        int sum = 0;
        int cnt = 1;
        for (int num : nums) {
            //计算cnt值,满足分割子数组和小于x的最大值
            sum += num;
            if(sum > x){
                cnt++;
                sum = num;
            }
        }
        return cnt>k;
    }

    private int maxValue(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num,max);
        }
        return max;
    }

    private int sumValue(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
