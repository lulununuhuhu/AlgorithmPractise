package com.lucheng.大厂真题.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  递归+回溯
 * */
public class P1470 {
    private static int mod = 1000000007;
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            sum += a[i];
        }
        List<Integer> b = new ArrayList<>();
        dfs(a, b, 1, sum, 0);
        System.out.println(ans);
    }

    private static void dfs(int[] a, List<Integer> b, int currentIndex, int targetSum, int curSum) {
        if (currentIndex == a.length) {
            //已经递归到最后一个点了
            if (curSum == targetSum) {
                ans = (ans + 1) % mod;
            }
            return;
        }
        for (int i = 1; i <= 500; i++) {
            if (a[currentIndex] == i) continue;
            if (curSum + i > targetSum) break;
            b.add(i);
            dfs(a, b, currentIndex + 1, targetSum, curSum + i);
            b.remove(b.size() - 1);//回溯
        }
    }
}
