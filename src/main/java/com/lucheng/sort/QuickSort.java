package com.lucheng.sort;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 8, 0,8,-1,58,-56};
        quickSort(nums,0, nums.length-1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] nums,int l,int r){
        if(l >= r)
            return;
        int pivot = nums[l];//中枢元素
        int i = l;int j = r;
        while (i < j){
            //找到第一个比中枢元素大的索引位置或指向左边界
            while(i< r && nums[i] <= pivot)  i++;
            //找到第一个比中枢元素小的索引位置或指向右边界
            while (j > l && nums[j] >= pivot) j--;
            if(i < j){
                //交换位置
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        //将中枢元素与nums[j]交换,因为j始终指向小于等于中枢元素的位置
        int tmp = nums[l];
        nums[l] = nums[j];
        nums[j] = tmp;

        quickSort(nums,l,j-1);
        quickSort(nums,j+1,r);
    }
}
