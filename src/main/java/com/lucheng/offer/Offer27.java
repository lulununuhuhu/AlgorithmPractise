package com.lucheng.offer;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root){
        if(root == null)
            return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
