package com.lucheng.DFS;

import java.util.Scanner;

/**
 * https://leetcode.cn/problems/path-sum/description/
 */
public class Leetcode112 {
    private boolean successFlag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return successFlag;
    }

    public static void main(String[] args) {
        //构建树
//        TreeNode node1 = new TreeNode(5);TreeNode node2 = new TreeNode(4);TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(11);TreeNode node5 = new TreeNode(13);TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(7);TreeNode node8 = new TreeNode(2);TreeNode node9 = new TreeNode(1);
//        node1.left = node2;node1.right=node3;node2.left=node4;
//        node3.left=node5;node3.right=node6;node4.left = node7;
//        node4.right=node8;node6.right=node9;
        Leetcode112 leetcode112 = new Leetcode112();
        TreeNode node1 = new TreeNode(1);TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        int targetSum = 0;
        leetcode112.dfs(node1,targetSum,0);
        System.out.println(leetcode112.successFlag);
    }
    private void dfs(TreeNode root,int targetSum,int curSum){
        if(successFlag == true)
            return;
        // if(root == null){//这样不能剔除当路径最后一个节点不是叶子节点的情况
        //     if(curSum == targetSum){
        //         successFlag = true;
        //     }else{
        //         successFlag = false;
        //     }
        // }
        if(root == null)    return;//当前节点为空则直接返回
        curSum += root.val;
        if(root.left == null && root.right == null){
            //该节点是叶子节点了
            if(curSum == targetSum){
                successFlag = true;
            }
            else{
                successFlag = false;
            }
            return;
        }
        dfs(root.left,targetSum,curSum);
        dfs(root.right,targetSum,curSum);
    }
}
