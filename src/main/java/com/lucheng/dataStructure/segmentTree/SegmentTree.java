package com.lucheng.dataStructure.segmentTree;

/**
 * 使用递归构建线段树
 */
public class SegmentTree {
    private static int[] array = new int[]{1,5,6,9,8,7,8,6,3};
    private static int[] segmentTree = new int[array.length*4];
    
    private static int[] mark = new int[array.length*4];

    public static void main(String[] args) {
        build(0, array.length-1, 1);
        for (int i : segmentTree) {
            System.out.print(i + " ");
        }

        update(2,5,2,1,0,8);
        System.out.println("更新后的线段树内容:");
        for (int i : segmentTree) {
            System.out.print(i+" ");
        }
    }

    /**
     * 构建线段树，值写入静态变量segmentTree中
     * @param l 节点的左边界
     * @param r 节点的有边界
     * @param p 节点在线段树中的序号(从1开始)
     */
    private static void build(int l,int r,int p ){
        if(l == r){
            //到达子节点
            segmentTree[p] = array[l];
        }else{
            //构建子节点
            int mid = (l+r)/2;
            //左子节点的区间是[l,mid]
            build(l,mid,p*2);
            //右子节点的区间是[mid+1,r]
            build(mid+1,r,p*2+1);
            //segmentTree[p] 的值是左右节点的值的和
            segmentTree[p] = segmentTree[p*2]+segmentTree[p*2+1];
        }
    }

    /**
     * 在目标区间[l,r]中的每个数加上d之后更新线段树内容
     * @param l
     * @param r
     * @param d 增加值
     * @param p 线段树序号
     * @param cl 当前左区间
     * @param cr 当前右区间
     */
    private static void update(int l, int r, int d, int p , int cl , int cr )
    {
        if (cl > r || cr < l) // 区间无交集
            return; // 剪枝
        else if (cl >= l && cr <= r) // 当前节点对应的区间包含在目标区间中
        {
            segmentTree[p] += (cr - cl + 1) * d; // 更新当前区间的值
            if (cr > cl) // 如果不是叶子节点
                mark[p] += d; // 给当前区间打上标记
        }
        else // 与目标区间有交集，但不包含于其中
        {
            int mid = (cl + cr) / 2;
            mark[p * 2] += mark[p]; // 标记向下传递
            mark[p * 2 + 1] += mark[p];
            segmentTree[p * 2] += mark[p] * (mid - cl + 1); // 往下更新一层
            segmentTree[p * 2 + 1] += mark[p] * (cr - mid);
            mark[p] = 0; // 清除标记
            update(l, r, d, p * 2, cl, mid); // 递归地往下寻找
            update(l, r, d, p * 2 + 1, mid + 1, cr);
            segmentTree[p] = segmentTree[p * 2] + segmentTree[p * 2 + 1]; // 根据子节点更新当前节点的值
        }
    }
}
