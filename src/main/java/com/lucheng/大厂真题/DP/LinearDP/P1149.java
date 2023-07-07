package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1149
 */
public class P1149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();//商店数量
        //dp[i]:到第i个关卡时可以获得的最多钱
        int[] dp = new int[n+1];
        int[] last = new int[n+1];//last[x]:记录宝石x最后一次出现时所在的关卡
        int res = 0;
        scanner.nextLine();
        //到达一个关卡是boss，不会产生收益，所以dp[i] = dp[i-1]
        // 到一个商店无非就是选择兑换或者不兑换宝石。兑换宝石则收益变为dp[x]+price(x),x是最后一次获得宝石种类为x的关卡时的收益，不兑换宝石则收益等于dp[i-1];选择这两种情况下最大的一个
        for (int i = 1; i <= n; i++) {
            String[] s = scanner.nextLine().split(" ");
            if("b".equals(s[0])){
                //这一关是boss，不会产生收益
                dp[i] = dp[i-1];
                //记录last数组
                last[Integer.parseInt(s[1])] = i;
            } else if ("m".equals(s[0])) {
                //这一关是商店
                if(last[Integer.parseInt(s[1])] != 0)//这关的商店可以兑换的宝石之前出现过
                    dp[i] = Math.max(dp[i-1],Integer.parseInt(s[2])+dp[last[Integer.parseInt(s[1])]]);
                else
                    dp[i] = dp[i-1];//这关的商店出售的宝石没有哪一关可以获得
            }
            res = Math.max(res,dp[i]);
        }
        System.out.println(res);
    }
}
