package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * dp[n][10]:dp[i][j]:第i次操作时最后一个数字为j的方案数
 * 动态转移方程：
 *  初始化：第1次操作时dp[1][(nums[n-1]+nums[n-2])%mod]=1  dp[1][(nums[n-1]*nums[n-2])%mod]=1
 *  第i次操作：int a = (nums[n-i-1]+dp[i-1][0...9])%mod    int b = (nums[n-i-1]*dp[i-1][0...9])%mod
 *            dp[i][a] += dp[i-1][x](x就是dp[i-1][]的列号)
 *            dp[i][b] += dp[i-1][x](x就是dp[i-1][]的列号)
 */
public class P1447 {
    private static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[][] dp = new int[n][10];
        if(n == 1 && nums[0] >= 10){
            for (int i = 0; i < 10; i++) {
                System.out.print(dp[0][i]+" ");
            }
            return;
        }
        if(n == 1 && nums[0] < 10){
            dp[0][nums[0]] = 1;
            for (int i = 0; i < 10; i++) {
                System.out.print(dp[0][i]+" ");
            }
            return;
        }
        //初始化dp的第一次操作
        int i1 = (nums[n-1]+nums[n-2])%10;
        int i2 = (int) (((long)nums[n-1]*nums[n-2])%10);
        dp[1][i1] += 1;dp[1][i2] += 1;

        //状态转移
        for (int i = 2; i <= n-1; i++) {
            for (int j = 0; j < 10; j++) {
                int a = (nums[n-i-1]+j)%10;
                int b = (int) (((long)nums[n-i-1]*j)%10);
                dp[i][a] = (dp[i-1][j]+dp[i][a])%mod;
                dp[i][b] = (dp[i-1][j]+dp[i][b])%mod;
            }
        }

        //输出结果
        for (int i = 0; i < 10; i++) {
            System.out.print(dp[n-1][i]+" ");
        }
    }
}
