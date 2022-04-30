package com.shf.recursion;

public class Queue8 {
//    定义一个max表示共有多少个皇后
    int max = 8;

//    定义数组array，保存皇后放置位置的结果，
    int[] array = new int[max];

    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);

    }

    /**
     * 放置第n个皇后
     * @param n
     */
    private void check(int n) {
        if(n == max) {  //n = 8 , 其实8个皇后就既然放好
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for(int i = 0; i < max; i++) {
            //先把当前这个皇后 n , 放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)) { // 不冲突
                //接着放n+1个皇后,即开始递归
                check(n+1); //
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置
        }
    }


    /**
     * //    检测冲突
     * @param n  表示在第n个皇后
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
//            array[i]==array[n]，表示判断 第n个皇后是否和前面的n-1个皇后在同一列
//            Math.abs(n-1)==Math.abs(array[n]-array[i]) 表示判断第n个皇后是否和第i个皇后在同一斜线
//            判断是否在同一行，没有必要，n每次都在增加
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
                return false;
            }
        }
        return true;
    }

//    输出皇后的摆放位置
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("一共有"+count+"种解法");
    }
}
