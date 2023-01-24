package com.lucheng.divideAndConque;

public class leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;int len2 = nums2.length;
        if((len1+len2)%2 != 0){
            return (double)findNoXValue(nums1,0,len1-1,nums2,0,len2-1,(len1+len2)/2);
        }else{
            return (double)((findNoXValue(nums1,0,len1-1,nums2,0,len2-1,(len1+len2)/2)+findNoXValue(nums1,0,len1-1,nums2,0,len2-1,(len1+len2)/2+1))/2);
        }
    }

    //找到nums1和nums2数组中的第k个值
    private int findNoXValue(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        //保证len1大于等于len2，这样保证先排除空的只有是nums2[]
        if(len1 < len2) return findNoXValue(nums2,start2,end2,nums1,start1,end1,k);
        //如果len2等于0,则直接返回nums1中从start1开始第k个元素
        if(len2 == 0)   return nums1[start1+k-1];
        //如果此时k=1，则返回nums1[]和nums2[]中第一个元素最小的值
        if(k == 1)  return Math.min(nums1[start1],nums2[start2]);

        //确定待比较元素的索引值
        int i = start1+Math.min(k/2,len1)-1;
        int j = start2+Math.min(k/2,len2)-1;
        //如果nums1[]中待比较元素大于等于nums2[]中待比较元素,则排除掉nums2[]中比较元素及比较元素之前的元素;否则就是排除掉nums1[]中比较元素及比较元素之前的元素
        if(nums1[i]>=nums2[j]){
            return findNoXValue(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }else{
            return findNoXValue(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }
    }
}
