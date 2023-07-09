package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P2642
 *
 * 这道题是求最大字段和的升级版
 */
public class P2642 {
    private static int n;

    private static int[] nums;
    //设数组有i个数
    //dp1[j]表示[0,j]区间内的最大子段和
    //dp2[j]表示[j,i-1]区间内的最大子段和
    //dp[i]+dp[i+2]的和的最大值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        long res = dynamicProgramming(nums,n);
    }

    private static long dynamicProgramming(int[] nums, int n) {
        long res = 0;
        return 0;//未完待续
    }
}
