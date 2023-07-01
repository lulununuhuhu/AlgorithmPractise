package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

public class P1035 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//N:跳棋格数
        int[] M = new int[N];//M:记录每一格的分数
        int[] dp = new int[N];//dp[i]:到第i格获取的最高分数
        for (int i = 0; i < N; i++) {
            M[i] = scanner.nextInt();
        }
        int res = 0;
        //初始化dp数组
        dp[0] = M[0];dp[1] = M[1];
        res = Math.max(dp[0],dp[1]);
        //每一个dp[i]取所有与i不相邻格子的最大值+自己格子的值
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[j]+M[i],dp[i]);//状态转移方程
            }
            res = Math.max(res,dp[i]);//取dp[i]的最大值
        }

        System.out.println(res);
    }
}
