package com.shf.linkedList;

import lombok.Data;
import org.junit.Test;

import java.util.Stack;

public class SingleLinkedListDemo {
    @Test
    public void testAdd(){
//        先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

//        创建给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);


        singleLinkedList.list();
    }

    @Test
    public void testAddByOrder(){
        //        先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //        加入按照编号节点顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();
    }

    @Test
    public void testUpdate() {
        //        先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //        加入按照编号节点顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();

//        测试修改节点的代码
        HeroNode heroNode = new HeroNode(2, "小卢", "玉麒麟!!!");
        singleLinkedList.update(heroNode);

        System.out.println("修改后的链表情况~");
        singleLinkedList.list();

//        测试一下,求单链表的有效节点的个数
    }

    @Test
    public void testDelete(){
        //        先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //        加入按照编号节点顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();

//        删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.del(2);
        singleLinkedList.del(3);

        System.out.println("修改后的链表情况~");
        singleLinkedList.list();
    }

    /**
     * 方法:获取到单链表的节点的个数(如果是带头节点的链表,需要不统计头节点)
     * @param heroNode 链表的头节点
     * @return  返回的是有效节点的个数
     */
    public static int getLength(HeroNode heroNode){
        if (heroNode.next==null){
            return 0;
        }
        int length=0;
//        定义一个辅助的变量,这里没有统计头节点
        HeroNode cur = heroNode.next;
        while (cur!=null){
            length++;
            cur = cur.next;  // 遍历
        }
        return length;
    }

    @Test
    public void testGetLength(){
        //        先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //        加入按照编号节点顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();

        System.out.println("有效的节点个数="+getLength(singleLinkedList.getHead()));
    }

//    查找单链表中的倒数第k个节点
//    1.编写一个方法,接收head节点,同时接收一个index
//    2.index表示是倒数第index个节点
//    3.先把链表从头到尾遍历,得到链表的总的长度 getLength
//    4.得到size后,我们从链表的第一个开始遍历(size-index)个,就可以得到
//    5.如果找到了,则返回该节点,否则返回null
    public static HeroNode findLastIndexNode(HeroNode heroNode,int index){
//        如果链表为空,返回null
        if (heroNode.next==null){
            return null;
        }
//        第一个遍历得到链表的长度(节点个数)
        int size = getLength(heroNode);
//        第二次遍历  size-index位置,就是我们的倒数的第k个节点
//        先做一个index的校验
        if (index<=0||index>size){
            return null;
        }
//        定义辅助变量 for循环定位到倒数的index个
        HeroNode cur = heroNode.next;
        for (int i = 0; i < size-index; i++) {
            cur=cur.next;
        }
        return cur;
    }

    @Test
    public void testFindLastIndexNode(){
        //        先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //        加入按照编号节点顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();

        System.out.println("有效的节点个数="+getLength(singleLinkedList.getHead()));

        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("查找的节点为:"+lastIndexNode);
    }

//    将单链表反转
    public static void reverseList(HeroNode heroNode){
//        如果当前链表为空,或者只有一个节点,无需反转,直接返回
        if (heroNode.next==null || heroNode.next.next==null){
            return;
        }

//        定义一个辅助的指针(变量),帮助我们遍历原来的链表
        HeroNode cur = heroNode.next;
//        指向当前节点[cur]的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
//        遍历原来的链表,每遍历一个节点,就将其取出,并放在新的链表reverse Head的最前端
        while (cur!=null){
//            先暂时保存当前节点的下一个节点,因为后面需要使用
            next=cur.next;
//            将cur的下一个节点指向新的链表的最前端
            cur.next=reverseHead.next;
//            将cur 连接到新的链表上
            reverseHead.next=cur;
//            让cur后移
            cur=next;
        }
//        将head.next指向reverseHead.next，实现单链表反转
        heroNode.next=reverseHead.next;
    }

    @Test
    public void testReverseList(){
        //        先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //        加入按照编号节点顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();

        System.out.println("有效的节点个数="+getLength(singleLinkedList.getHead()));

        System.out.println("反转过后的单链表：");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
    }

//    逆序打印
    public static void reversePrint(HeroNode heroNode){
//        空链表，不能打印
        if (heroNode.next==null){
            return;
        }
//        创建要给出一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = heroNode.next;
//        将链表的所有节点压入栈
        while (cur!=null){
            stack.push(cur);
//            让cur后移,这样就可以压入下一个节点
            cur=cur.next;
        }
//        将栈中的节点进行打印  pop出栈
        while (stack.size()>0){
//            stack的特点是先进后出
            System.out.println(stack.pop());
        }
    }

    @Test
    public void testReversePrint(){
        //        先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        加入按照编号节点顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();

        System.out.println("有效的节点个数="+getLength(singleLinkedList.getHead()));

        System.out.println("测试逆序打印单链表,没有改变本身的结构：");
        reversePrint(singleLinkedList.getHead());
    }
}

//定义HeroNode，每个HerNode对象就是一个节点
@Data
//定义SingleLikedList管理我们的英雄
class SingleLinkedList{
    //    向初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //    添加节点到单项链表
//    思路：当不考虑编号顺序时
//    1.找到当前链表的最后节点
//    2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
//        因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        while (true){
//            找到链表的最后
            if (temp.next==null){
                break;
            }
//            如果没有找到最后，将temp后移
            temp=temp.next;
        }
//        当退出while循环时，temp就指向了链表的最后
//        将最后这个节点的next指向新的节点
        temp.next=heroNode;
    }

    //    显示链表[遍历]
    public void list(){
//        判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
//        因为头节点,不能都,因此我们需要一个辅助遍历来遍历
        HeroNode temp = head.next;
        while (true){
//            判断是否到链表最后
            if (temp==null){
                break;
            }
//            输出节点的信息
            System.out.println(temp);
//            将temp后移
            temp=temp.next;
        }
    }


    //    第二种方式在添加英雄时,根据排名将英雄插入到指定位置
//    如果有这个排名,则添加失败,并给出提示
    public void addByOrder(HeroNode heroNode){
//        因为头节点不能动,因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
//        因为单链表,因为我们找的temp是位于添加位置的前一个节点,否则插入不了
        HeroNode temp = head;
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
            temp.next=heroNode;
        }
    }

    //    修改节点信息,根据no编号来修改,即no编号不能改
//    说明
//    1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
//        判断是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }

//        找到需要修改的节点,根据no编号
        HeroNode temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no== newHeroNode.no){
//                找到
                flag=true;
                break;
            }
            temp=temp.next;
        }
//        根据flag 判断是否找到需要修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
//            没有找到
            System.out.println("没有找到编号"+newHeroNode.no+"的节点,无法修改");
        }
    }

    //    删除节点
//    思路
//    1.head不能动,因此我们需要一个temp辅助节点找到待删除节点的前一个节点
//    2.说明我们在比较时,时temp.next.no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp = head;
//        标志是否找到待删除节点
        boolean flag = false;
        while (true){
//            已经到链表的最后
            if (temp.next==null){
                break;
            }
            if (temp.next.no==no){
//                找到待删除节点的前一个节点temp
                flag=true;
                break;
            }
//            temp后移
            temp=temp.next;
        }
//        判断flag
        if (flag){ // 找到,可以删除
            temp.next=temp.next.next;
        } else {
            System.out.println("要删除的节点"+no+"不存在");
        }
    }

}

@Data
class HeroNode{

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}