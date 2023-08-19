package com.lucheng.大厂真题.Simulate;

import java.util.Scanner;

public class P1288 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int counts = 0;
        //进行调度
        if(n % 2 == 0){
            //车厢数量是偶数
            counts = n/2;
            int i = n/2-1;int j = n/2;
            while (i>=0&&j<n&&nums[i] < nums[j] && nums[i]+nums[j] == n+1){
                i--;j++;
                counts--;
            }
        }else{
            //车厢数量是奇数
            counts = n/2;
            if(nums[n/2] == n/2+1){
                int i = n/2-1;int j = n/2+1;
                while (i>=0&&j<n&&nums[i] < nums[j] && nums[i]+nums[j] == n+1){
                    i--;j++;
                    counts--;
                }
            }
        }
        System.out.println(counts);
    }
}
