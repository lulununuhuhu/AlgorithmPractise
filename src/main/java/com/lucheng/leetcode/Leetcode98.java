package com.lucheng.leetcode;

import com.lucheng.offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class Leetcode98 {
    private Long pre = Long.MIN_VALUE;

    private boolean isFlag = true;

    public static void main(String[] args) {
        TreeNode root = TreeNode.inialTree();
        Leetcode98 instance = new Leetcode98();
        instance.isValidBST(root);
    }
    public boolean isValidBST(TreeNode root) {
        midOrder(root);
        return isFlag;
    }

    private boolean DFS(TreeNode root){
        // if((root.left == null || root.val > root.left.val) && (root.right == null || root.val < root.right.val))    return true;
        if(root == null)    return true;
        boolean leftFlag = DFS(root.left);
        boolean rightFlag = DFS(root.right);
        if(root.left == null && root.right == null)    return true;
        if(leftFlag&&rightFlag&&(root.left == null || root.val>root.left.val)&&(root.right == null || root.val<root.right.val))
            return true;
        else return false;
    }

    private void midOrder(TreeNode root){
        if(root == null)    return;
        midOrder(root.left);
        if(root.val <= pre){
            isFlag = false;
            return;
        }
        pre = Long.valueOf(root.val);
        midOrder(root.right);
    }
}
