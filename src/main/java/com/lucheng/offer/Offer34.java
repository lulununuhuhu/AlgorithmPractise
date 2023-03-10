package com.lucheng.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer34 {
    private List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public static void main(String[] args) {
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
        Offer34 offer34 = new Offer34();
        List<List<Integer>> res = offer34.pathSum(root, 30);
        System.out.println("结果是:"+res);
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target,0);
        return res;
    }

    private void dfs(TreeNode node,int target,int curValue){
        //当前遍历节点为空 返回
        if(node == null)    return;
        //curValue+当前遍历节点值 大于 target 返回
        if(curValue+ node.val > target) return;
        //将节点值写入path中
        path.add(node.val);
        // curValue+当前遍历节点值 等于 target 写入res成员变量中,然后将路径中的最后一个节点 返回
        if(node.left == null && node.right == null && curValue+node.val == target){
            res.add(new ArrayList<>(path));
            path.pollLast();
            return;
        }
        //curValue+当前遍历节点值 小于 target :继续递归左孩子节点和右孩子节点
        dfs(node.left,target,curValue+ node.val);
        dfs(node.right,target,curValue+ node.val);

        //当前节点下的所有路径已遍历完成，退出该节点
        path.pollLast();
    }
}
