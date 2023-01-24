package com.lucheng.prefixSum;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        //法一：直接暴力法
//        List<Integer> res = new ArrayList<>();
//        int len = security.length;
//        loop1:for(int i = time;i < len-time;i++)//满足条件1
//        {
//            //[i-time,i]满足非递增
//            for(int j = i-time;j < i;j++){
//                if(security[j]< security[j+1])  continue loop1;
//            }
//            //执行完上述循环表示满足条件2
//
//            //[i,i+time]满足非递减
//            for(int j = i;j < i+time;j++){
//                if(security[j]> security[j+1])  continue loop1;
//            }
//
//            //执行完上述循环表示满足条件3
//            res.add(i);
//        }
//        return res;

//        法二：使用前缀和思想,对数组进行预处理,生成前缀和数组,方便探究数组中某个区间内的性质
        //预处理数组g,g[i]表示g[i]和g[i-1]的大小关系,1表示g[i]>g[i-1];-1表示g[i]<g[i-1];0表示g[i]==g[i-1]
        int[] g = new int[security.length];
        g[0] = 0;//边界条件g[0] = 0
        for (int i = 1; i < security.length; i++) {
            if(security[i]>security[i-1])
                g[i] = 1;
            else if (security[i] < security[i-1]) {
                g[i] = -1;
            }else{
                g[i] = 0;
            }
        }

        //对预处理数组g使用前缀和,a[i]表示[g[0],g[i-1]]的1的数量,b[i]表示[g[0],g[i-1]]的-1的数量
        int[] a = new int[g.length+1];
        int[] b = new int[g.length+1];
        a[0] = 0;b[0] = 0;
        for (int i = 1; i < g.length+1; i++) {
            a[i] = a[i-1]+(g[i-1] == 1 ? 1:0);
            b[i] = b[i-1]+(g[i-1] == -1 ? 1:0);
        }

        List<Integer> res = new ArrayList<>();
        //对[time,length-time)区间内的所有元素进行遍历,非递增和非递减的条件可以转化为索引值i的元素在(i-time,i]区间内1的个数是0,在(i,i+time]区间内-1的个数是0
        for (int i = time; i < g.length-time; i++) {
            int x = a[i+1]-a[i-time+1];
            int y = b[i+time+1]-b[i+1];
            if(x==0 && y==0)    res.add(i);
        }
        return res;
    }
}
