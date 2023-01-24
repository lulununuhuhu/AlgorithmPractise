package com.lucheng.search;

/**
 * 最长递增子序列
 */
public class Leetcode300 {
    /**
     * 方法：创建数组cell，用于保存最长上升子序列
     * 在nums数组中依次遍历，插入元素到cell中
     *  如果插入元素是当前cell数组中最大的，则放入最后
     *  如果插入元素不是最大的，则找到比它大的元素中最小的那个替换掉它
     *  完成遍历后cell的长度就是最长递增子序列的长度。
     *  其中确认插入位置是使用的是二分查找法
     * @param nums
     * @return
     */
    public int Method(int[] nums){
        if(nums.length<=1)  return nums.length;
        int[] cell = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int left = 0;int right = res;
            //搜索区间是[left,res)
            while(left<right){
                int middle = (left+right)/2;
                if(cell[middle]<num)
                    left = middle+1;
                else right = middle;
            }
            cell[left] = num;
            if(left == res) res++;
        }
        return res;
    }
}
