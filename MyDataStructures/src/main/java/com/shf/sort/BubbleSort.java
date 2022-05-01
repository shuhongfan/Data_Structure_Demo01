package com.shf.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    @Test
    public void test1(){
        int arr[] = {3,9,-1,10,-2};
        int temp = 0;  // 临时变量
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }


    @Test
    public void test2(){
        int arr[] = {3,9,-1,10,-2};
        int temp = 0;  // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    flag=true; // 是否交换
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));

            if (flag==false){
//                在一趟排序中，一次交换都没有发生过
                break;
            } else {
//                重置flag，进行下次判断
                flag = false;
            }
        }
    }

//    将前面冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        int temp = 0;  // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    flag=true; // 是否交换
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if (flag==false){
//                在一趟排序中，一次交换都没有发生过
                break;
            } else {
//                重置flag，进行下次判断
                flag = false;
            }
        }
    }


    @Test
    public void test3(){
        int arr[] = {3,9,-1,10,-2};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
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

        bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }
}
