package com.lucheng.bishiti.meituan0401;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * 题目描述：
 *
 * 小美在数学课上学会了加减乘除，现在她想多进行一些算数训练来加强自己的计算能力。为了不重复出题，她想出一个好方法。她先写下了一排n个数(n≥2)，依次用加号连接。举例来说，小美可能写下了如下的式子1+4+7+4+2+3+1共7个数以及6个加号。接着小美以一种全新的方式进行出题：她每次选择一个加号，
 * 将它改变成加减乘除中的一个（虽然很奇怪，但小美认为加号也可以被改成加号，尽管不会产生任何影响），然后计算整个式子的结果。值得注意的是，小美认为每次操作不对后续操作产生影响，详见样例解释。
 *
 * 小美认真做了很多次算数训练，现在她想让作为她好朋友的你帮她用程序计算一次，方便她核对答案。
 * 输入描述
 * 第一行一个整数n，合义见题面。
 * 接下来一行n个整数a1,a2,..,an，依次表示小美初始写下的连加算式中的每一个数。
 * 接下来一个整数m，表示小美做了m次算数训练
 * 接下来2m个以空格分开数字或符号 t1,o1, t2,o2, ... tm,om，其中ti为数字，oi是'+','-','*','/'(即加减乘除符号，不含引号)中的一个符号，表示第 i 次操作选定了第ti个加号，将其改变为了oi。
 * 对于所有的的数据,2≤N≤50000，1≤M≤50000,1≤ai≤500,1≤ti<N,oi∈{+,-,*,/}
 * 输出描述
 * 输出一行m个整数，分别表示每次操作的答案，结果四舍五入到一位小数。
 * 样例输入
 * 5
 * 1 2 4 2 5
 * 3
 * 1 - 2 * 4 /
 * 样例输出
 * 10.0 16.0 7.4
 */
public class 算数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] operationNumber = new char[2*n-1];
        double originalValue = 0;
        for (int i = 0; i < 2 * n - 1; i+=2) {
            operationNumber[i] = (char) sc.nextInt();
            originalValue += operationNumber[i];
            if(i != 2*n-2)
                operationNumber[i+1] = '+';
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int number  = sc.nextInt();
            double value = originalValue;
            char operator = sc.next().charAt(0);
            int pos = 2*number-1;
            double operator1 = operationNumber[pos-1];
            double operator2 = operationNumber[pos+1];
            switch (operator){
                case '-':
                    value -= (operator1+operator2);
                    value += (operator1-operator2);
                    break;
                case '*':
                    value -= (operator1+operator2);
                    value += (operator1*operator2);
                    break;
                case '/':
                    value -= (operator1+operator2);
                    value += (operator1/operator2);
                    break;
                default:
                    break;
            }
            //使用BigDecimal类，对数据进行四舍五入
            BigDecimal bigDecimal = new BigDecimal(value);
            System.out.print(bigDecimal.setScale(1, RoundingMode.HALF_UP)+" ");
//            System.out.print(String.format("%.1f",value)+" ");
        }
    }
}
