package com.lucheng.大厂真题.DP.TreeDP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1170
 */
public class P1170 {
    private static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());//初始化
        }
        for (int i = 2; i <= n; i++) {
            int p = scanner.nextInt();
            g.get(i-1).add(p-1);
            g.get(p-1).add(i-1);
        }

        String s = scanner.next();

        //cnt[i][0]:以i为根的树的R(红)的数量   cnt[i][1]:以i为根的树的G(绿)的数量  cnt[i][2]:以i为根的树的B(蓝)的数量
        int[][] cnt = new int[n][3];
        // first = true 表示是在统计整个树的 RGB
        // first = false 表示是在统计答案
        dfs(0,-1,true,g,s,cnt);
        ans = 0;
        dfs(0,-1,false,g,s,cnt);

        System.out.println(ans);
    }

    /**
     *
     * @param u 当前遍历树的根节点
     * @param fa  u的父节点(father)
     * @param first fisrt为true，统计过每个点的rgb
     * @param g 树的存储结构 邻接表
     * @param s
     * @param cnt
     */
    private static void dfs(int u, int fa, boolean first, List<List<Integer>> g, String s, int[][] cnt) {
        for (Integer v : g.get(u)) {
            if(v == fa) continue;
            dfs(v,u,first,g,s,cnt);
            if(first){
                //累加子树中的所有rgb
                for(int j = 0;j < 3;j++) cnt[u][j] += cnt[v][j];
            }else {
                //如果断掉u-v这条边，使得两棵树都有RGB，则答案+1
                if(check(cnt[v],cnt[u])) ans += 1;
            }
        }
        //加上当前节点的rgb值
        if(first) cnt[u][idx(s.charAt(u))] += 1;
    }

    private static int idx(char ch) {
        if(ch == 'R') return 0;
        else if(ch == 'G') return 1;
        else return 2;
    }

    private static boolean check(int[] A, int[] B) {
        for (int i = 0; i < 3; i++) {
            if(A[i] == 0 || B[i] == A[i])
                return false;
        }
        return true;
    }
}
