package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1215
 *
 * 塔子哥是一个喜欢拼图的小男孩，有一天，他收到了一份神秘的礼物。打开后，他发现里面是一个由英文字母组成的二维矩阵，每个字母都是一块拼图。
 * 塔子哥觉得很好奇，就开始拼接这个矩阵。他发现，这个矩阵有一个特殊的规则，就是他只能从左上角开始，每次向右或向下移动一步，然后收集拼图上的英文字母。而且，每个字母都有一个分数，大写字母的分数比小写字母的分数高，所以塔子哥很想收集大写字母。
 * 塔子哥想知道，他最多可以收集多少个大写字母。你能帮帮他吗？
 *
 * 样例
 * 5 5
 * AaBbb
 * bAaBa
 * CacAc
 * AbcBC
 * cbAbA
 */
public class P1215 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] martrix = new char[n][m];
        for (int i = 0; i < n; i++)
                martrix[i] = scanner.next().toCharArray();
        int[][] dp = new int[n][m];//dp[i][j]表示到(i,j)的最多大写字母数
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j > 0 && i > 0){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])+(martrix[i][j]>='a'?0:1);
                    res = Math.max(res,dp[i][j]);
                }
                else if(j == 0 && i > 0){
                    dp[i][j] = dp[i-1][j]+(martrix[i][j]>='a'?0:1);
                    res = Math.max(res,dp[i][j]);
                }
                else if(j > 0 && i == 0){
                    dp[i][j] = dp[i][j-1]+(martrix[i][j]>='a'?0:1);
                    res = Math.max(res,dp[i][j]);
                }
                else {
                    dp[i][j] = martrix[i][j]>='a'?0:1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        System.out.println(res);
    }
}
