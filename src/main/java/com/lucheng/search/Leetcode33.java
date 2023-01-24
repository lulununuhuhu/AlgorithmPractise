package com.lucheng.search;

public class Leetcode33 {

    public int search(int[] nums, int target) {
        int left = 0; int right = nums.length-1;
        while(left <= right){
            int middle = left +((right-left)>>1);
            if(nums[middle] == target)  return middle;
            if(nums[middle] >= nums[left]){
                //左半边有序
                if(target>= nums[left] && target < nums[middle])
                    right = middle-1;
                else
                    left = middle+1;
            }
            else{
                //右半边有序
                if(target > nums[middle] && target <= nums[right])
                    left = middle+1;
                else
                    right = middle-1;
            }
        }
        return -1;
    }
}
