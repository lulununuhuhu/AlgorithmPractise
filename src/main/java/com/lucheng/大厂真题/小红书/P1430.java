package com.lucheng.大厂真题.小红书;

import java.util.Scanner;

/**
 * dp[i][j][k]:完成前i个事件并花费时间j和精力k后的最大快乐值
 *
 * dp[i][j][k] = max{dp[i-1][j-t[i]][k-h[i]]+a[i],dp[i-1][j][k]}
 */
public class P1430 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int T = scanner.nextInt();int H = scanner.nextInt();
        int[] time = new int[n+1];int[] energy = new int[n+1];int[] happy = new int[n+1];
        for (int i = 1; i <= n; i++) {
            time[i] = scanner.nextInt();
            energy[i] = scanner.nextInt();
            happy[i] = scanner.nextInt();
        }
        long[][][] dp = new long[n+1][T+1][H+1];
        for (int i = 1; i <= n ; i++) {
//            for (int j = 1; j <= T; j++) {
//                for (int k = 1; k <= H; k++) {
//                    if(j-time[i] >= 0 && k-energy[i] >= 0)
//                        dp[i][j][k] = Math.max(dp[i-1][j-time[i]][k-energy[i]]+happy[i],dp[i-1][j][k]);
//                }
//            }
            for (int j = T; j >= time[i]; j--) {
                for (int k = H; k >= energy[i]; k--) {
                    dp[i][j][k] = Math.max(dp[i-1][j-time[i]][k-energy[i]]+happy[i-1],dp[i-1][j][k]);
                }
            }
        }
        System.out.println(dp[n][T][H]);
    }
}
