package com.shf.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
//        输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看列头的数据");
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.println("取出的数据是："+result);
                    } catch (Exception e) {
//                        throw new RuntimeException(e);
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
//                    查看队列头的数据
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头的数据是："+res);
                    } catch (Exception e) {
//                        throw new RuntimeException(e);
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
//                    退出
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArray{
    private int maxSize;  //表示数组的最大容量
    // front指向队列的第一个元素,也就是说arr[front]就是队列的第一个元素，front初始值=0
    private int front = 0;
    // rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间做约定，rear的初始值=0
    private int rear = 0;
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize=arrMaxSize;
        arr = new int[maxSize];
    }

//    判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

//    判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

//    添加数据到队列
    public void addQueue(int n){
//        判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
//        直接将数据加入
        arr[rear]=n;
//        将rear后移，这里必须考虑取模
        rear=(rear+1)%maxSize;
    }



//    获取队列的数据，出队列
    public int getQueue(){
//        判断队列是否为空
        if (isEmpty()){
            try {
                throw new RuntimeException("队列空，不能取出数据");
            } catch (RuntimeException e) {
//                throw new RuntimeException(e);
                System.out.println(e.getMessage());
            }
        }

//        这里需要分析出front是指向队列的第一个元素
//        1.先把front对应的值保留到一个临时变量
//        2.将front后移，考虑取模
//        3.将临时保存的变量返回
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

//    显示队列所有的数据
    public void showQueue(){
//        判断队列是否为空
        if (isEmpty()){
            try {
//            通过抛出异常
                throw new RuntimeException("队列空，不能取数据");
            } catch (RuntimeException e) {
//                throw new RuntimeException(e);
                System.out.println(e.getMessage());
            }
        }
//        思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front+size(); i++) {
            System.out.println("arr["+i%maxSize+"]="+arr[i%maxSize]);
        }
    }

//    求出当前队列的有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

//    显示队列的头数据，注意不是取出数据
    public int headQueue(){
        if (isEmpty()){
            try {
                throw new RuntimeException("队列空的，没有数据！！");
            } catch (RuntimeException e) {
//                throw new RuntimeException(e);
                System.out.println(e.getMessage());
            }
        }
        return arr[front];
    }
}

