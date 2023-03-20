package com.lucheng.offer;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
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
        node3.left = node4;node3.right = node2;
        node4.left = root;node4.right = node1;
        root.left = node6;node2.left = node5;
        return node3;
    }
    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
