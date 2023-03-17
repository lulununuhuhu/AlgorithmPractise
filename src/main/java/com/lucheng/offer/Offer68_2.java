package com.lucheng.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class Offer68_2 {

    private Deque<TreeNode> p_path = new LinkedList<>();
    private Deque<TreeNode> q_path = new LinkedList<>();
    private Boolean finishFlag = false;


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;root.right = node2;
        node2.left = node3;node2.right = node4;
        Offer68_2 instance = new Offer68_2();
        instance.lowestCommonAncestor(root,node3,node1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFS_P(root,p);
        finishFlag = false;
        DFS_Q(root,q);
        //找到最后一个相同的节点就是最近公共祖先节点
        TreeNode pre = null;
        TreeNode ancestorP = p_path.poll();
        TreeNode ancestorQ = q_path.poll();
        while (ancestorQ == ancestorP){
            pre = ancestorP;
            ancestorP = p_path.poll();
            ancestorQ = q_path.poll();
        }
        return pre;
    }

    private void DFS_P(TreeNode root,TreeNode target){
        if(finishFlag == true || root == null)
            return;
        p_path.offerLast(root);
        if(root == target){
            finishFlag = true;
            return;
        }
        DFS_P(root.left,target);
        DFS_P(root.right,target);
        if(finishFlag != true)
            p_path.pollLast();
    }
    private void DFS_Q(TreeNode root,TreeNode target){
        if(finishFlag || root == null)
            return;
        q_path.offerLast(root);
        if(root == target){
            finishFlag = true;
            return;
        }
        DFS_Q(root.left,target);
        DFS_Q(root.right,target);
        if(finishFlag != true)
            q_path.pollLast();
    }
}
