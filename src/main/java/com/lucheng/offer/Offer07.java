package com.lucheng.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Offer07 {
    public static void main(String[] args) {
        Offer07 offer07 = new Offer07();
        int[][] res = offer07.findContinuousSequence2(25);
        return ;
    }
    public int[][] findContinuousSequence(int target) {
        if(target < 3)
            return null;
        List<int[]> res = new ArrayList<>();

        Deque<Integer> nums = new LinkedList<>();
        nums.offerLast(1);nums.offerLast(2);
        int next = 3;
        int curSum = 3;
        while(next < target){
            //退出条件：队列里只有两个数 && 两个数之和大于target
            if(nums.size() == 2 && curSum > target)
                break;
            if(curSum == target){
                Integer[] tmp = nums.toArray(new Integer[nums.size()]);
                int[] ans1 = new int[tmp.length];
                for (int i = 0; i < ans1.length; i++) {
                    ans1[i] = tmp[i];
                }
                res.add(ans1);
                curSum -= nums.pollFirst();
            }
            else if(curSum > target){
                curSum -= nums.pollFirst();
            }
            else{
                nums.offerLast(next);
                curSum += next++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 方法优化：[l,r]的区间和可以用求和公式进行计算:(l+r)*(r-l+1)/2
     * @param target
     * @return
     */
    public int[][] findContinuousSequence2(int target){
        List<int[]> res = new ArrayList<>();
        if(target < 3)
            return null;
        for(int l = 1,r = 2; l < target/2+1;){
            int sum = (l+r)*(r-l+1)/2;
            if(sum < target)
                r++;
            else if(sum == target){
                int[] tmp = new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    tmp[i-l] = i;
                }
                res.add(tmp);
                l+=2;r++;
            }
            else {
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
