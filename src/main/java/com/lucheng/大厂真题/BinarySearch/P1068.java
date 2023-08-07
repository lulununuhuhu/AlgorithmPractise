package com.lucheng.大厂真题.BinarySearch;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P1068
 *
 * 思路解析：本质是求一个函数的最小值问题
 *  该函数的公式是 Time = t+y/(V0+x*t)(x V0 y都是常数)
 *  本质就是利用二分搜索的思想解决峰谷问题。
 *  解决这种单峰函数的极值点位置一般使用三分法 前置知识如下：https://oi-wiki.org/basic/binary/#%E4%BA%8C%E5%88%86%E7%AD%94%E6%A1%88
 */
public class P1068 {
    private static double eps = Math.pow(10,-6);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v0 = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double res = thirdSearch(x,v0,y);
        System.out.println(res);
    }


    //TODO 有问题待解决
    private static double thirdSearch(int x, int v0, int y) {
        double left = 0.0;double right =  Math.pow(10,9);
        double mid = 0.0;
        while (right-left > eps){
            mid = (left+right)/2;
            double lmid = mid-eps;double rmid = mid+eps;
            double Flmid = lmid+y/(v0+x*lmid);//求F(lmid)的值
            double Frmid = rmid+y/(v0+x*rmid);//求F(rmid)的值
            if(Flmid <= Frmid)
                right = rmid;
            else
                left = lmid;
        }
        return left;
    }
}
