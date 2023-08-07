package com.lucheng.大厂真题.科大讯飞;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P1411 {
    private static int n;
    private static int s;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Set<Integer> nums = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }
        s = scanner.nextInt();
        int res = s-1;//res的初始的和的组数[1,s-1]
        //遍历集合
        // 当前遍历元素是否小于s，如果不是则忽略
        //  2.1 遍历值的两倍等于s，则res-1
        //  2.2 遍历值和s-遍历值都在集合中 则res-1
        //  2.3 否则res-2
        for (Integer num : nums) {
            if(num >= s)    continue;
            if(num *2 == s) res--;
            else if (nums.contains(s-num)) res--;
            else res -= 2;
        }
        System.out.println(res);
    }
}
