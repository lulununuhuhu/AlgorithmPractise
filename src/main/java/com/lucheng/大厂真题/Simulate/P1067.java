package com.lucheng.大厂真题.Simulate;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1067
 */
public class P1067 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();int q = scanner.nextInt();
        String s = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(s);
        char[] chars = s.toCharArray();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();int r = scanner.nextInt();
            for (int j = l; j <= r; j++) {
                //每遍历1次，增加1个字母，长度加1
                stringBuilder.insert(l+(j-l)*2,chars[j-1]);
            }
            chars = stringBuilder.toString().toCharArray();
        }
        System.out.println(stringBuilder.toString());
    }
}
