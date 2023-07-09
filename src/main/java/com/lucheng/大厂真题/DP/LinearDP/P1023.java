package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1023
 */
public class P1023 {
    private static int N;
    private static int[] nums;
    private static int[] cnts = new int[100001];//哈希数组，记录每个数的出现次数
    private static int max;//记录nums数组中的最大值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
            max = Math.max(max,nums[i]);
            cnts[nums[i]]++;
        }
        int res = simulationAndHash(nums,cnts,max,N);
        System.out.println(res);
    }

    /**
     * 使用模拟＋哈希表的方法。
     * 基本思路：
     * 1. 每一轮获取当前最大数curMax，然后将该数对应的value减1，删除次数delCounts加1；将curMax-1对应的value变为0（因为是删除所有），删除次数delCounts加curMax-1对应的value(如果有的话，没有就不需要)
     * 2. 判断最大数curMax的对应的value是否是0.如果是0，则向下遍历找到最进的一个不为0的value，更新curMax，然后继续第1步；如果不是，继续第1步
     * 3. 重复1，2两步，直到delCounts等于n
     * @return
     */
    private static int simulationAndHash(int[] nums, int[] cnts, int max, int n) {
        int delCounts = 0;//记录删除的个数
        int curMax = max;//记录每一轮的最大数
        int res = 0;
        while (delCounts < n){
            cnts[curMax]--;delCounts++;res += curMax;
            if(curMax-1>=0 && cnts[curMax-1] != 0){
                delCounts += cnts[curMax-1];
                cnts[curMax-1] = 0;

            }
            //第2步
            while (curMax>=0 && cnts[curMax] == 0){
                curMax--;
            }
        }
        return res;
    }
}
