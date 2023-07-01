package com.lucheng.bishiti.meituan0401;

import java.util.Scanner;

/**
 * 题目描述：
 * 你现在有一棵树，树上的每个节点都有自己的价值。价值的计算规则如下所示：
 * ① 若某节点N没有儿子节点，那么节点N价值为1；
 * ② 若某节点N有两个儿子节点，那么节点N价值为两个儿子节点的价值之和，或者价值之按位异或。这取决于节点N的颜色，
 * 若N的颜色为红色，那么节点N价值为两个儿子节点的价值之和；若N的颜色为绿色，那么节点N价值为两个儿子节点的价值之按位异或。
 * 保证这棵树要么没有儿子节点，要么有两个儿子节点。
 * 注：树，是一种无向无环联通图。
 * 按位运算就是基于整数的二进制表示进行的运算。按位异或用符号⊕表示，两个对应位不同时为1，否则为0。
 * 如：
 * 5=(101)2
 * 6=(110)2
 * 5⊕6=3，即 (101)2 ⊕ (110)2 = (011)2
 * 输入描述
 * 第一行一个正整数n表示节点个数。
 * 第二行n-1个正整数p[i](2≤i≤n)表示第 i 个节点的父亲。1号节点是根节点。
 * 第三行n个整数c[i](1≤i≤n)，当c[i] = 1时表示第 i 个节点是红色，c[i] = 2则表示绿色。
 * 数据保证形成合法的树。
 * 对于所有的数据，n≤50000
 * 输出描述
 * 输出一行一个整数表示根节点的值。
 * 样例输入
 * 3
 * 1 1
 * 2 2 2
 * 样例输出
 * 0
 *
 * //提示
 * 样例如图所示。
 * 因为2号节点和3号节点都没有儿子，因此值都为1。
 * 因为1号节点的颜色是绿色，因此1号节点的值是2号节点的值和3号节点的按位异或，为0。
 */
public class 价值 {
    private static int n;
    static class Tree{
        Tree left;
        Tree right;
        int color;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Tree[] tree = buildTree(sc);
        Tree root = tree[1];
        int value = lastOrder(root);
        System.out.println(value);
    }

    private static int lastOrder(Tree root) {
        if(root.left == null && root.right == null)
            return 1;
        if(root.color == 1 )
            return lastOrder(root.left)+lastOrder(root.right);
        else
            return lastOrder(root.left)^lastOrder(root.right);
    }

    private static Tree[] buildTree(Scanner sc) {
        Tree[] tree = new Tree[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new Tree();
        }
        for (int i = 2; i <= n; i++) {
            int parent = sc.nextInt();
            if(tree[parent].left == null)
                tree[parent].left = tree[i];
            else
                tree[parent].right = tree[i];
        }
        for (int i = 1; i <= n; i++) {
            int color = sc.nextInt();
            tree[i].color = color;
        }
        return tree;
    }
}
