package com.shf.dynamic;



public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w ={1,4,3}; // 物品的重量
        int[] val = {1500,3000,2000}; // 物品的价值
        int m=4;  // 背包的容量
        int n=val.length; // 物品的个数

//        创建二维数组
//        v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v=new int[n+1][m+1];
//        为了记录放入商品的情况，我们定义一个二维数组
        int[][] path = new int[n+1][m+1];

//        初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0]=0; // 将第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i]=0; // 将第一行设置为0
        }


//        根据前面得到公式来动态规划处理
        for (int i = 1; i < v.length; i++) { // 不处理第一行，i是从1开始的
            for (int j = 1; j < v[0].length; j++) { // 不处理第一列，j是从1开始的
//                公式
                if (w[i-1]>j){
                    v[i][j]=v[i-1][j];
                } else {
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                        path[i][j]=1;
                    } else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }

//        输出v
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
