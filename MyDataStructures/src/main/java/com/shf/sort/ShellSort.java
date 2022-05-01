package com.shf.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序，缩小增量排序
 */
public class ShellSort {
    @Test
    public void test1() {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println(Arrays.toString(arr));

        shellSort2(arr);
//        shellSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 移位法希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
//        增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            从第gap个元素，逐个对其所在的数组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;  // 待插入下标
                int insertValue = arr[insertIndex]; //保存待插入的值
                if (arr[insertIndex] < arr[insertIndex - gap]) {
                    while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
//                        移动
                        arr[insertIndex]=arr[insertIndex-gap];
                        insertIndex-=gap;
                    }
//                    当退出while后，就给temp找到插入的位置
                    arr[insertIndex]=insertValue;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 交换法希尔排序
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void test4() {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }
}
