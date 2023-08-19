package com.lucheng.大厂真题.DP.TreeDP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * dp[i][0]:以i为根节点的子树且第一条路径为B的最大通讯路径   dp[i][1]:以i为根节点的子树且第一条路径为R的最大通讯路径
 *
 * 遍历i节点的每一个子节点j
 *      如果 i和j是R dp[i][1] = max{dp[j][0]}+1
 *      如果 i和j是B dp[i][0] = max{dp[j][1}+1
 *
 * 结果: 任意i, max{dp[i][0]}+max{dp[i][1]}
 */
public class P1065 {
    private static int[][] dp;
    private static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer,String>[] tree = new HashMap[n+1];
        dp = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            tree[i] = new HashMap<>();
        }
        for (int i = 1; i <= n-1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            String chr = scanner.next();
            tree[u].put(v,chr);
            tree[v].put(u,chr);
        }
        dfs(1,-1,tree);
        System.out.println(ans);
    }

    private static int[] dfs(int i, int fa, HashMap<Integer, String>[] tree) {
        int red = 0,blue = 0;
        for (Map.Entry<Integer, String> entry : tree[i].entrySet()) {
            int child = entry.getKey();
            if(child == fa) continue;
            int[] dfs = dfs(child, i, tree);
            String childColor = entry.getValue();
            if("R".equals(childColor)){
                red = Math.max(red,dfs[1]+1);
            }else{
                blue = Math.max(blue,dfs[0]+1);
            }
        }
        ans  = Math.max(ans,red+blue);
        return new int[]{red,blue};
    }
}
