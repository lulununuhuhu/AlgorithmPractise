package com.lucheng.大厂真题.Simulate;

import java.util.Scanner;

/**
 * 使用枚举+trick
 *
 * 4 4
 * XX.X
 * XX.X
 * .X.X
 * ..X.
 *
 *
 */
public class P1448 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();int m = scanner.nextInt();
        char[][] martrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            martrix[i] = scanner.next().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x1 = 0,y1 = 0;
                //找到第一个X
                if(martrix[i][j] == 'X'){
                    x1 = i;y1 = j;
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            int x2 = 0,y2 = 0;
                            if(k == x1 && l == y1) continue;
                            if(martrix[k][l] == 'X'){
                                x2 = k;y2 = l;//找到第二个X
                                //根据两个X确定一条边，并将它顺时针旋转90度，每旋转一次得到下一个点的坐标
                                int dx = x2-x1,dy = y2-y1;
                                int x3 = x2-dy,y3 = y2+dx;
                                int x4 = x3-dx,y4 = y3-dy;
//                            int x3 = x1-dy,y3 = y1+dx;
//                            int x4 = x3+dx,y4 = y3+dy;

                                if(x3>=0&&x3<n&&y3>=0&&y3<m&&martrix[x3][y3] == 'X'
                                        && x4>=0&&x4<n&&y4>=0&&y4<m&&martrix[x4][y4] == 'X')
                                    cnt++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt/4);
    }
}
