package com.lucheng.bishiti.meituan0401;

import java.util.Random;
import java.util.Scanner;

/**
 * 测试用例
 */
public class TestCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = sc.nextInt();
        for (int i = 1; i <=n-1; i++) {
            System.out.print((i+1)/2+" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int val = random.nextInt(2)+1;
            System.out.print(val+" ");
        }
    }
}
