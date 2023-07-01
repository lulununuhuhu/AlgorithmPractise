package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1145
 *
 */
public class P1145 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int g = scanner.nextInt();
        int[][] values  = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                values[i][j] = scanner.nextInt();
            }
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        int nextJ = m-1;//用于指向每一次行遍历后的最后一列的索引号
        loop:for (int i = 0; i < n; i++) {
            for (int j = 0; j <= nextJ; j++) {
                if(j > 0 && i > 0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+values[i][j];
                    if(dp[i][j] >= g){
                        res = Math.min(res,i+j);
                        nextJ = j-1;
                    }
                }
                else if(j == 0 && i > 0){
                    dp[i][j] = dp[i-1][j]+values[i][j];
                    if(dp[i][j] >= g){
                        res = Math.min(res,i+j);
                        nextJ = j-1;
                    }

                }
                else if(j > 0 && i == 0){
                    dp[i][j] = dp[i][j-1]+values[i][j];
                    if(dp[i][j] >= g){
                        res = Math.min(res,i+j);
                        nextJ = j-1;
                    }
                }
                else {
                    dp[i][j] = values[i][j];
                    if(dp[i][j] >= g){
                        res = Math.min(res,i+j);
                        nextJ = j-1;
                    }
                }
                if(nextJ < 0)
                    break loop;
            }
        }
        System.out.println(res == Integer.MAX_VALUE ? -1:res);
    }
}
