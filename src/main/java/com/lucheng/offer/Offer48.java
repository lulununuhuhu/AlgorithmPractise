package com.lucheng.offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer48 {
    public static void main(String[] args) {
        Offer48 offer48 = new Offer48();
        int res = offer48.lengthOfLongestSubstring(" ");
        System.out.println("最长不包括重复字符的子字符串长度是:"+res);
    }

    public int lengthOfLongestSubstring(String s) {
        //dp[j]:以s[j]结尾的最长不重复子字符串的长度
        //初始状态：dp[j]=1
        //状态转移方程:设dp[j]的子字符串的左边界为j,则i是距离j最近的相同字符，即s[i]=s[j]
        //  1. i=-1,说明左边界没有与s[j]相同的字符，所以dp[j] = dp[j-1]+1
        //  2. dp[j-1] < j-i,说明s[i]在dp[j-1]表示的最长不重复子字符串的区间之外 dp[j] = dp[j-1]+1
        //  3. dp[j-1] >= j-i ,说明s[i]在dp[j-1]表示的最长不重复子字符串的区间之内 dp[j] = j-i;
        // 状态1和状态2可以合并,综上所述，状态转移方程是:   dp[j] = dp[j-1]+1    dp[j-1] < j-i
        //                                                = j-i          dp[j-1] >= j-i
        Map<Character,Integer> dic = new HashMap<>();//使用哈希表来维护当前遍历时间下某字符最后出现的索引位置,未出现就是-1
        int res = 0;//返回max(dp[j])
        int tmp = 0;//维护dp[j]
        for (int i = 0; i < s.length(); i++) {
            int index = dic.getOrDefault(s.charAt(i), -1);//获取s[i]最后一次出现的索引
            dic.put(s.charAt(i),i);//更新索引
            tmp = tmp < i-index ? tmp+1:i-index;//dp[j-1]->dp[j]
            res = Math.max(res,tmp);
        }
        return res;
    }
}
