package com.lucheng.search;

import java.util.Arrays;

public class Leetcode475 {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        // 计算出每个house离heaters的最近的距离(计算方法：将heaters排序后，使用二分查找找到第一个大于等于house的位置和最后一个小于house位置,取两个值与house距离最小的为最近的距离)
        Arrays.sort(heaters);
        for(int house: houses){
            //选出所有最近距离中的最大值，就是最小加热半径
            int index = Arrays.binarySearch(heaters, house);
            if(index > 0){
                //index大于0，说明heaters中有供暖器位置与house重合，所有最近距离肯定是0
            }else if(index == 0){
                //index等于0，有两种情况：找到key，key索引为0或者所有元素都大于key。这两种情况都说明heaters[0]位置与house最近
                res = Math.max(res,heaters[0]-house);
            }else{
                index = ~index;
                if(index == heaters.length)
                    res = Math.max(res,house-heaters[heaters.length-1]);
                else if (index == 0) {
                    res = Math.max(res,heaters[0]-house);
                } else{
                    int minDis = Math.min(Math.abs(heaters[index]-house),Math.abs(heaters[index-1]-house));
                    res = Math.max(res,minDis);
                }
            }
        }
        return res;
    }
}
