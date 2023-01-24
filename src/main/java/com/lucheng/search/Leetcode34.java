package com.lucheng.search;

/**
 * 在排序数组中查找元素的第一个位置和最后一个位置
 */
public class Leetcode34 {

    public int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirstIndex(nums, target);
        int secondIndex = findFirstIndex(nums, target+1);
        if(firstIndex == nums.length || nums[firstIndex] != target)   return new int[]{-1,-1};
        return new int[]{firstIndex,secondIndex-1};
    }

    //找到在数组中大于等于target的第一个位置
    private int findFirstIndex(int[] nums,int target){
        int left = 0;int right = nums.length;
        while(left < right){
            int middle = (left+right)/2;
            if(nums[middle]>=target)
                right = middle;
            else left = middle+1;
        }
        return left;
    }
}
