package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1066
 */
public class P1066 {
    private static int n;
    private static int[] num;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        int res = dynamicProgramming();
        System.out.println(res);
    }


    private static int dynamicProgramming() {
        int res = 1;
        int pre = 1;//维护dp[i-1]
        for (int i = 1; i < n; i++) {
            if(Math.abs(num[i]-num[i-1])<=1){
                pre = pre+1;//dp[i] = dp[i-1]+1
                res = Math.max(res,pre);
            }else
                pre = 1;//pre变为1
        }
        return res;
    }
}
