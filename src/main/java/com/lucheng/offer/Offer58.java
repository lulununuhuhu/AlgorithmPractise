package com.lucheng.offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer58 {
    public String reverseWords(String s) {
        //使用trim将前后空格去掉
        String s1 = s.trim();
        //正则匹配连续的空白字符串作为分隔符
        String[] tmp = s1.split("\\s+");
        //将String转化成集合
        List<String> stringList = Arrays.asList(tmp);
        //将List集合逆转
        Collections.reverse(stringList);
        return String.join(" ",stringList);
    }
}
