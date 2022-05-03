package com.shf.dac;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(5,'A', 'B', 'C');
    }

//    汉诺塔移动的方法
//    使用分治方法解决
    public static void towerOfHanoi(int num,char a,char b,char c){
//        如果只有一个盘
        if (num==1){
            System.out.println("第 1 个盘从 "+a+" -> "+c);
        } else {
//            如果我们有 n》=2的情况，我们总是可以看做是两个盘 1.最下面一个盘 2.上面的所有盘
//            1. 先把最上面的所有盘A->B,移动过程中会使用到c
            towerOfHanoi(num-1,a,c,b);
//            2.把最下面的盘A->C
            System.out.println("第 "+num+" 个盘从 "+a+" -> "+c);
//            3.把B塔的所有盘 从B->C,移动的过程使用到a塔
            towerOfHanoi(num-1,b,a,c);
        }
    }
}
