package com.lucheng.大厂真题.BinarySearch;

import java.util.Scanner;

public class P1236 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int res = calculate(n,a,b);
            System.out.println(res);
        }
    }

    /**
     * 计算有n个朋友的情况下，a个糖果1和b个糖果2能是的在每个小朋友获取一种糖果的前提下使得获取糖果的最小值最大
     *
     * 二分思想：最小值左边界1  最大值右边界 (a+b)/n的下界
     * @param n
     * @param a
     * @param b
     * @return
     */
    private static int calculate(int n, int a, int b) {
        int left = 1;int right = (a+b)/n;
        while(left <= right){
            int mid = (left+right)/2;
            if(!isCheck(n,a,b,mid)){
                right = mid-1;//right右边都为false
            }else {
                left = mid+1;//left左边都为true
            }
        }
        return right;
    }

    private static boolean isCheck(int n, int a, int b, int mid) {
        return n <= a/mid+b/mid;
    }
}
