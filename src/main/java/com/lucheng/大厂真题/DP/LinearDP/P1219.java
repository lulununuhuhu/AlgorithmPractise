package com.lucheng.大厂真题.DP.LinearDP;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1219
 */
public class P1219 {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] dp = new long[101];
        dp[1] = 1;dp[2] = 2;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i-1]+dp[i-2];//dp[i-1]：在第i个加油站不加油   dp[i-2]:在第i个加油站加油
        }
        System.out.println(dp[N]);
    }
}
