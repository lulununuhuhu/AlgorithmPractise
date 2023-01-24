package com.lucheng.search;

/**
 * 面试题10.03
 * https://leetcode.cn/problems/search-rotate-array-lcci/description/
 */
public class Interview1003 {

    /**
     * 初始化left为0，right为arr.length-1
     * # 1当arr[left]和arr[right]相等时，如果：arr[left] = arr[right] = target 返回left
     *                                  否则 left++,right--
     *  执行# 1过程，直到arr[left]!=arr[right]，以恢复二段性
     *
     *  #2 在恢复二段性后，middle两边其中必有一边有序，根据target和两端关系确定下一个区间在左边还是右边？
     *
     *  #3 确定好区间后，采用大于等于的二分查找模板，找到第一个等于target的元素索引
     */
    public int search(int[] arr,int target){
        int left = 0;int right = arr.length-1;
        while(left <= right){
            if(arr[left] == arr[right]){
                if(arr[left] == target) return left;
                else{
                    left++;right--;
                }
            }else{
                int middle = left + ((right-left)>>1);
                if(arr[middle] >= arr[left]){
                    //左半边有序
                    if(target>=arr[left]&&target<=arr[middle])
                        return find(arr,left,middle,target);
                    else
                        left = middle+1;
                }else {
                    //右半边有序
                    if(target>=arr[middle] && target<=arr[right])
                        return find(arr,middle,right,target);
                    else
                        right = middle-1;
                }
            }
        }
        return -1;
    }

    //在nums数组的[l,r]区间中找到第一个等于target的元素索引
    private int find(int[] nums,int l,int r,int target){
        while(l <= r){
            int mid = l + ((r-l)>>1);
            if(nums[mid] < target)
                l = mid +1;
            else
                r = mid-1;
        }
        return l == nums.length || nums[l]!=target ? -1:l;
    }
}
