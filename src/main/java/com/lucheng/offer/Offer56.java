package com.lucheng.offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        //方法一：用哈希表
        Map<Integer,Integer> map = new HashMap<>();
        //记录数组中每个数的出现次数
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)
                list.add(entry.getKey());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
