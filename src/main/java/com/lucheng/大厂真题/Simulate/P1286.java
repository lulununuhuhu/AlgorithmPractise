package com.lucheng.大厂真题.Simulate;

import java.math.BigDecimal;
import java.util.Scanner;

public class P1286 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            //获取输入，以空格作为分隔符分别作为a和b
            StringBuffer a = new StringBuffer(scanner.next());
            StringBuffer b = new StringBuffer(scanner.next());
            StringBuffer res = new StringBuffer(a);//记录最大结果
            int len = a.length();
            for (int j = 0; j <= len; j++) {
                a.insert(j,b);//插入指定位置
                BigDecimal decimal1 = new BigDecimal(a.toString());
                BigDecimal decimal2 = new BigDecimal(res.toString());
                if(decimal1.compareTo(decimal2) == 1){
                    res = new StringBuffer(a);
                }
                a.deleteCharAt(j);//还原
            }
            System.out.println(res.toString());
        }
    }
}
