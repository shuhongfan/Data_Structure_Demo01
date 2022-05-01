package com.shf.test;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
//        int[] arr = {35,12,86,11,5};
        int[] arr = {101,34,119,1};

        System.out.println(Arrays.toString(arr));

//        BubbleSort(arr);
//        SelectSort(arr);
        InsertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡
     * @param arr
     */
    public static void BubbleSort(int[] arr){
        int temp;
        boolean flag=false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println("第"+(i+1)+"轮："+Arrays.toString(arr));

            if (flag==false){
                break;
            } else {
                flag=false;
            }
        }
    }

    /**
     * 选择
     * @param arr
     */
    public static void SelectSort(int[] arr){
        int minValue = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length -1; i++) {
            minIndex=i;
            minValue=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (minValue>arr[j]){
                    minValue=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){ // 最小值发生变化，交换
                arr[minIndex]=arr[i];
                arr[i]=minValue;
            }
            System.out.println("第"+(i+1)+"轮："+Arrays.toString(arr));

        }
    }

    /**
     * 插入
     * @param arr
     */
    public static void InsertSort(int[] arr) {
        int insertValue = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertValue=arr[i];
            insertIndex=i-1;
            while (insertIndex>=0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertValue;
        }
    }
}


