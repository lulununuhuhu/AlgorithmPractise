package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1039
 */
public class P1039 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] stair = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            stair[i] = scanner.nextInt();
        }
        //dp[i]:爬到第i阶的最小花费
        //dp[i] = Min(dp[i-k]+花费体力,dp[i-k+1]+花费体力,...,dp[i-1]+花费体力)
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - k; j <i; j++) {
                if(j < 0) continue;
                int strengthValue = Math.max(0,stair[i]-stair[j]);
                dp[i] = Math.min(dp[j]+strengthValue,dp[i]);
            }
        }
        System.out.println(dp[n-1]);
    }
}
