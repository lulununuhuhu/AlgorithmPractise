package com.lucheng.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode728题的第二种解法：预处理+二分
 */

//基本思路：由于题目要求的数据范围时1e4，可以将1~1e4所有的自除数都先列举出来，维护一个集合进行存储；然后通过二分找到[left,right]范围内的最大的自除数的在集合中的索引号
public class Leetcode728_Method2 {
    static List<Integer> list = new ArrayList<>();
    //静态代码块(获取[1,10000]范围内所有的自除数)
    static {
        out:for(int i = 1; i <= 10000; i++){
            int cur = i;
            while(cur != 0){
                int t = cur%10;
                if(t == 0 || i%t != 0 )   continue out;
                cur /= 10;
            }
            list.add(i);
        }
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        //使用二分查找找到[left,right]内最大的自除数
        int low = 0;int high = list.size()-1;
        while(low <= high){
            int middle = high + ((low-high)>>1);
            if(list.get(middle) <= right)   low = middle+1;
            else high = middle-1;
        }
        int idx = high;//获取到[left,right]内最大的自除数的索引号
        while(idx>=0 &&list.get(idx)>=left){
            res.add(list.get(idx--));
        }
        Collections.sort(res);
        return res;
    }
}
