package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * dp[i]:第i次抽到5星终极卡的概率
 * 前89次，即i<=89时，dp[i] = (1-∑dp[j])*p
 * 第90次时，(1-∑dp[j])*1/2
 * 第91次时，(1-∑dp[j])*1/2
 */
public class P471 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double p = scanner.nextDouble();
        double[] dp = new double[92];
        double res = 0;
        //第一部分：前89次 第二部分：第90次和第91次
        for (int i = 1; i <= 89; i++) {
//            if(i <= 89)
            dp[i] = (1-dp[i-1])*p;//dp[i-1]就是∑dp[j]
//            else
//                dp[i] = (1-dp[i-1])*0.5;
            res += dp[i]*i;
            dp[i] += dp[i-1];//dp[i]记录前缀和
        }
        res += 90 * (1 - dp[89]);


        System.out.println(String.format("%.7f",res*1.5));
    }
}
