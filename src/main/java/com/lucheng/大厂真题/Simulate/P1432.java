package com.lucheng.大厂真题.Simulate;

import java.util.Scanner;

public class P1432 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int res = 0;
        for (int i = 0; i < t; i++) {
            int score = 0;
            int n = scanner.nextInt();
            String[] words = new String[n];
            String[] repeats = new String[n];
            for (int j = 0; j < n; j++) {
                words[j] = scanner.next();
            }
            for (int j = 0; j < n; j++) {
                repeats[j] = scanner.next();
            }
            for (int j = 0; j < n; j++) {
                if(words[j] == null || !words[j].equals(repeats[j])){
                    score--;
                    if(score<0)
                        break;
                }else{
                    score++;
                }
            }
            if(score>=0) res++;
        }
        System.out.println(res);
    }
}
