package com.lucheng.search;

/**
 * 二叉查找的几种写法
 */
public class BinarySearch {

    /**
     * 写法1 左闭右闭法,即搜索区间是[left,right]
     * @return
     */
    public int binarySearchMethod1(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){//left > right是终止条件
            int middle = (right+left)/2;
            if(nums[middle]> target)
                right = middle-1;
            else if(nums[middle]<target)
                left = middle+1;
            else return middle;
        }
        return -1;
    }

    /**
     * 写法2 左闭右开法，搜索区间是[left,right)
     * @return
     */
    public int binarySearchMethod2(int[] nums,int target){
        int left = 0;
        int right = nums.length; //初始搜索区间是[0,nums.length)
        while(left <  right){//因为初始区间是左闭右开所以left和right不能相等，不然无意义
            int middle = (left+right)/2;
            if(nums[middle] > target)
                right = middle;
            else if(nums[middle] < target)
                left = middle+1;
            else return middle;
        }
        return -1;
    }

    /**
     * 左开右闭法
     * @param nums
     * @param target
     * @return
     */
    public int binarySearchMethod3(int[] nums,int target){
        int left = -1;
        int right = nums.length-1;
        while(left<right){
            int middle = (left+right+1)/2;
            if(nums[middle]>target)
                right = middle-1;
            else if(nums[middle]<target)
                left = middle;
            else return middle;
        }
        return -1;
    }
}
