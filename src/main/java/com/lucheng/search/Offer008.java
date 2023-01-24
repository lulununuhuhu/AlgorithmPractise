package com.lucheng.search;

import java.util.Arrays;

public class Offer008 {
    public int minSubArrayLen(int t, int[] nums) {
        int n = nums.length,ans = n+10;
        int[] sum = new int[n+10];
        //计算nums的前缀和，存放到sum数组中。sum[i]是nums[0~i-1]的和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+nums[i-1];
        }
        for (int i = 1; i <= n; i++) {
            int s = sum[i],d = s-t;
            int l =0,r= i;
            while( l < r){
                int mid = l+r+1 >> 1;
                if(sum[mid] <= d)   l = mid;
                else r = mid-1;
            }
            if(sum[r] <= d) ans = Math.min(ans,i-r);
        }
        return ans == n+10 ? 0:ans;
    }
}
