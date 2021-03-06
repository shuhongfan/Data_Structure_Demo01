package com.shf.stack;

import lombok.Data;
import org.junit.Test;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
//        控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show：表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈（入栈）");
            System.out.println("pop：表示从栈取出数据（出栈）");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("出栈的数据是："+res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
            }

        }
        System.out.println("程序退出成功~");
    }
}

//定义一个ArrayStack表示栈
@Data
class ArrayStack{
//    栈的大小
    private int maxSize;

//    数组，数组模拟栈，数据就放在数组
    private int[] stack;

//    top表示栈顶，初始化为-1
    private int top  = -1;

//    构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

//    栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

//    栈空
    public boolean isEmpty(){
        return top==-1;
    }

//    入栈--push
    public void push(int value){
//        先判断栈是否满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

//    出栈,将栈顶的数据返回
    public int pop(){
//        先判断栈是否空
        if (isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

//    显示栈的情况【遍历栈】，遍历时，需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
//        需要从栈顶就开始显示数据
        for (int i=top;i>=0;i--){
            System.out.println("stack["+i+"]="+stack[i]);
        }
    }
}
