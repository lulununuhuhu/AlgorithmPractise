package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1142
 */
public class P1142 {
    //dp[i]:以i为结尾的最长k阶子序列长度
    //状态转移方程：dp[i] = for j in [0:i-1] 取dp[i-j]+1的最大值(str[i-j]与str[i]的字符表距离小于k)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int k = scanner.nextInt();
        int[] dp = new int[str.length()];
        Arrays.fill(dp,1);
        int res = dynamicProgramming(str,dp,k);
        System.out.println(res);
    }

    private static int dynamicProgramming(String str, int[] dp, int k) {
        int len = str.length();
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(Math.abs(str.charAt(i)-str.charAt(j)) <= k)
                    dp[i] = Math.max(dp[j]+1,dp[i]);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
