package com.shf.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int min=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }

            if (minIndex!=i){ // 最小值发生变化，交换
                arr[minIndex]=arr[i];
                arr[i]=min;
            }

//            System.out.println("第"+(i+1)+"轮");
//            System.out.println(Arrays.toString(arr));
        }

    }

    @Test
    public void test(){
        int[] arr = {101, 34, 119, 1};

        selectSort(arr);
    }

    @Test
    public void test4(){
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]= (int) (Math.random()*8000000);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }
}
