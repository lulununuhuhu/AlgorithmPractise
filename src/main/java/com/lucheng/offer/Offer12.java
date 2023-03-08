package com.lucheng.offer;

import java.util.Arrays;

public class Offer12 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
        String word = "a";
        Offer12 instance = new Offer12();
        boolean exist = instance.exist(board, word);
        System.out.println("结果是:"+exist);
    }
    private boolean[][] flag;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(board,i,j,0,word) == true)   return true;
            }
        }
        return false;
    }

    /**
     * DFS搜索
     * @param board 待遍历的字符网格
     * @param i 当前遍历的行号i
     * @param j 当前遍历的列号j
     * @param k 当前已匹配的字符个数
     * @param word 待匹配的单词
     * @return
     */
    private boolean dfs(char[][] board,int i,int j,int k,String word){
        //当前行号或者列号已经越界的话，直接返回false
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;

        //当前遍历位置的字符与待匹配的字符不相等
        if(board[i][j] != word.charAt(k))  return false;
        //当前遍历位置已被访问过
        if(flag[i][j] == true)  return false;
        //当前匹配的字符个数已经等于单词个数
        if(++k == word.length())  return true;
        flag[i][j] = true;
        //从上下左右四个方向进行深度遍历
        boolean res = dfs(board, i + 1, j, k, word) || dfs(board, i - 1, j, k, word) || dfs(board, i, j + 1, k, word) || dfs(board, i, j - 1, k, word);
        flag[i][j] = false;
        return res;
    }
}
