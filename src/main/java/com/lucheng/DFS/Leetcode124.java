package com.lucheng.DFS;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */
public class Leetcode124 {
    private int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left=node2;node1.right=node3;
        node3.left = node4;node3.right=node5;
        Leetcode124 leetcode124 = new Leetcode124();
        leetcode124.maxPathSum(node1);
        System.out.println(leetcode124.res);
    }


    public int maxPathSum(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root){
        if(root == null)
            return Integer.MIN_VALUE;//返回该值时表示没有子节点了
        int val_left = dfs(root.left);
        int val_right = dfs(root.right);
        int val = (val_right==Integer.MIN_VALUE?0:val_right)+(val_left==Integer.MIN_VALUE?0:val_left)+root.val;//记录本层节点的和
        //计算出本层节点的最大值
        int max = 0;
        if(val_left == Integer.MIN_VALUE)//没有左孩子
            max = Math.max(val,val-val_right);
        else if (val_right == Integer.MIN_VALUE) {//没有右孩子
            max = Math.max(val,val-val_left);
        }else{
            //左右孩子都有
            max = Math.max(Math.max(val,val-val_left),val-val_right);
        }
        res = Math.max(res,max);
        return max;
    }
}
