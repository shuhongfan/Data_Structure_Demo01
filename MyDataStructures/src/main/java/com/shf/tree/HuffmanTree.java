package com.shf.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    @Test
    public void test1(){
        int[] arr = {13,7,8,3,29,6,1};

        Node huffmanTree = createHuffmanTree(arr);

        preOrder(huffmanTree);
    }

//    前序遍历的方法
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历");
        }
    }

    public static Node createHuffmanTree(int[] arr){
//        1.遍历arr数组
//        2.将arr的每个元素构成一个Node
//        3.将Node放入到ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size()>1){
//        排序 从小到大
            Collections.sort(nodes);

            System.out.println("nodes="+nodes);

//        1.取出根节点权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
//        2.取出第二小的节点
            Node rightNode = nodes.get(1);

//        3.构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

//        4.从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

//        5.将parent加入到nodes
            nodes.add(parent);

            System.out.println("第一次处理后"+nodes);
        }

//        返回赫夫曼树的root节点
        return nodes.get(0);
    }
}

//创建节点类
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }

//    前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
}
