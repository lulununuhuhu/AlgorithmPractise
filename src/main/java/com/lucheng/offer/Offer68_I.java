package com.lucheng.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer68_I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 一次遍历法：从root节点开始，当当前遍历节点满足
         *              cur.val >= p.val && cur.val <= q.val或者cur.val <= p.val && cur.val >= q.val时，当前节点就是最近公共ancestor节点
         */
        TreeNode ancestor = root;
        Deque<Integer> que = new LinkedList<>();
        while (ancestor != null){
            if(ancestor.val >= p.val && ancestor.val <= q.val || ancestor.val <= p.val && ancestor.val >= q.val)
                return ancestor;
            if(ancestor.val > p.val && ancestor.val > q.val)
                ancestor = ancestor.left;
            else
                ancestor = ancestor.right;
        }
        return null;
    }
}
