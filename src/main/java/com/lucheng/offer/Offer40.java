package com.lucheng.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer40 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        int k = 2;
        int[] leastNumbers = getLeastNumbers(arr, k);
        System.out.println("结果是:"+leastNumbers);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0)
            return new int[]{};
        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });//创建优先队列，声明队列的性质是大根堆

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if(arr[i] < queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
