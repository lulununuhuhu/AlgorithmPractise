package com.lucheng.大厂真题.科大讯飞;

import java.util.Scanner;

public class P1409 {
    private static int N;
    private static int[] A;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        A = new int[N];
        int position = 0;//记录小偷所在的位置
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            if(A[i] == -1)  position = i;
        }
        int res = simulate(A,position);
        System.out.println(res);
    }

    /**
     * 使用遍历方法 分别求出[0,position)的最小值  和(position,A.size-1]的最小值
     * 返回这两个最小值之和
     * @param A
     * @param position
     * @return
     */
    private static int simulate(int[] A, int position) {
        int size = A.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < position; i++) {
            res = Math.min(res,A[i]);
        }
        int ans = res;
        res = Integer.MAX_VALUE;
        for (int i = position+1; i < size; i++) {
            res = Math.min(res,A[i]);
        }
        ans += res;
        return ans;
    }
}
