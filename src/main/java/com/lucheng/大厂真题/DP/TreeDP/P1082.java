package com.lucheng.大厂真题.DP.TreeDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1082 {
    private static int[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer>[] tree = new List[n+1];
        memory = new int[n+1];
        Arrays.fill(memory,-1);
        Arrays.setAll(tree,value -> new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int li = scanner.nextInt();
            int ri = scanner.nextInt();
            if(li != -1)
                tree[i].add(li);
            if(ri != -1)
                tree[i].add(ri);
        }
        isFullBinaryTree(tree, 1);
        int res = 0;
        for (int i : memory) {
            if(i>=0) res++;
        }
        System.out.println(res);
    }

    /**
     * 判断以i为根节点的子树是否是满二叉树
     *
     * @param tree
     * @param i
     * @return
     */
    private static boolean isFullBinaryTree(List<Integer>[] tree, int i) {
        List<Integer> childNodes = tree[i];
        boolean flag = false;//判断当前的子树是否是满二叉树
        for (Integer childNode : childNodes) {
            if(isFullBinaryTree(tree,childNode) == true){
                flag = true;
            }else {
                flag = false;
            }
        }
        if(childNodes.size() == 0){
            //没有儿子节点，那就返回true
            memory[i] = 0;
            return true;
        }
        if(childNodes.size() == 1){
            //只有一个儿子节点，肯定不是满二叉树
            return false;
        }
        int lchild = childNodes.get(0);int rchild = childNodes.get(1);
        if(flag == true && memory[lchild] == memory[rchild]){
            memory[i] = memory[lchild]+1;
            return true;
        }else
            return false;
    }
}
