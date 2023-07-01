package com.lucheng.刷题班;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code01_绳子压点 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,3,4,6,8};
        List<Integer> lines = Arrays.asList(nums);
        int res = calculateMaxPoints(lines, 3);
        System.out.println("能压住最多的点是:"+res);
    }


    /**
     * 基本思想：滑动窗口
     * @param lines  X轴上的点
     * @param length 绳子长度
     * @return
     */
    public static int calculateMaxPoints(List<Integer> lines,int length){
        int res = 1;
        int size = lines.size();
        int pre = 0;
        int start = lines.get(0);
        int end = start;
        for (int i = 1; i < size; i++) {
            if(lines.get(i)-start <= length){
                end++;
                pre++;
            }else{
                start++;
                res = Math.max(res,pre);
            }
        }
        return res;
    }
}
