package com.lucheng.search;

import com.lucheng.search.BinarySearch2;
import org.junit.Test;

public class testBinarySearch2 {
    @Test
    public void test(){
        int[] nums = new int[]{3, 4, 5, 8, 8, 9, 10};
        BinarySearch2 method = new BinarySearch2();
        method.getInsertIndexMethod1(nums,7);
    }

    @Test
    public void test1(){
        int[] nums=  new int[]{2,3,4,5,8,8,9,10};
        BinarySearch2 method1 = new BinarySearch2();
        int target = 1;
        int index = method1.getInsertIndexMethod4(nums, target);
        System.out.println("小于"+target+"的最后一个元素索引位置:"+index);
    }

    @Test
    public void test2(){
        int[] nums=  new int[]{2,3,4,5,8,8,9,10};
        BinarySearch2 method1 = new BinarySearch2();
        int target = 2;
        int index = method1.getInsertIndexMethod3(nums, target);
        System.out.println("小于等于"+target+"的最后一个元素索引位置:"+index);
    }

    @Test
    public void test3(){
        int[] nums=  new int[]{2,3,4,5,8,8,9,10};
        BinarySearch2 method1 = new BinarySearch2();
        int target = 10;
        int index = method1.getInsertIndexMethod2(nums, target);
        System.out.println("大于"+target+"第一个元素的索引位置:"+index);
    }
}
