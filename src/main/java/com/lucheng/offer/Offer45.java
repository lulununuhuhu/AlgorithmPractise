package com.lucheng.offer;

/**
 * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jk8pssc
 */
public class Offer45 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        Offer45 offer45 = new Offer45();
        String res = offer45.minNumber(nums);
        System.out.println("结果是："+res);
    }
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];

        //将int[]转化为String[]
        for(int i = 0;i < nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }

        //对str使用自定义的排序方法进行排序
        quickSort(str,0,str.length-1);
        StringBuilder res = new StringBuilder();
        for(String s:str)
            res.append(s);
        return res.toString();
    }

    /**
     * 快速排序，按照自定义的排序规则
     * @param str
     * @param l
     * @param r
     */
    private void quickSort(String[] str,int l,int r){
        if(l >= r)  return;
        int i = l;int j = r;
        String pivot = str[l];
        while (i < j){
            while (i < r && (pivot+str[i]).compareTo(str[i]+pivot) >= 0)  i++;
            while (j > l && (pivot+str[j]).compareTo(str[j]+pivot) <= 0)    j--;
            if(i < j){
                String tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
            }
        }

        String tmp = str[j];
        str[j] = pivot;
        str[l] = tmp;
        quickSort(str,l,j-1);
        quickSort(str,j+1,r);
    }
}
