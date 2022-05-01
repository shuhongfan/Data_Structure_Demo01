package com.shf.search;

import org.junit.Test;

public class SeqSearch {
    @Test
    public void test1() {
        int arr[] = {1,9,11,-1,34,89};

        int index = seqSearch(arr, 11);
        if (index==-1){
            System.out.println("没有找到");
        } else {
            System.out.println(index);
        }
    }

    /**
     * 这里我们实现的是线性查找是找到一个满足条件的返回值
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr,int value){
//        线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
