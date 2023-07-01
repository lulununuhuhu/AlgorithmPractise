package com.lucheng.DP;

public class Leetcode63 {
    public static void main(String[] args) {
        Leetcode63 leetcode63 = new Leetcode63();
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        leetcode63.uniquePathsWithObstacles(obstacleGrid);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i < n && obstacleGrid[0][i] != 1;i++){
            dp[0][i] = 1;
        }
        for(int i = 0; i < m && obstacleGrid[i][0] != 1;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        //打印dp数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }
}
