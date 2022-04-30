package com.shf.linkedList;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

//        入栈
        stack.add("jack");
        stack.add("Tom");
        stack.add("smith");

//        出栈
        while (stack.size()>0){
//            将栈顶数据取出
            System.out.println(stack.pop());
        }
    }
}
