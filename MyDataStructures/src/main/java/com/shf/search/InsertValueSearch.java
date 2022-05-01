package com.shf.search;

import org.junit.Test;

import java.util.Arrays;

public class InsertValueSearch {
    @Test
    public void test1(){
        int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i]=i+1;
        }

        int res = insertValueSearch(arr, 0, arr.length - 1, 78);
        System.out.println(res);
    }

    /**
     * 差值查找算法
     * @param arr  数组
     * @param left  左边索引
     * @param right  右边索引
     * @param findVal  查找值
     * @return 如果找到就返回对应的下标，如果没有找到，就返回-1
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        if (left>right || findVal<arr[0] || findVal>arr[arr.length-1]){
            return -1;
        }

//        求出mid
        int mid = left + (right-left)*(findVal-arr[left]) /(arr[right]-arr[left]);
        int midVal = arr[mid];

        if (findVal>midVal){  // 说明应该向右边递归
            return insertValueSearch(arr,mid+1,right,findVal);
        }  else if (findVal<midVal){ // 说明应该向左递归查找
            return insertValueSearch(arr,left,mid-1,findVal);
        } else {
            return mid;
        }
    }
}
