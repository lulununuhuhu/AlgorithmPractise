package com.lucheng.DP;

/**
 *
 */
public class Leetcode516 {
    public static void main(String[] args) {
        Leetcode516 leetcode516 = new Leetcode516();
        String s = "bbbab";
        int res = leetcode516.longestPalindromeSubseq(s);
        System.out.println(res);
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[][] dp = new int[n][n];
        //dp数组初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //遍历顺序：从下往上，从左往右
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i + 1; j < n; j++) {
                //进行递推
                if(c[i] == c[j])
                    dp[i][j] = dp[i+1][j-1]+2;
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        //返回结果:dp[0][n-1]  区间[0,n-1]的最大回文子序列长度
        return dp[0][n-1];
    }
}
