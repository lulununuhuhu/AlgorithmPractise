package com.lucheng.search;


public class Leetcode786 {
    double eps = 1e-8;
    int[] arr;
    int n,a,b;

    public int[] kthSmallestPrimeFraction(int[] _arr,int k){
        arr = _arr;
        n = arr.length;
        double left = 0.0,right = 1.0;//搜索区间(0,1)
        System.out.println(right-left+ "   "+ eps);
        while(right-left > eps){
            double middle = (left+right)/2;
            if(getSort(middle) < k) left = middle;
            else  right = middle;
        }
        return new int[]{a,b};
    }

    //利用双指针在递增的素分数中得出x是第几(ans)小的数
    int check(double x){
        int ans = 0;
        for (int i = 0, j = 1; j < n; j++) {
            while (arr[i + 1] * 1.0 / arr[j] <= x) i++;
            if (arr[i] * 1.0 / arr[j] <= x) ans += i + 1;//记录分母为arr[j]时,小于等于x的总数
            if (Math.abs(arr[i] * 1.0 / arr[j] - x) < eps) {
                //当满足该条件时，返回的ans值就是arr[i]/arr[j]的排序值
                a = arr[i]; b = arr[j];
            }
        }
        return ans;
    }

    //使用双指针记录x在素分数中的排序
    private int getSort(double x){
        int ans = 0;
        int i = -1;//i指向分子索引值，j指向分母索引值
        for(int j = 1; j< n;j++){
            while(arr[i+1]*1.0/arr[j] <= x)   i++;
            ans += i+1;
            if(i>=0 && Math.abs(arr[i]*1.0/arr[j]-x) < eps){
                a = arr[i];b = arr[j];
            }
        }
        return ans;
    }
}
