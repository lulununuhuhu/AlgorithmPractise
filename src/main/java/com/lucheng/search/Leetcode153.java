package com.lucheng.search;

public class Leetcode153 {
    public int findMin(int[] nums) {
        int left = 0;int right = nums.length-1;
        while(left < right){
            int middle = left + ((right-left)>>1);
            if(nums[middle] >= nums[right])
                left = middle+1;
            else right = middle;
        }
        return nums[left];
    }

    public int findMin2(int[] nums){
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
//        这里的r是数组中的极大值点
        return r + 1 < n ? nums[r + 1] : nums[0];
    }

    public int findMin3(int[] nums){
        int n = nums.length;
        int l = 0,r = n;
        while(l < r){
            int mid = l + ((r-l)>>1);
            if(nums[mid] >= nums[0])
                l = mid+1;
            else r = mid;
        }
        return l < n ? nums[l] : nums[0];
    }
}
