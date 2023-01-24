package com.lucheng.search;

public class Leetcode1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        //如果花的数量(数组长度)不满足所需要制作花的所有要求，则返回-1
        if(bloomDay.length < m*k)
            return -1;
        //采用二分查找,找到满足制作m束花的最小的day
        int low = Integer.MAX_VALUE,high = 0;
        //找到上界high和下界low
        for(int day : bloomDay){
            low = Math.min(low,day);
            high = Math.max(high,day);
        }

        //大于等于true的第一个
        while(low <= high){
            int middle = high + ((low-high)>>1);
            if(canMake(bloomDay,middle,m,k) == false)
                low = middle+1;
            else
                high = middle-1;
        }
        return low;
    }

    //在指定天数days下，能否制作出m束花
    private boolean canMake(int[] bloomDay,int days,int m,int k){
        int res = 0;
        int flowers = 0;
        for(int i = 0; i< bloomDay.length; i++){
            if(bloomDay[i] <= days){
                flowers++;
                if(flowers == k){
                    //连续k朵可以在days前盛开
                    res++;
                    if(res == m) return true;
                    flowers = 0;
                }else{
                    flowers = 0;
                }
            }
        }
        return false;
    }
}
