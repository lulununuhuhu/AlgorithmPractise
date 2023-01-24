package com.lucheng.search;

import com.lucheng.search.BinarySearch;
import org.junit.Test;

public class testBinarySearch {

    @Test
    public void testBinarySearch1(){
        int[] nums = new int[]{1,2,5,8,10,12,25};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearchMethod1(nums, 9);
        System.out.println(index);
    }

    @Test
    public void testBinarySearch2(){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,15};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearchMethod2(nums,13);
        System.out.println(index);
    }

    @Test
    public void testBinarySearch3(){
        int[] nums = new int[]{-1,0,3,5,9,12};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearchMethod3(nums,-1);
        System.out.println(index);
    }
}
