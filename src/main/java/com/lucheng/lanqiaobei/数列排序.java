package com.lucheng.lanqiaobei;


import java.util.Scanner;

//数列从小到大排序  https://lx.lanqiao.cn/problem.page?gpid=T52
public class 数列排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            nums[i] = num;
        }

        //将nums数组进行冒泡排序
        for (int i = 0; i < nums.length - 1; i++) {
            boolean swapFlag = false;//交换标记
            for(int j = 1;j < nums.length-i;j++){
                if(nums[j-1] >= nums[j]){
                    //交换
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                    swapFlag = true;
                }
            }
            if(swapFlag == false) break;
        }

        for(int num: nums){
            System.out.println(num + " ");
        }
    }

}
