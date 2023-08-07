package com.lucheng.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 第K大的元素
 */
public class Leetcode215 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,8,0};
        int k = 2;
        int res = findKthLargest1(nums, k);
        System.out.println("第K大的元素是："+res);
    }

    public static int findKthLargest1(int[] nums, int k) {
        int res = 0;
        //初始化一个大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }
}
