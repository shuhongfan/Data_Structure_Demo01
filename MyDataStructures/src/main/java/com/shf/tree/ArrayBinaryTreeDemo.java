package com.shf.tree;

import org.junit.Test;

public class ArrayBinaryTreeDemo {
    @Test
    public void test1(){
        int[] arr ={1,2,3,4,5,6,7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
//        arrayBinaryTree.preOrder(0);
//        arrayBinaryTree.infixOrder(0);
        arrayBinaryTree.postOrder(0);
    }
}

class ArrayBinaryTree{
    private int[] arr; // 存储数据节点的数组

    public ArrayBinaryTree(int[] arr){
        this.arr=arr;
    }

    //    编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index){
//        如果数组为空，或者arr.length=0
        if (arr==null || arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
//        输出当前这个元素
        System.out.println(arr[index]);
//        向左递归遍历
        if ((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
//        向右递归遍历
        if ((index*2+2)<arr.length){
            preOrder(2*index+2);
        }
    }

    public void infixOrder(int index){
//        如果数组为空，或者arr.length=0
        if (arr==null || arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
//        向左递归遍历
        if ((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
//        输出当前这个元素
        System.out.println(arr[index]);
//        向右递归遍历
        if ((index*2+2)<arr.length){
            preOrder(2*index+2);
        }
    }

    public void postOrder(int index){
//        如果数组为空，或者arr.length=0
        if (arr==null || arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
//        向左递归遍历
        if ((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
//        向右递归遍历
        if ((index*2+2)<arr.length){
            preOrder(2*index+2);
        }
//        输出当前这个元素
        System.out.println(arr[index]);
    }
}