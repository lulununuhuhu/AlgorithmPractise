package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1045
 */
public class P1045 {
    private static int mod = (int) (Math.pow(10,9)+7);
    //选择的台阶不同对应一种爬山方案
    //能否从某个太纠结跨越到当前台阶需要满足：1. 跨越台阶数小于等于一次最多跨越台阶数（用for循环解决）  2. 台阶高度之和小于一次最高能爬的高度(利用前缀和计算高度之和)
    //dp[i]:爬到第i级台阶的方案数
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader.toString() = " + systemClassLoader.toString());
        System.out.println("systemClassLoader.getParent() = " + systemClassLoader.getParent());
        //接收输入数据
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int P = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] info = new int[N][];
        int[][] preSum = new int[N][];
        for (int i = 0; i < N; i++) {
            int M = scanner.nextInt();
            info[i] = new int[M+1];info[i][0] = M;
            preSum[i] = new int[M+1];
            for (int j = 1; j < M + 1; j++) {
                info[i][j] = scanner.nextInt();
                preSum[i][j] = preSum[i][j-1]+info[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            int[] dp = new int[info[i][0]+1];//dp[i]:爬到第i级台阶的方案数
            //初始化dp
            dp[0] = 1;
            if(info[i][1] > P){
                System.out.println(0);
                break;
            }
            dp[1] = 1;

            int len = info[i][0];
            for (int j = 2; j <= len; j++) {
                boolean climbFlag = false;
                int k = j - K >=0 ? j-K:0;
                for (; k < j; k++) {
                    if(check(info[i],P,j,k,preSum[i])){
                        //可以从第k级台阶到第j级台阶
                        dp[j] = (dp[j]+dp[k])%mod;
                        climbFlag = true;
                    }
                }
                if(climbFlag == false){
                    break;
                }
            }
            System.out.println(dp[len]);
        }
    }

    private static boolean check(int[] heights, int p, int j, int k, int[] preSum) {
        if(preSum[j]-preSum[k] <= p)
            return true;
        else
            return false;
    }
}
