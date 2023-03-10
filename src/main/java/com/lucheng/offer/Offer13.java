package com.lucheng.offer;

/**
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solutions/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc&topicTags=depth-first-search
 */
public class Offer13 {
    private boolean visited[][];//记录visited[i][j]是否已访问过
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        //从矩阵[0,0]开始深度优先搜素，只需向下或向右遍历即可遍历到所有点
        return dfs(m,n,0,0,k);
    }

    private int dfs(int m,int n,int i,int j,int k){
        if(i>=m || j>=n || visited[i][j] == true || compareToK(i,j,k)==false)    return 0;
        visited[i][j] = true;
        //递归遍历返回向下遍历和向右遍历的所有符合条件的位置数
        return 1+dfs(m,n,i+1,j,k)+dfs(m,n,i,j+1,k);
    }

    //判断行坐标x和列坐标y的数字之和与k的比较结果
    private boolean compareToK(int x,int y,int k){
        int res = 0;
        while( x != 0 || y != 0){
            res += (x%10)+(y%10);
            x /= 10;
            y /= 10;
        }
        return res <= k;
    }
}
