package com.lucheng.leetcode;

public class Leetcode415 {
    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "544554777";
        String res = addStrings(num1, num2);
        System.out.println(num1+"+"+num2+"="+res);

    }

    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.max(len1, len2);
        StringBuilder str1 = new StringBuilder(num1);
        StringBuilder str2 = new StringBuilder(num2);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len2-len1 && len2-len1>0; i++) {
            str1.insert(0,'0');
        }
        for (int i = 0; i < len1-len2 && len1-len2>0; i++) {
            str2.insert(0,'0');
        }
        int jinwei = 0;
        for (int i = len-1; i >= 0; i--) {
            int param1 = str1.charAt(i) - '0';
            int param2 = str2.charAt(i) - '0';
            res.insert(0,(char) ((param1+param2+jinwei)%10+'0'));
            jinwei = (param1+param2+jinwei)/10;
        }
        if(jinwei == 1)
            res.insert(0,'1');
        return res.toString();
    }
}
