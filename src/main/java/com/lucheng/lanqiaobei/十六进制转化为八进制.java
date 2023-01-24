package com.lucheng.lanqiaobei;



import java.util.Scanner;
import java.util.Stack;

// https://lx.lanqiao.cn/problem.page?gpid=T51
public class 十六进制转化为八进制 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder hexString = new StringBuilder();
        int decimalNumber = 0;
        for (int i = 1; i <= n; i++) {
            String s = scanner.next();
            hexString.append(s);
            decimalNumber += s.charAt(0) - 'A' >=0 ? (10+s.charAt(0)-'A')*Math.pow(16,n-i) : (s.charAt(0)-'0')*Math.pow(16,n-i);
        }
        //将十进制数decimalNumber转化为八进制
        Stack<Integer> octStack = new Stack<>();
        while (decimalNumber != 0){
            octStack.add(decimalNumber%8);
            decimalNumber /= 8;
        }
        while(!octStack.empty()){
            System.out.print(octStack.pop());
        }
    }
}
