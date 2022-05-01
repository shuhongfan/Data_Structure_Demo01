package com.shf.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
//        定义待插入的数
            insertVal= arr[i];
            insertIndex = i-1;

//        给insetVal找到插入的位置
//        1.insertIndex>=0保证在给insetVal找插入位置，不越界
//        2.insertVal<arr[insertIndex] 待插入的数，还没有找到插入位置
//        3.需要将arr[insertIndex]后移
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
//        当退出while循环时，说明插入的位置找到，insertIndex+1
            if (insertIndex+1!=i){
                arr[insertIndex+1]=insertVal;
            }

//            System.out.println("第"+i+"轮");
//            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void test1(){
        int[] arr = {101,34,119,1};

        insertSort(arr);
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

        insertSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }
}
