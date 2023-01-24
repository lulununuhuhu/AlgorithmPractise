package com.lucheng.search;

import java.util.Arrays;

/**
 * 求一个数组的最长递增子序列长度
 */
public class LIS {
        public int increasingTriplet(int[] nums) {
            int n = nums.length, ans = 1;
            int[] f = new int[n + 1];//维护一个从索引1开始单调递增的数组
            Arrays.fill(f, 0x3f3f3f3f);
            for (int i = 0; i < n; i++) {
                int t = nums[i];
                int l = 1, r = i + 1;
                while (l < r) {
                    //通过二分查找，找到大于等于t(=nums[i])的第一个索引值
                    int mid = l + ((r-l)>>1);
                    if(f[mid] < t)   l = mid+1;
                    else r = mid;
                }
                f[l] = t;
                ans = Math.max(ans, l);
            }
            return ans;
        }
}
