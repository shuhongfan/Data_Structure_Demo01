package com.shf.tree;

import lombok.Data;
import org.junit.Test;

public class BinaryTreeDemo {
    @Test
    public void test1() {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();
    }

    @Test
    public void test2() {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        System.out.println("前序遍历查找");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.println("找到了，信息为：no=" + resNode.getNo() + " ，name=" + resNode.getName());
        } else {
            System.out.println("没有找到 no=5");
        }

        System.out.println("中序遍历查找");
        resNode = binaryTree.infixOrderSearch(5);
        if (resNode != null) {
            System.out.println("找到了，信息为：no=" + resNode.getNo() + " ，name=" + resNode.getName());
        } else {
            System.out.println("没有找到 no=5");
        }

        System.out.println("后序遍历查找");
        resNode = binaryTree.postOrderSearch(5);
        if (resNode != null) {
            System.out.println("找到了，信息为：no=" + resNode.getNo() + " ，name=" + resNode.getName());
        } else {
            System.out.println("没有找到 no=5");
        }
    }

    @Test
    public void test3() {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(3);

        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
    }

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //    前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //    中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //    后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //    前序遍历
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //    中序遍历
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //    删除节点
    public void delNode(int no){
        if (root!=null){
//            如果只有一个root节点，这里立即判断root是不是就要删除节点
            if (root.getNo()==no){
                root=null;
            } else {
//                递归删除
                root.delNode(no);
            }
        }
    }
}

//先创建HeroNode节点
@Data
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //    编写前序遍历的方法
    public void preOrder() {
        System.out.println(this); // 先输出父节点
//        递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        ;
//        递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //    中序遍历
    public void infixOrder() {
//        递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
//        输出父节点
        System.out.println(this);
//        递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //    后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
//        输出父节点
        System.out.println(this);
    }


    /**
     * 前序遍历查找
     *
     * @param no 查找no
     * @return 如果找到就返回该Node，如果没有找到就返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
//        比较当前节点是不是
        if (this.no == no) {
            return this;
        }
//        1.判断当前节点的左子节点是否为空，如果不为空，则递归 前序查找
//        2.如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) { // 说明左子树找到
            return resNode;
        }
//        1.左递归前序查找，找到节点，则返回，否则继续判断
//        2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //    中序遍历查找
    public HeroNode infixOrderSearch(int no) {
//        判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序遍历");
//        如果没有找到，则返回，如果没有找到，就和当前节点比较，如果是则返回当前节点
        if (this.no == no) {
            return this;
        }
//        否则继续进行右递归的中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //    后序遍历查找
    public HeroNode postOrderSearch(int no) {
//        判断当前节点的子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) { // 说明在左子树找到
            return resNode;
        }

//        如果左子节点没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        System.out.println("进入后序遍历");
//        如果左右节点都没有找到，就比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 递归删除节点
     *
     * @param no
     */
    public void delNode(int no) {
//        2.如果当前节点的左节点不为空，并且左节点就是要删除的节点，就将this.left=null
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
//        3.如果当前节点的右节点不为空，并且右子节点就是要删除的节点，就将this.right=null
        if (this.right != null && this.right.no == no) {
            this.right=null;
            return;
        }
//        4.我们就需要向左子树进行递归删除
        if (this.left!=null){
            this.left.delNode(no);
        }
//        5.则应当向右子树进行递归删除
        if (this.right!=null){
            this.right.delNode(no);
        }
    }
}
}