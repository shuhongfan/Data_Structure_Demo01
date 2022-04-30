package com.shf.linkedList;

import lombok.Data;
import org.junit.Test;


public class DoubleLinkedListDemo {
    @Test
    public void testAdd(){
//        先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //        加入按照编号节点顺序
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
    }

    @Test
    public void testUpdate(){
        //        先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //        加入按照编号节点顺序
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
//        修改
        HeroNode2 heroNode2 = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(heroNode2);

        System.out.println("修改后的链表情况");
        doubleLinkedList.list();
    }

    @Test
    public void testDelete(){
        //        先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //        加入按照编号节点顺序
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
//        删除
        doubleLinkedList.del(1);

        System.out.println("删除后的链表情况");
        doubleLinkedList.list();
    }

    @Test
    public void testAddByOrder(){
//        先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //        加入按照编号节点顺序
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);

        doubleLinkedList.list();
    }
}

//创建一个双链表的类
class DoubleLinkedList{
//    先初始化一个头节点,头节点不动,不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"", "");

//    返回头节点
    public HeroNode2 getHead(){
        return head;
    }

//    遍历双向链表的方法
    public  void list(){
//        判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
//        因为头节点,不能动,因此我们需要一个辅助遍历来遍历
        HeroNode2 temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
//            输出节点的信息
            System.out.println(temp);
//            将temp后移
            temp=temp.next;
        }
    }

//    添加
    public void add(HeroNode2 heroNode){
//        因为head节点不能动,因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
//        遍历链表,找到最后
        while (true){
//            找到链表的最后
            if (temp.next==null){
                break;
            }
//            如果没有找到最后,将temp后移
            temp=temp.next;
        }
//        但退出while循环时,temp就指向了链表的最后
//        形成一个双向链表
        temp.next=heroNode;
        heroNode.pre=temp;
    }

//    修改一个节点的内容
    public void update(HeroNode2 newHeroNode){
//        判断是否为空
        if (head.next==null){
            System.out.println("链表为空~");
            return;
        }
//        找到需要修改的节点,根据NO编号
//        定义一个辅助变量
        HeroNode2 temp = head.next;
//        表示是否找到该节点
        boolean flag = false;
        while (true){
            if (temp==null){
                break; // 已经遍历完链表
            }
            if (temp.no==newHeroNode.no){
//                找到
                flag=true;
                break;
            }
            temp=temp.next;
        }
//        根据flag 判断是否找到需要修改的节点
        if (flag){
            temp.name=newHeroNode.name;
            temp.nickName=newHeroNode.nickName;
        } else {
            System.out.println("没有找到编号"+newHeroNode.no+"的节点,不能修改");
        }
    }

//    删除节点  双向链表,我们可以直接找到要删除的这个节点,找到后,自我删除即可
    public void del(int no){
//        判断当前链表是否为空
        if (head.next==null){
            System.out.println("链表为空,无法删除");
            return;
        }

//        辅助变量(指针)
        HeroNode2 temp = head.next;
//        标志是否找到待删除节点
        boolean flag = false;
        while (true){
//            已经找到链表的最后
            if (temp==null){
                break;
            }
            if (temp.no==no){
//                找到待删除的前一个节点temp
                flag=true;
                break;
            }
            temp=temp.next;
        }
//        判断flag
        if (flag){
            temp.pre.next=temp.next;
//            如果是最后一个节点,就不要下面这句话,否则出现空指针
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }
        } else {
            System.out.println("要删除的"+no+"不存在");
        }
    }

    public void addByOrder(HeroNode2 heroNode){
//        因为头节点不能动,因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
//        因为单链表,因为我们找的temp是位于添加位置的前一个节点,否则插入不了
        HeroNode2 temp = head;
        boolean flag = false; // 标志添加的编号是否存在,默认为false
        while (true){
            if (temp.next==null){ // 说明temp已经在链表的最后
                break;
            }
            if (temp.next.no>heroNode.no){
//                位置找到,就在temp的后面插入
                break;
            } else if (temp.next.no==heroNode.no){
//                说明希望添加的heroNode的编号已然存在
                flag=true; // 说明编号存在
                break;
            }
            temp=temp.next;  //后移,遍历当前的链表
        }
        //        判断flag的值
        if (flag){  // 不能添加,说明编号存在
            System.out.println("准备插入的英雄编号"+heroNode.no+"已经存在了,不能加入\n");
        } else {
//            插入到链表中,temp的后面
            heroNode.next=temp.next;
            heroNode.pre=temp;
            temp.next=heroNode;
        }
    }
}

@Data
class HeroNode2{

    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}