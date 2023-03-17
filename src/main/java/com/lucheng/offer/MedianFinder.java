package com.lucheng.offer;

import java.util.PriorityQueue;

/**
 * 剑指Offer 41题
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median = medianFinder.findMedian();
        System.out.println("当前中位数是:"+median);
    }
    /** initialize your data structure here. */
    private PriorityQueue<Integer> queMin;
    private PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if(queMin.isEmpty() || num <= queMin.peek()){
            queMin.offer(num);
            if(queMin.size() > queMax.size()+1)
                queMax.offer(queMin.poll());
        }else{
            queMax.offer(num);
            if(queMax.size() > queMin.size())
                queMin.offer(queMax.poll());
        }
    }

    public double findMedian() {
        if((queMin.size()+queMax.size()) % 2 == 1)
            return queMin.peek();
        else
            return (queMin.peek()+queMax.peek())/2.0;
    }
}
