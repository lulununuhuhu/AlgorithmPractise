package com.lucheng.DFS;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        List<String> res = leetcode22.generateParenthesis(2);
        res.forEach(System.out::println);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] combination = new char[2*n];
        combination[0] = '(';//括号组合的第一个字符只能是(
        generateAll(combination,1,res,n);
        return res;
    }

    private void generateAll(char[] combination, int pos, List<String> res, int n){
        if(pos == 2*n){
            if(isValid(combination) == true)
                res.add(new String(combination));
        }else{
            combination[pos] = '(';
            generateAll(combination,pos+1,res,n);
            combination[pos] = ')';
            generateAll(combination,pos+1,res,n);
        }
    }

    private boolean isValid(char[] combination){
        int balance = 0;
        for(char c: combination){
            if(c == '(')
                balance++;
            else
                balance--;
            if(balance < 0)
                return false;
        }
        return balance == 0;
    }
}
