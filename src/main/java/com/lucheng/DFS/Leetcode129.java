package com.lucheng.DFS;

/**
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/
 */
public class Leetcode129 {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        //遍历每个节点时，记录累加值
        //如果节点为空，说明上一个节点没有左节点或者右节点（不能算一条路径，不能加入结果中）
        //遍历节点是叶子节点，则累加值加上当前值就是一条路径的长度
        dfs1(root,0);
        return sum;
    }


    private void dfs1(TreeNode root,int curSum){
        if(root == null)    return;
        if(root.left == null && root.right == null){
            curSum = curSum*10+root.val;
            sum += curSum;
            return;
        }
        curSum += root.val;
        dfs1(root.left,curSum);
        dfs1(root.right,curSum);
    }
}
