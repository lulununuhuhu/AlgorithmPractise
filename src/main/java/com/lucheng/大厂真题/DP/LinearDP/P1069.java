package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1069
 * dp[i][j][2]:dp[i][j][1]前i件商品中，花j块钱且第i件商品是半价买的最大喜爱度
 * 初始化:dp[i+1][j+1][2]
 * dp[i][j][0] =
 * 遍历顺序：先遍历商品数i 再遍历金额j
 * 结果：返回最大值
 */
public class P1069 {
    private static int n;//商品数量
    private static int x;//初始金额数
    private static int[] money;//商品价格
    private static int[] like;//喜爱度
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n= scanner.nextInt();x = scanner.nextInt();
        money = new int[n+1];like = new int[n+1];
        for (int i = 1; i <= n; i++) {
            money[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            like[i] = scanner.nextInt();
        }
        int res = dynamicProgramming();
        System.out.println(res);
    }

    private static int dynamicProgramming() {
        int res = 0;
        //初始化状态数组
        int[][][] dp = new int[n+1][x+1][2];
        for (int i = 1; i <= n; i++) {//i：前i件商品
            for (int j = 1; j <= x; j++) {//j:金钱额
                if(j-money[i] >= 0){
                    dp[i][j][0] = dp[i-1][j-money[i]][1]+like[i];
                    dp[i][j][1] = dp[i-1][j-money[i]/2][0]+like[i];
                } else if (j-money[i]/2 >= 0 && dp[i-1][j-money[i]/2][0] != 0 ) {
                        dp[i][j][1] = dp[i-1][j-money[i]/2][0]+like[i];
                }
                res = Math.max(res,Math.max(dp[i][j][0],dp[i][j][1]));
            }
        }
        return res;
    }
}
