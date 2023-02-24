package com.lucheng.offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer32III {

    public static void main(String[] args) {
        //创建树
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;root.right = node2;
        node2.left = node3;node2.right = node4;
        Offer32III instance = new Offer32III();
        List<List<Integer>> res = instance.levelOrder(root);
        System.out.println(res);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null)    return res;

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();//ArrayDeque:基于数组实现的双端队列

        nodeQueue.offer(root);
        boolean isOrderLeft = true;//true：从左往右遍历   false:从右往左遍历

        while (!nodeQueue.isEmpty()){
            Deque<Integer> levelList = new LinkedList<>();//LinkedList:基于链表实现的双端队列
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();//poll:弹出队列首元素
                if(isOrderLeft)
                    levelList.offerLast(curNode.val);
                else
                    levelList.offerFirst(curNode.val);
                if(curNode.left != null)
                    nodeQueue.offer(curNode.left);
                if(curNode.right != null)
                    nodeQueue.offer(curNode.right);
            }
//            res.add(new LinkedList<Integer>(levelList));
            res.add((List<Integer>) levelList);
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
