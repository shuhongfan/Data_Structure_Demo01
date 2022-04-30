package com.shf.recursion;

import org.junit.Test;

public class RecursionTest {
    @Test
    public void test1(){
        pr(4);
    }

//    打印问题
    public static void pr(int n){
        if (n>2){
            pr(n-1);
        }
        System.out.println("n="+n);
    }

    public static int factorial(int n){
        if (n==1){
            return 1;
        } else  {
            return factorial(n-1)*n;
        }
    }

    @Test
    public void test2(){
        int result = factorial(3);
        System.out.println(result);
    }
}
