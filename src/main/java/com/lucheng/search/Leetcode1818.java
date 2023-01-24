package com.lucheng.search;

import java.util.Arrays;

public class Leetcode1818 {
    private int _nums1[];
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        //找出使得|nums1[i]-nums2[i]|最大的i，然后遍历nums1,找出与nums[i]绝对值最小的元素,然后计算出最小绝对值差和
        //法一；直接模拟法(有漏洞：|nums1[i]-nums2[i]|最大的时候可能会有多个i，需要与每个i对应的元素进行比较，然后取整体的最小值)
        // int n = nums1.length;
        // int maxDis = 0;
        // int maxIndex = 0;
        // int sumAbs = 0;
        // for(int i = 0;i < n;i++){
        //     int value = Math.abs(nums1[i]-nums2[i]);
        //     if( value >= maxDis){
        //         maxDis = value;
        //         maxIndex = i;
        //     }
        //     sumAbs += value;
        // }
        // int disDis = Integer.MAX_VALUE;
        // for(int num:nums1){
        //     int value = Math.abs(num-nums2[maxIndex]);
        //     disDis = value < disDis ? value:disDis;
        // }
        // sumAbs -= (maxDis-disDis);
        // return sumAbs;

        //法二：
        int n = nums1.length;
        _nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            _nums1[i] = nums1[i];
        }
        Arrays.sort(_nums1);
        long maxDis = 0;
        long res = 0;
        for(int i = 0;i < n;i++){
            int distance = Math.abs(nums1[i]-nums2[i]);
            res += distance;
            int index = Arrays.binarySearch(_nums1,nums2[i]);
            if(index >= 0) {
                //_nums1中有nums2[i]，最小距离为0,从而可减少差值为distance
                maxDis = Math.max(distance,maxDis);
            }else{
                //_nums1中没有nums[i],最小距离为二分查找返回值的两个结果中最小距离的那个
                index = ~index;
                int minDis = Integer.MAX_VALUE;
                if(index == n)
                    minDis = nums2[i]-_nums1[n-1];
                else if(index == 0)
                    minDis = _nums1[index]-nums2[i];
                else
                    minDis = Math.min(_nums1[index]-nums2[i],nums2[i]-_nums1[index-1]);
                maxDis = Math.max(distance-minDis,maxDis);
            }
        }
        return new Long((res-maxDis)%(1000000007)).intValue();
    }
}
