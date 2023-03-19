package com.lucheng.offer;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer56II {
    public static void main(String[] args) {
        Offer56II offer56II = new Offer56II();
        int[] nums = new int[]{3,5,3,3};
        int res = offer56II.singleNumber(nums);
        System.out.println("出现一次的数是:"+res);
    }
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
