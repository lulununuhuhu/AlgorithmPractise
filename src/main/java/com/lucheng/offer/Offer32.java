package com.lucheng.offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer32 {
    public static void main(String[] args) {
        //创建树
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;root.right = node2;
        node2.left = node3;node2.right = node4;
        Offer32 instance = new Offer32();
        List<List<Integer>> res = instance.levelOrder(root);
        System.out.println(res);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)    return res;
        Queue<Node> sequence = new LinkedList<>();
        sequence.offer(new Node(root,0));
        int curLevel = 0;
        List<Integer> item = new ArrayList<>();
        while(!sequence.isEmpty()){
            Node element = sequence.poll();
            if(element.level == curLevel)
                item.add(element.node.val);
            else{
                //对item进行拷贝后加入res中
//                List<Integer> copy = new ArrayList<Integer>();
//                copy.addAll(item);
//                res.add(copy);
                res.add(new ArrayList<Integer>(item));
                item.clear();
                item.add(element.node.val);
                curLevel = element.level;
            }

            if(element.node.left != null)
                sequence.offer(new Node(element.node.left,curLevel+1));

            if(element.node.right != null)
                sequence.offer(new Node(element.node.right,curLevel+1));
        }
        res.add(item);//把最后一层也添加上
        return res;
    }

    class Node{
        TreeNode node;
        int level;
        public Node(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

