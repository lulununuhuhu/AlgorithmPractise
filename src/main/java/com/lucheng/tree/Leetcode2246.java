package com.lucheng.tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/
 */
public class Leetcode2246 {
    private List<Integer>[] tree;
    private int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parent = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();//将输入数字转化为数组
        String s = scanner.nextLine();
        Leetcode2246 leetcode2246 = new Leetcode2246();
        leetcode2246.longestPath(parent,s);
    }
    public int longestPath(int[] parent, String s) {
        //1.构建树
        int len = parent.length;
        tree = new ArrayList[len];
        Arrays.setAll(tree,node->new ArrayList<>());
        for (int i = 1; i < len; i++) {
            tree[parent[i]].add(i);
        }
        dfs(0,s);
        return 0;
    }

    private Object[] dfs(int i , String s) {
        int childNums = tree[i].size();
        if(childNums == 0)
            return new Object[]{-1,s.charAt(i)};
        for (int j = 0; j < childNums; j++) {
            Object[] info = dfs(tree[i].get(j), s);
        }
        return null;
    }
}
