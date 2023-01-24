package com.lucheng.search;

/**
 * 二分查找的应用：确定上下界范围
 */

import java.util.Arrays;

/**
 * 例：给定一个排序数组（可能有重复数据）和一个目标值返回在不同条件下它将会被插入的位置。
 */

public class BinarySearch2 {
    /**
     * 模板一：找到大于等于target的第一个元素的索引位置
     * */
    public int getInsertIndexMethod1(int[] nums,int target){
        //第一种写法:左闭右闭
        int left = 0;int right = nums.length-1;
        while(left <= right){
            int middle = (left+right)/2;
            if(nums[middle] < target)
                left = middle+1;
            else  right = middle-1;
        }
        return left == nums.length ? -1:left;
        //第二种写法：左闭右开
//        int left = 0; int right = nums.length;
//        while(left < right){
//            int middle = left + ((right-left)>>1);
//            if(nums[middle] < target)
//                left = middle+1;//更新后的left左侧都是小于target的
//            else right = middle;//更新后的right及right右侧都是大于等于target的
//        }
//        return right == nums.length ? -1:right;
    }

    /**
     * 模板二：找到大于target的第一个元素的索引位置
     */
    public int getInsertIndexMethod2(int[] nums,int target){
        //第一种写法：左闭右闭
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int middle = left + ((right-left)>>1);
            if(nums[middle] <= target)
                left = middle+1;//left左侧均小于等于target
            else right = middle-1;//right右侧均大于target
        }
        return left == nums.length ? -1:left;//left等于nums.length表示所有元素都小于等于target

        //第二种写法：左闭右开
//        int left = 0;int right = nums.length;
//        while (left < right){
//            int middle = left + ((right-left)>>1);
//            if(nums[middle] <= target)
//                left = middle+1;//left左侧都小于等于target
//            else right = middle;//right及其右侧都大于target
//        }
//        return right == nums.length ? -1: left;
    }

    /**
     * 模板三：找到小于等于target的最后一个元素的索引位置
     */

    public int getInsertIndexMethod3(int[] nums,int target){
        //左闭右闭写法
        int left = 0;int right = nums.length-1;
        while(left <= right){
            int middle = left + ((right-left)>>1);
            if(nums[middle] <= target)
                left = middle+1;//left左侧都是小于等于target
            else right = middle-1;//right右侧都是大于target
        }
        return right;//right=-1表示没有元素小于等于target

        //左闭右开写法
//        int left = 0;int right = nums.length;
//        while(left < right){
//            int middle = left + ((right-left)>>1);
//            if(nums[middle] <= target)
//                left = middle+1;//left左侧都是小于等于target
//            else
//                right = middle;//right及right右侧都是大于target
//        }
//        return right-1;
    }

    /**
     * 模板四：找到小于target的最后一个元素的索引位置
     */
    public int getInsertIndexMethod4(int[] nums,int target){
        //左闭右闭写法
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int middle = left + ((right-left)>>1);
            if(nums[middle] < target)
                left = middle+1;//left左侧都是小于target
            else right = middle-1;//right右侧都是大于等于target
        }
        return right == -1 ? -1:right;//-1:表示没有元素小于target

        //左开右闭写法
//        int left = 0;
//        int right = nums.length-1;
//        while (left <= right){
//            int middle = left + ((right-left)>>1);
//            if(nums[middle] < target)
//                left = middle+1;//left左侧都小于等于target
//            else
//                right = middle;//right及right右侧都大于等于target
//        }
//        return right-1;
    }
}
