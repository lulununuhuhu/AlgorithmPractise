package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1187
 */
public class P1187 {
    private static int n;
    private static int[] nums;
    public static void main(String[] args) {

        //被注释掉的解法是题意理解错误：题目中说明的是任意一个连续的区域，即可以自己选择将多少块地方统统清零
        //遍历第二行数的时候找到最小和倒数第二小的数，并记录总和sum；如果有小于0的数，sum就加上该数的绝对值即为最终答案
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int sum = 0;
//        int min = Integer.MAX_VALUE;int last_min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            int energy = scanner.nextInt();
//            //energy在(min,last_min)区间内,last_min更新为energy
//            //energy在(-∞,min)区间内，last_min更新为min,min更新为energy
//            if(energy < min){
//                last_min = min;//倒数第二小的值变为min
//                min = energy;//倒数第一小的值变为energy
//            } else if (energy > min && energy < last_min) {
//                last_min = energy;
//            }
//            sum += energy;
//        }
//        if(min < 0 )
//            sum += Math.abs(min);
//        if(last_min < 0)
//            sum += Math.abs(last_min);
//        System.out.println(sum);

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i <n; i++) {
            nums[i] = scanner.nextInt();
        }
        int times = 2;//两次生灵涂炭的机会
        int res = dynamicProgramming(nums,times);
    }

    private static int dynamicProgramming(int[] nums, int times) {
        //dp[i][j]:表示nums[0...i]区间内用了j次生灵涂炭术后的最大能量之和
        //dp[i][0] = dp[i-1]+nums[i]
        //dp[i][1] = max(dp[i-1][1]+nums[j],dp[0...i-1][0]的最大值)
        //dp[i][2] = max(dp[i-1][2]+nums[j],dp[0...i-1][1]的最大值)
        //返回dp[n][0] dp[n][1] dp[n][2]的最大值
        return 0;
    }

    private static int dynamicProgramming2(int[] nums,int times){
        //这道题本质上就是将两块没有交集的区间的数变为0，而要变为0后正能量最多，则说明归为0的两块区间的和是最小的。
        // 这下子问题就变成了求最小子段和的问题
        return 0;//所以和P2642类似了
    }
}
