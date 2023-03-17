package com.lucheng.offer;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }

    public static TreeNode inialTree(){
        //初始化树
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(18);
        TreeNode node6 = new TreeNode(0);
        root.left = node1;root.right = node2;
        node2.left = node3;node2.right = node4;
        node1.left = node5;node5.left = node6;
        return root;
    }
    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
