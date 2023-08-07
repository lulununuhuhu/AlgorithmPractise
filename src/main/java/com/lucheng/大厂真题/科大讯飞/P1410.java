package com.lucheng.大厂真题.科大讯飞;

import java.util.Scanner;

import static java.lang.Math.*;

public class P1410 {
    private static int n;
    private static int[] a;
    private static int[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += min(abs(a[i]-b[i]),abs(-1*a[i]-b[i]));
        }
        System.out.println(res);
    }
}
