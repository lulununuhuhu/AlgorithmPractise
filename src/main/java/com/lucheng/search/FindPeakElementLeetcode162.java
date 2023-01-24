package com.lucheng.search;

import java.util.Arrays;

/**
 * 寻找峰值
 */
public class FindPeakElementLeetcode162 {
        public int findPeakElement(int[] nums) {
            // 如果nums[middle]>nums[middle+1],左边肯定有峰值；如果nums[middle]<nums[middle+1],右边肯定有峰值
            int left = 0;int right = nums.length-1;
            while(left < right){
                int middle = (left+right)/2;
                if(nums[middle]>nums[middle+1])
                    right = middle;
                else
                    left = middle+1;
            }
            return right;
        }

}
