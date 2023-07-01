package com.lucheng.DP;

/**
 *
 */
public class Leetcode746 {
    public static void main(String[] args) {
        Leetcode746 leetcode746 = new Leetcode746();
        int[] cost = new int[]{10,15,20};
        int res = leetcode746.minCostClimbingStairs(cost);
        System.out.println(res);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //定义dp数组,dp[i]：到达第i级台阶需要的最小费用
        int[] dp = new int[n+1];
        //dp数组初始化
        dp[0] = 0;dp[1] = 0;
        //递归
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        //返回结果
        return dp[n];
    }
}
