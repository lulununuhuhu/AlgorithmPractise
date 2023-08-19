package com.lucheng.大厂真题.DP.TreeDP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * dp[i][0]:在i号节点不染色的情况下，以i号为根节点的子树的最大染色数量
 * dp[i][1]:在i号节点染色的情况下，以i号为根节点的子树的最大染色数量
 *
 * dp[i][0] = ∑max(dp[j][0],dp[j][1])(j属于所有子节点)
 *
 * dp[i][1] = max(dp[i][0]-max(dp[j][0],dp[j][1])+dp[j][0]+2)(j属于所有子节点)
 */
public class P1445 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt()-1;
            int v = scanner.nextInt()-1;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int[][] dp = new int[n][2];
        dfs(0,-1,g,dp,a);
        System.out.println(Math.max(dp[0][0],dp[0][1]));
    }

    private static void dfs(int u, int fa, List<List<Integer>> g, int[][] dp, List<Integer> a) {
        for(int v:g.get(u)){
            if(v == fa) continue;//保证只遍历儿子节点
            dfs(v,u,g,dp,a);//递归到叶子节点
            dp[u][0] += Math.max(dp[v][0],dp[v][1]);
        }

        for (int v: g.get(u)){
            if(v == fa) continue;
            long val = (long) a.get(v) *a.get(u);
            long sq = (long) Math.sqrt(val);
            if(sq * sq != val) continue;//u和v节点的乘积不是完全平方数
            dp[u][1] = Math.max(dp[u][1],(dp[u][0]-Math.max(dp[v][0],dp[v][1]))+dp[v][0]+2);
        }
    }
}
