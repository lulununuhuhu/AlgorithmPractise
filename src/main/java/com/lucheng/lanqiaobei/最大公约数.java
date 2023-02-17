package com.lucheng.lanqiaobei;

/**
 * 题目链接：https://www.dotcpp.com/oj/problem2709.html
 */

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 求最少操作次数就是求得获取某两个相邻数得最大公约数为1的最少操作次数
 */
public class 最大公约数 {
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 100010;
    static Node[] tr = new Node[N * 4];//构建线段树的长度一般为对应数组长度的4倍
    static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 0;//记录数组中出现1的个数
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            if(a[i] == 1)   f++;
        }

        if(f != 0){
            //数组中有1
            out.println(n-f);//输出结果就是数组中不是1的个数
            out.flush();
            return;
        }

        //构建线段树
        build(1,n,1);

        //如果整个区间的最大gcd不是1，那就说明任何一个子数组的最大gcd也不为1
        if(query(1,n,1) != 1){
            out.println(-1);
            out.flush();
            return;
        }

        //找到长度最短的子数组满足gcd为1
        int ans = 0x7fffffff;//维护gcd为1的子数组的最短距离
        for (int i = 1; i <= n; i++) {
            int l = i+1,r = n+1;//查询区间[i+1,n+1)
            while (l < r){
                int mid = l + r >> 1;
                if(query(i,mid,1) == 1) r = mid;//r及r右侧区间的最大gcd都为1
                else l = mid+1;//l左侧区间的最大gcd都不为1
            }
            if(query(i,r,1) == 1) ans = Math.min(ans,r-i);
        }

        out.println(n-1+ans);//最小操作次数等于数组长度+gcd为1的最短子数组的长度-1
        out.flush();
    }

    /**
     * 求x和y的最大公约数
     * @param x
     * @param y
     * @return
     */
    private static int gcd(int x,int y){
        return y == 0 ? x:gcd(y,x%y);
    }

    /**
     * 构建线段树
     * @param l
     * @param r
     * @param p
     */
    static void build(int l,int r,int p){
        if(l == r){
            //到达子节点
            tr[p] = new Node(l,r,a[r]);
        }else{
            tr[p] = new Node(l,r,0);
            //构建子节点
            int mid = (l+r)/2;
            //左子节点的区间是[l,mid]
            build(l,mid,p*2);
            //右子节点的区间是[mid+1,r]
            build(mid+1,r,p*2+1);
            pushup(p);
        }
    }

    /**
     * 线段树节点的值存放的是该节点所对应区间的最大公约数gcd
     * @param p
     */
    static void pushup(int p) {
        tr[p].g = gcd(tr[p*2].g,tr[p*2+1].g);
    }

    /**
     * 查询区间[l,r]的最大gcd
     * @param l
     * @param r
     * @param p
     * @return
     */
    static int query(int l,int r,int p){
        if(tr[p].l>=l && tr[p].r<=r) return tr[p].g;//tr[p]表示的区间是[l,r]的子区间
        int mid = tr[p].l+tr[p].r >> 1;
        if(r <= mid)    return query(l,r,p<<1);//[l,r]是p号节点的左儿子节点的子区间
        else if (l > mid) {
            return query(l,r,p << 1 | 1);//[l,r]是在p号节点的右儿子节点的子区间
        }else {
            //[l,r]在p节点的两个区间都有交集
            return gcd(query(l,r,p << 1),query(l,r,p << 1 | 1));
        }
    }

    /**
     * 线段树节点的数据结构
     * l:左区间
     * r:右区间
     * g:[l,r]中的gcd
     */
    static class Node{
        int l,r,g;
        public Node(int l, int r, int g) {
            this.l = l;
            this.r = r;
            this.g = g;
        }
    }
}
