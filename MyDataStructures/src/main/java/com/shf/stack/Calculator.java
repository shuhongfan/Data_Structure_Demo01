package com.shf.stack;

import lombok.Data;
import org.junit.Test;

public class Calculator {
    @Test
    public void test(){
        String expression = "70+26*6+4";
//        创建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
//        定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
//        将每次扫描得到的char保存到ch
        char ch = ' ';
        String keepNum = ""; // 用于拼接多位数

        while (true){
//            一次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
//            判断ch是什么，然后做响应的处理
            if (operStack.isOper(ch)){
//                如果是运算符,判断当前的符号栈是否为空
                if (!operStack.isEmpty()){
//                    如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的运算符，就需要从数栈中pop两个数
//                    在符号栈中pop出一个符号，将得到结果，入数栈，然后将当前的操作符如符号栈
                    if (operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper= operStack.pop();
                        res = numStack.cal(num1,num2,oper);
//                        把运算的结果入数栈
                        numStack.push(res);
//                        将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        // 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
//                    如果为空直接入符号栈
                    operStack.push(ch);
                }
            } else {
//                如果是数，则直接入数栈
//                numStack.push(ch-48); // 无法处理多位数字
//                1.当处理多位数时，不能发现是一个数就立即入栈，因为他可能是一个多位数
//                2.在处理数时，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
//                3.因此我们需要定义一个字符串变量 用于拼接

//                处理多位数
                keepNum += ch;

//                如果ch已经是expression的最后一位，就直接入栈
                if (index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                } else {
//                判断下一个字符是不是数字，如果是数字，就继续扫描、如果是运算符，则入数栈
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
//                    如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
//                    清空keepNum
                        keepNum="";
                    }
                }
            }
//            让index+1，并判断是否扫描到expression最后
            index++;
            if (index>=expression.length()){
                break;
            }
        }

//        当表达式扫描完毕，就顺序的从数栈和符号栈中pop出响应的数和符号，并运行
        while (true){
//            如果符号栈为空，则计算到最后的结果，数栈中只有一个数字
            if (operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }

//        将数栈的最后的数，pop出，就是结果
        int res2 = numStack.pop();
        System.out.println("表达式 "+expression+" = "+res2);
    }
}

//定义一个ArrayStack表示栈
@Data
class ArrayStack2{
    //    栈的大小
    private int maxSize;

    //    数组，数组模拟栈，数据就放在数组
    private int[] stack;

    //    top表示栈顶，初始化为-1
    private int top  = -1;

    //    构造器
    public ArrayStack2(int maxSize) {
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

//    返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        } else if (oper=='+'||oper=='-'){
            return 0;
        } else {
            return -1;
        }
    }

//    判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

//    计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;  //res用于存放计算的结果
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
        }
        return res;
    }

//    返回当前栈顶的值,不是pop
    public int peek(){
        return stack[top];
    }
}