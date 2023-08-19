package com.lucheng.大厂真题.Greedy;

import java.util.Scanner;

/**
 * 枚举操作1的次数，然后再操作1的结果的基础上加上操作2的次数。取两种操作次数之和的最小值
 */
public class P1446 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String newStr = str.substring(i)+str.substring(0,i);
            res = Math.min(res,operator2(newStr)+i);
        }
        System.out.println(res);
    }

    /**
     * 计算newStr需要变成回文串所需要操作2的次数
     * @param newStr
     * @return
     */
    private static int operator2(String newStr) {
        int i = 0,j = newStr.length()-1;
        int cnt = 0;
        while(i < j){
            if(newStr.charAt(i) != newStr.charAt(j))
                cnt++;
            i++;j--;
        }
        return cnt;
    }
}
