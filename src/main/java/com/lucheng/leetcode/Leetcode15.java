package com.lucheng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        res.forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3)
            return res;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2;i++){
            while(i>0 && nums[i] == nums[i-1]) i++;
            int a = nums[i];
            if(a > 0) break;
            int j = i+1;int k = len-1;
            while(j < k){
                if(nums[j]+nums[k] > a*-1){
                    k--;
                }else if(nums[j]+nums[k] < a*-1){
                    j++;
                }else{
                    int b = nums[j];int c = nums[k];
                    res.add(Arrays.asList(a,b,c));
                    while(j< k &&nums[++j] == b);
                    while(k >j &&nums[--k] == c);//防止三元组重合
                }
            }
        }
        return res;
    }
}
