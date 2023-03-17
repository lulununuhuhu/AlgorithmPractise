package com.lucheng.offer;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solutions/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer36 {
    private Node head;
    private Node pre;

    public static void main(String[] args) {
        Node root = Node.initiateBinarySearchNode();
        Offer36 offer36 = new Offer36();
        Node head = offer36.treeToDoublyList(root);
        System.out.println("循环双向链表的头节点是:"+head);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null)    return null;
        DFS(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void DFS(Node node){
        if(node == null)    return;
        DFS(node.left);
        //pre为null时，说明当前节点就是头节点
        if(pre == null)
            head = node;
        else{
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        DFS(node.right);
    }
}
