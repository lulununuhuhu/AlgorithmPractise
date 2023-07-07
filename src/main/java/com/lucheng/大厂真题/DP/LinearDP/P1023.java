package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1023
 */
public class P1023 {
    private static final int capacity = 100001;
    private static int[] cnt = new int[capacity];//哈希数组，记录每个索引值出现的次数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            maxValue = Math.max(maxValue,arr[i]);
            cnt[arr[i]]++;
        }
        int res = simulation(n,maxValue);
        System.out.println(res);
    }

    /**
     * 方法一：模拟+贪心法（如果说题意是删除一个等于arri+1或者arri-1的数，那么这个方法可行。然而题意是删除所有，所以不能用贪心思想）
     * 基本思路：
     * 1. 找到数组中最大的数maxValue，作为当前删除数curDel
     * 2. 将cnt[curDel]减1 如果cnt[curDel-1]大于0，同样减一，n-2；如果等于0，n-1。将被删除的数加入结果中
     * 3. 在cnt数组中从后往前遍历，找到下一个cnt[x]不为0的数，将x作为curDel同样进行上述1、2步
     * 4. 当n为0时，返回结果
     *
     * @param n        数组长度(需要删除的个数)
     * @param startDel  待删除的第一个值
     * @return
     */
    private static int simulation(int n, int startDel) {
        int delCounts = n;
        int curDel = startDel;
        int res = 0;//存储答案
        while (delCounts > 0){
            cnt[curDel]--;
            res += curDel;
            delCounts--;
            if(cnt[curDel-1]>0){
                cnt[curDel-1]--;
                delCounts--;
            }
            //找到下一个curDel
            while (curDel >= 0 && cnt[curDel] == 0)
                curDel--;
        }
        return res;
    }
}
