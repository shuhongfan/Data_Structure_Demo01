package com.shf.binarySortTree;

import org.junit.Test;

public class BinarySortTreeDemo {
    @Test
    public void test1() {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
//        循环的添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

//        中序遍历二叉排序树
        binarySortTree.infixOrder();

//        删除叶子节点
        binarySortTree.delNode(1);
        System.out.println("删除后节点：");
        binarySortTree.infixOrder();
    }

}

class BinarySortTree{
    private Node root;

    /**
     * 1.返回的 以node为根节点的二叉树的最小节点的值
     * 2.删除node 为根节点的二叉树排序的最小节点
     * @param node  传入的节点（当做二叉树的根节点）
     * @return  返回的 以node为根节点的二叉树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
//        循环的查找左子节点，就会找到最小值
        while (target.left!=null){
            target=target.left;
        }
//        这是target就指向最小节点
//        删除最小节点
        delNode(target.value);
        return target.value;
    }

//    删除节点
    public void delNode(int value){
        if (root==null){
            return;
        } else {
//            需要去找到要删除的节点
            Node targetNode = search(value);
//            如果没有找到要删除的节点
            if (targetNode==null){
                return;
            }
//            这颗二叉排序树只有一个节点
            if (root.left==null&&root.right==null){
                root=null;
                return;
            }
//            去找到targetNode的父节点
            Node parent = searchParent(value);
//            如果要删除的节点是叶子节点
            if (targetNode.left==null && targetNode.right==null){
//                判断targetNode是父节点的左子节点，还是右子节点
                if (parent.left!=null && parent.left.value==value){ // 是左子节点
                    parent.left=null;
                } else if (parent.right!=null && parent.right.value==value){ // 是右子节点
                    parent.right=null;
                }
            } else if (targetNode.left!=null && targetNode.right!=null) { // 删除两颗指数的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value=minVal;
            } else { // 删除只有一颗子树的节点
                if (targetNode.left!=null){ // 如果targetNode是parent的左子节点
                    if (parent!=null){
                        if (parent.left.value==value){
                            parent.left=targetNode.left;
                        } else { // targetNode是parent的右子节点
                            parent.right=targetNode.left;
                        }
                    } else {
                        root=targetNode.left;
                    }
                } else { // 如果要删除的节点是右子节点
                    if (parent!=null){
                        if (parent.left.value==value){
                            parent.left=targetNode.right;
                        } else { // 如果targetNode是parent的右子节点
                            parent.right=targetNode.right;
                        }
                    } else {
                        root=targetNode.left;
                    }
                }
            }
        }
    }

//    查找要删除的节点
    public Node search(int value) {
        if (root==null){
            return null;
        } else {
            return root.search(value);
        }
    }

//    查找父节点
    public Node searchParent(int value){
        if (root==null){
            return null;
        } else {
            return root.searchParent(value);
        }
    }

//    添加节点的方法
    public void add(Node node){
        if (root==null){
            root=node; // 如果root为空则直接让root指向node
        } else {
            root.add(node);
        }
    }

//    中序遍历
    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}

//创建Node节点
class Node{
    int value;
    Node left;
    Node right;

//    左旋转方法
    private void leftRotate(){
//        创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
//        把新的节点的左子树设置成当前节点的左子树
        newNode.left=left;
//        把新的的节点的右子树设置成带你过去节点的左子树
        newNode.right=right.left;
//        把当前节点的值替换成右子节点的值
        value=right.value;
//        把当前节点的右子树设置成当前节点右子树
        right=right.right;
//        把当前节点的左子树（左子节点）设置成新的节点
        left=newNode;
    }

//    右旋转
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        left=left.left;
        right=newNode;
    }

//    返回当前节点的高度，
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0: right.height())+1;
    }

//    返回左子树的高度
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }

//    返回右子树的高度
    public int rightHeight(){
        if (right==null){
            return 0;
        }
        return right.height();
    }

    /**
     *  查找要删除的节点
     * @param value 希望删除的节点的值
     * @return 如果找到返回该节点，否则返回null
     */
    public Node search(int value){
        if (value==this.value){ // 找到就是该节点
            return this;
        } else if (value<this.value){ // 如果查找到的值小于当前节点，向左子树递归查找
//            如果左子节点为空
            if (this.left==null){
                return null;
            }
            return this.left.search(value);
        } else { // 如果查找的值不小于当前节点，向右子树递归查找
            if (this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除节点的父子节点
     * @param value  要找到节点的值
     * @return  返回的是要删除的节点的父节点，如果没有就返回null
     */
    public Node searchParent(int value){
        if ((this.left!=null && this.left.value==value) || (this.right!=null&&this.right.value==value)){
            return this;
        } else {
//            如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (value<this.value && this.left!=null){
                return this.left.searchParent(value); // 向左子树递归查找
            } else if (value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            } else {
                return null; // 没有找到父子节点
            }
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //    添加节点的方法
    public void add(Node node){
        if (node==null){
            return;
        }

//        判断传入的节点的值，和当前子树的根节点的值关系
        if (node.value<this.value){
//            如果当前节点左子节点为null
            if (this.left==null){
                this.left=node;
            } else {
//                递归的向左子树添加
                this.left.add(node);
            }
        } else { // 添加的节点的值大于 当前节点的值
            if (this.right==null){
                this.right = node;
            } else {
//                递归的向右子树添加
                this.right.add(node);
            }
        }

//        当添加完成一个节点后，如果（右子树的高度-左子树的高度）>1,坐旋转
        if (rightHeight()-leftHeight()>1){
            leftRotate(); // 坐旋转
        }
    }

//    中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
}
