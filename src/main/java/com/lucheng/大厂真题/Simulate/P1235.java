package com.lucheng.大厂真题.Simulate;

import java.util.Scanner;

public class P1235 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int res = 0;
            String S = scanner.next();
            String T = scanner.next();
            int lenT = T.length();
            int lenS = S.length();
            for (int j = 0; j < lenT && j < lenS; j++) {
                if(T.charAt(j) != S.charAt(j))
                    res++;
            }
            res += lenS-lenT > 0?lenS-lenT:0;
            System.out.println(res);
        }
    }
}
