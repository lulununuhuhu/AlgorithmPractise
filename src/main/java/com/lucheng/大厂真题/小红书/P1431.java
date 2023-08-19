package com.lucheng.大厂真题.小红书;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 相邻节点是质数，则选深度大的那个节点染色
 */
public class P1431 {
    private static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n+1];
        List<Integer>[] tree  = new List[n+1];
        Arrays.setAll(tree,value -> new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree[u].add(v);tree[v].add(u);
        }
        dfs(tree,1,-1,values);
        System.out.println(ans);
    }

    private static void dfs(List<Integer>[] tree, int i, int fa, int[] values) {
        for (Integer child : tree[i]) {
            if(child == fa) continue;
            dfs(tree,child,i,values);
        }
        if(fa == -1) return;//已经回溯到了根节点
        if(isPrime(values[i]+values[fa])){
            //当前节点和父节点之和是质数，将当前节点染红然后答案+1
            ans++;
        }
    }

    /**
     * 判断i是否是质数
     * @param num
     * @return
     */
    private static boolean isPrime(int num) {
        int x = (int) Math.floor(Math.sqrt(num));
        for (int j = 2; j <= x; j++) {
            if(num % j == 0)    return false;
        }
        return true;
    }
}
