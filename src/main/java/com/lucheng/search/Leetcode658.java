package com.lucheng.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        //使用二分查找找到大于等于x的最小索引和小于x的最大索引
        int left = 0;int right = arr.length-1;
        while(left <= right){
            int middle = left + ((right-left)>>1);
            if(arr[middle] < x) left = middle+1;
            else right = middle-1;
        }

        //left:大于等于x的最小索引 right:小于x的最大索引
        //right=-1：均大于等于x  left=arr.length:均小于x
//        if(right == -1){
//            int idx = 0;
//            while(idx < k)    res.add(arr[idx++]);
//        }
//        else if(left == arr.length){
//            int idx = k;
//            while(idx > 0){
//                res.add(arr[arr.length-idx--]);
//            }
//        }
//        else{
//            int idx1 = left;int idx2 = right;
//            while(k-- > 0){
//                if(idx2 < 0 || (idx1 < arr.length && arr[idx1]-x < x-arr[idx2])){
//                    res.add(arr[idx1]);
//                    idx1++;
//                }else{
//                    res.add(arr[idx2]);
//                    idx2--;
//                }
//            }
//            Collections.sort(res);
//        }

//        判断逻辑的优化
        while (k-->0){
            if(right < 0){
                //arr元素均大于等于x
                left++;
            }else if(left == arr.length){
                //arr元素均小于x
                right--;
            }else{
                if(Math.abs(arr[right]-x) <= Math.abs(x-arr[left]))
                    right--;
                else left++;
            }
        }

        //区间元素是[right+1,left-1]
        for(int i = right+1;i<= left-1;i++)
            res.add(arr[i]);
        return res;
    }
}
