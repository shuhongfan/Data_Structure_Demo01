package com.shf.search;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 二分查找算法
 */
public class BinarySearch {
    @Test
    public void test1(){
        int[] arr = {1,8,10,89,1000,1024};

        int resIndex = binarySearch(arr, 0, arr.length - 1, 12000);
        System.out.println("resIndex="+resIndex);
    }

    @Test
    public void test2(){
        int[] arr = {1,8,10,89,1000,1024};

        ArrayList<Integer> resultIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("resultIndexList="+resultIndexList);
    }

    /**
     * 二分法查找
     * @param arr  数组
     * @param left  左边的索引
     * @param right  右边的索引
     * @param findVal 要查找的值
     * @return  如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        int mid = (left + right) / 2;
        int midVal = arr[mid];

//        当left>right时，说明递归整个数组，但是没有找到
        if (left>right){
            return -1;
        }

        if (findVal>midVal){ // 向右递归
            return binarySearch(arr,mid+1,right,findVal);
        } else if (findVal<midVal){ // 向左递归
            return binarySearch(arr,left,mid-1, findVal);
        } else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        int mid = (left + right) / 2;
        int midVal = arr[mid];


//        当left>right时，说明递归整个数组，但是没有找到
        if (left>right){
            return new ArrayList<Integer>();
        }

        if (findVal>midVal){ // 向右递归
            return binarySearch2(arr,mid+1,right,findVal);
        } else if (findVal<midVal){ // 向左递归
            return binarySearch2(arr,left,mid-1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
//            向mid索引值的左边扫描，将所有满足1000的元素下标，加入到结合ArrayList
            int temp = mid - 1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
//                否则，就temp放入到resIndexList
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);

//            向mid 索引值的右边扫描，将所有满足1000的元素下标，加入到集合ArrayList
            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=findVal){
                    break;
                }
//                否则，就temp放入到resIndexList
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }
}
