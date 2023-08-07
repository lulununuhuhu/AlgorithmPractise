package com.lucheng.大厂真题.DP.TreeDP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1224 {
    static int n;
    static long l, r;
    static char[] s;
    static List<List<Integer>> g;
    static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextLong();
        r = scanner.nextLong();
        s = new char[n + 1];
        g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        String inputString = scanner.nextLine();
        inputString = scanner.nextLine();
        for (int i = 1; i <= n; i++) {
            s[i] = inputString.charAt(i - 1);
        }

        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }
        scanner.close();

        ans = 0;
        for (int i = 1; i <= n; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(ans);
    }

    public static void dfs(int cur, int u, int fa, long val) {
        val = val * 2 + (s[u] - '0');
        if (val > r)
            return;
        if (val >= l && u != cur)
            ans++;
        for (int v : g.get(u)) {
            if (v == fa)
                continue;
            dfs(cur, v, u, val);
        }
    }
}
