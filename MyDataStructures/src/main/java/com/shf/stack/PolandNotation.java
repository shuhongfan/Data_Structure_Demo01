package com.shf.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    @Test
    public void test1() {
//        先给定逆波兰表达式 （3+4）*5-6
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";

        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);

        int res = calculate(rpnList);
        System.out.println("计算的结果是："+res);
    }

    @Test
    public void test2(){
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式="+infixExpressionList);

        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("后缀表达式="+suffixExpreesionList);

        System.out.println(calculate(suffixExpreesionList));
    }


    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        Stack<String> s1 = new Stack<>(); // 符号栈
//        Stack<String> s2 = new Stack<>(); // 存储中间结果栈s2
        ArrayList<String> s2 = new ArrayList<>();

//        遍历ls
        for (String item : ls) {
//            如果是一个数，加入s2
            if (item.matches("\\d+")){
                s2.add(item);
            } else if (item.equals("(")){
                s1.push(item);
            } else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
//                当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转到与s1中的栈顶运算符比较
                while (s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
//                还需要将item压入栈
                s1.push(item);
            }
        }
//        将s1剩余的运算符依次弹出并加入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }

        return s2;
    }

        //方法：将 中缀表达式转成对应的List
    //  s="1+((2+3)×4)-5";
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，我需要加入到ls
            if((c=s.charAt(i)) < 48 ||  (c=s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //i需要后移
            } else { //如果是一个数，需要考虑多位数
                str = ""; //先将str 置成"" '0'[48]->'9'[57]
                while(i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;//返回
    }

//  将一个逆波兰表达式，依次将数据和运算符 放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
//        将suffixExpression分割
        String[] split = suffixExpression.split(" ");

        ArrayList<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

//    完成对逆波兰表达式的运算
    public static int calculate(List<String> ls){
//        创建栈
        Stack<String> stack = new Stack<>();
//        遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")){  // 匹配的是多位数
//                入栈
                stack.push(item);
            } else {
//                pop出两个数，并计算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());

                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                } else if (item.equals("-")){
                    res = num1 - num2;
                } else if (item.equals("*")){
                    res = num1 * num2;
                } else if (item.equals("/")){
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
//                把res入栈
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

//编写一个类 Opearation 可以返回一个运算符 对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}