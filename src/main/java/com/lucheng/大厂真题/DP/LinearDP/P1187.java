package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1187
 */
public class P1187 {
    public static void main(String[] args) {
        //遍历第二行数的时候找到最小和倒数第二小的数，并记录总和sum；如果有小于0的数，sum就加上该数的绝对值即为最终答案
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int min = Integer.MAX_VALUE;int last_min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int energy = scanner.nextInt();
            //energy在(min,last_min)区间内,last_min更新为energy
            //energy在(-∞,min)区间内，last_min更新为min,min更新为energy
            if(energy < min){
                last_min = min;//倒数第二小的值变为min
                min = energy;//倒数第一小的值变为energy
            } else if (energy > min && energy < last_min) {
                last_min = energy;
            }
            sum += energy;
        }
        if(min < 0 )
            sum += Math.abs(min);
        if(last_min < 0)
            sum += Math.abs(last_min);
        System.out.println(sum);
    }
}
