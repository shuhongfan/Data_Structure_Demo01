package com.shf.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    @Test
    public void test1(){
        int arr[] = {53,3,542,748,14,214};

        System.out.println(Arrays.toString(arr));

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

//    基数排序方法
    public static void radixSort(int[] arr){
//        1.得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
//        得到最大的数是几位数
        int maxLength = (max+"").length();

        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
//        第一轮排序 针对每个元素的个位进行排序处理
//        定义一个二维数组，表示10个桶，每一个桶是一个一维数组
//        说明：
//        1.二维数组包含10个一维数组
//        2.为防止在放入数的时候，数据溢出，则每一个一维数组（桶），大小定为 arr.length
//        3.基数排序是使用空间换时间的经典算法
            int[][] bucket = new int[10][arr.length];

//        为了记录美国桶中，实际存放了多个少个数据，我们定义一个一维数组来记录各个桶的每次放入数据的个数
            int[] bucketElementCounts = new int[10];

            for (int j = 0; j < arr.length; j++) {
//            取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;
//            放到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }

//        按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
            int index= 0;
//        遍历每一个桶，并将桶中的数据，放到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
//            如果桶中，有数据，我们才放到原数组
                if (bucketElementCounts[k]!=0){
//                循环该桶即第k个桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }

//            System.out.println(Arrays.toString(arr));
        }

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

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }
}
