package com.shf.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    @Test
    public void test1() {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        System.out.println("arr=" + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("arr=" + Arrays.toString(arr));
    }


    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;  // 左下标
        int r = right; // 右下标
        int pivot = arr[(left + right) / 2]; // pivot中轴值
        int temp = 0; // 交换时使用

//        while循环的目的是让比pivot值小放到左边
//        比pivot值大的放到右边
        while (l < r) {
//            在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
//            在pivot的右边一直找，找到小于等于pivot的值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
//            如果l>=r 说明pivot的左右两边的值，
//            已经按照左边全部是小于等于pivot值，
//            右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

//            交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

//            交换完成后，发现arr[l]==pivot值 相等 r--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }

//            如果交换完成后，发现arr[r]==pivot 相等l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

//        如果l==r，必须l++,r--，否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

//        向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
//        向右递归
        if (right > l) {
            quickSort(arr, l, right);
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

        quickSort(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }
}
