package com.lucheng.大厂真题.Simulate;

import java.util.Scanner;

/**
 * A --> B
 * 第一步：A移动到B的同一行 即相同的x坐标 有三种方式  内部移动：abs(xA,xB)   从上界循环：xA+n-xB  从下界循环：n-xA+xB   取这三种方式的最小值
 * 第二部：A移动到B的同一列 方式相同
 */
public class P1452 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();int m = scanner.nextInt();
        int xA,yA,xB,yB,xC,yC;
        xA = scanner.nextInt();yA = scanner.nextInt();
        xB = scanner.nextInt();yB = scanner.nextInt();
        xC = scanner.nextInt();yC = scanner.nextInt();
        int res = 0;int stepsAToB = 0;int stepsBToC = 0;
        stepsAToB = Math.min(Math.abs(xA-xB),Math.min(n-xA+xB,xA+n-xB))+Math.min(Math.abs(yA-yB),Math.min(m-yA+yB,yA+m-yB));
        stepsBToC = Math.min(Math.abs(xB-xC),Math.min(n-xB+xC,xB+n-xC))+Math.min(Math.abs(yB-yC),Math.min(m-yB+yC,yB+m-yC));
        res = stepsAToB+stepsBToC;
        System.out.println(res);
    }
}
