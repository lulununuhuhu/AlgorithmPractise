package com.lucheng.大厂真题.DP.LinearDP;

import java.util.Scanner;

/**
 * 暴力枚举
 */
public class P1469 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int len = str.length();
        int ans = 0;
        //枚举子串长度：从2开始
        for (int i = 2; i <= len; i++) {
            for (int start = 0; start <len-i+1; start++) {
                for (int j = 0; j < i; j++) {
                    char front = str.charAt(start+j);
                    char back = str.charAt(start+j+1);
                }
            }
        }
    }
}
