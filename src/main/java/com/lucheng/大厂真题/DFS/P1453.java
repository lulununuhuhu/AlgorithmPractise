package com.lucheng.大厂真题.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1453 {
    private static long res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();int k = scanner.nextInt();
        List<Integer>[] tree = new List[n+1];
        Arrays.setAll(tree,e->new ArrayList<Integer>());
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree[u].add(v);
        }
        dfs(1,0,tree,k);
        System.out.println(res);
    }

    private static void dfs(int i,int dis, List<Integer>[] tree, int k) {
        List<Integer> childNodes = tree[i];
        if(childNodes.size() != 0 && dis <= k) //当前节点不是叶子节点
            res++;
        if(childNodes.size() == 0 && dis < k){
            //当前节点是叶子节点
            res += k-dis+1;//别忘了把自己也加上
            return;
        }
        for (Integer childNode : childNodes) {
            dfs(childNode,dis+1,tree, k);
        }
    }
}
