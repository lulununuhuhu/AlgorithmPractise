package com.lucheng.offer;

// Definition for a Node.
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
    public static Node initiateBinarySearchNode(){
        //初始化一个二叉平衡树
        Node root = new Node(15);
        Node node1 = new Node(7);
        Node node2 = new Node(20);
        Node node3 = new Node(3);
        Node node4 = new Node(9);
        Node node5 = new Node(18);
        root.left = node1;root.right = node2;
        node1.left = node3;node1.right = node4;
        node2.left = node5;
        return root;
    }
    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
