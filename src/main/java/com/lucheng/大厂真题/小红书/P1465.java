package com.lucheng.大厂真题.小红书;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * b d q p是一样的，统一都替换成b
 * u和n统一都替换成n
 * m和nn是一样的，m统一替换成nn
 * w和vv是一样的，w统一替换成vv
 *
 */
public class P1465 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String str = scanner.next();
            StringBuilder stringBuilder = new StringBuilder();
            int len = str.length();
            for (int j = 0; j < len; j++) {
                if(str.charAt(j) == 'b' || str.charAt(j) == 'd'||str.charAt(j) == 'p'||str.charAt(j) == 'q'){
                    stringBuilder.append('b');
                } else if (str.charAt(j) == 'u' || str.charAt(j) == 'n') {
                    stringBuilder.append('n');
                } else if (str.charAt(j) == 'm') {
                    stringBuilder.append("nn");
                } else if (str.charAt(j) == 'w') {
                    stringBuilder.append("vv");
                } else stringBuilder.append(str.charAt(j));
            }
            if(isHuiWen(stringBuilder) == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    /**
     * 判断是否是回文串
     * @param stringBuilder
     * @return
     */
    private static boolean isHuiWen(StringBuilder stringBuilder){
        String s = stringBuilder.toString();
        int len = s.length();
        int i = 0;int j = len-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
    private static boolean isTrue(int j, int k, char left, char right, String str) {
        if(left == 'w'){
            if(right != 'v' || str.charAt(k-1) != 'v')
                return false;
            else{
                return true;
            }
        }
        if(right == 'w'){
            if(left != 'v' || str.charAt(j+1) != 'v')
                return false;
            else{
                return true;
            }
        }
        if(left == 'm'){
            if(right != 'n' || str.charAt(k-1) != 'n')
                return false;
            else{
                return true;
            }
        }
        if(right == 'm'){
            if(left != 'n' || str.charAt(j+1) != 'n')
                return false;
            else{
                return true;
            }
        }
        return false;
    }

    private static Set<Character> process(char c) {
        if('b' == c )
            return new HashSet<>(Arrays.asList('b','d','q'));
        if('d' == c)
            return new HashSet<>(Arrays.asList('b','p','d'));
        if('p' == c)
            return new HashSet<>(Arrays.asList('p','d','q'));
        if('q' == c)
            return new HashSet<>(Arrays.asList('b','q','p'));
        if('n' == c || 'u' == c)
            return new HashSet<>(Arrays.asList('n','u'));
        return new HashSet<>();
    }
}
