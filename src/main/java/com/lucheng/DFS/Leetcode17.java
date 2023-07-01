package com.lucheng.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class Leetcode17 {
    private List<String> res = new ArrayList<>();
    private String[] map = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();
        List<String> strings = leetcode17.letterCombinations("23");
        System.out.println(strings);

    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return res;
        dfs(digits,"",0);
        return res;
    }
    private void dfs(String digits,String combination,int index){
        if(combination!= null && combination.length() == digits.length()){
            res.add(combination);
            return;
        }
        int mapIndex = digits.charAt(index)-'2';//获取当前层对应的按键位置
        for(int i = 0;i < map[mapIndex].length();i++){
            String temp = combination+map[mapIndex].charAt(i);
            dfs(digits,temp,index+1);
            temp = combination;//回溯
        }
    }
}
