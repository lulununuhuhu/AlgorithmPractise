package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1216
 *
 * 求两个小写字母的最长连续公共子串长度(注意区分最长公共子序列)
 */
public class P1216 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int res = 0;
        int len1 = str1.length();int len2 = str2.length();
        //确定状态转移方程含义：dp[i][j]:以str1[i]和str2[j]为结尾的最长公共字串长度
        int[][] dp = new int[len1][len2];
        //初始化
        for (int i = 0; i < len1; i++) {
            if(str1.charAt(i) == str2.charAt(0)){
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < len2; i++) {
            if(str2.charAt(i) == str1.charAt(0)){
                dp[0][i] = 1;
            }
        }

        //状态转移方程：if:str1[i]=str2[j] dp[i][j]=dp[i-1][j-1]+1
        //              else dp[i][j] = 0

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res,dp[i][j]);
                }else
                    dp[i][j] = 0;
            }
        }
        System.out.println(res);
    }
}
