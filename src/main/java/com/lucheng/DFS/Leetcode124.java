package com.lucheng.DFS;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 注意：至多出现一次说明该节点不能在序列中走回头路。所以导致每一个节点的最大贡献值只能是取该节点和左右子树贡献值最大的一个
 */
public class Leetcode124 {
    private int res = Integer.MIN_VALUE;
    private int[][] directions = new int[][]{{1,0},{2,2}};

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
            return Integer.MIN_VALUE;
        //计算左子树的最大贡献值(如果是负数，则为0)
        int val_left = Math.max(dfs(root.left),0);
        //计算右子树的最大贡献值
        int val_right = Math.max(dfs(root.right),0);
        int val_root =  root.val;//根节点的值

        //节点的最大路径和取决于该节点的值和左右子树的最大贡献值
        int max = val_root+val_left+val_right;
        res = Math.max(res,max);
        return val_root+Math.max(val_left,val_right);
    }
}
