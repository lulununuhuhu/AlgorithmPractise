package com.lucheng.search;

public class Leetcode1011 {
    public int shipWithinDays(int[] weights, int days) {
        //下界：weights数组的最大值 上界：weights数组的和
        int low = 1;int high = 0;
        for(int weight:weights){
            low = Math.max(low,weight);
            high += weight;
        }

        //在[low,high]中，找出小于等于days的最小shipCapacity
        while(low <= high){
            int middle = high + ((low-high)>>1);
            if(minCarryDays(weights,middle) > days)
                low= middle+1;//low左侧都是大于days
            else
                high = middle-1;//high右侧都是小于等于days
        }
        return low;
    }

    //返回船的指定载重量需要的最小运输天数
    private int minCarryDays(int[] weights,int shipCapacity){
        int weight = 0;
        int days = 0;
        for(int i = 0; i < weights.length;i++){
            weight += weights[i];
            if(weight > shipCapacity){
                days++;
                weight = weights[i];
            }
        }
        return days+1;
    }
}
