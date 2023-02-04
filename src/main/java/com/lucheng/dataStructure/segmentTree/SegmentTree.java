package com.lucheng.dataStructure.segmentTree;

/**
 * 使用递归构建线段树
 */
public class SegmentTree {
    private static int[] array = new int[]{1,5,6,9,8,7,8,6,3};
    private static int[] segmentTree = new int[array.length*2];

    public static void main(String[] args) {
        build(0, array.length-1, 1);
        for (int i : segmentTree) {
            System.out.print(i + " ");
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
}
