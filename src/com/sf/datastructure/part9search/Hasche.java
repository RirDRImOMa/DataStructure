package com.sf.datastructure.part9search;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

import java.util.Random;

/**
 * Created by 80002946 on 2018/5/6.
 * 再哈希（利用链表）
 */
public class Hasche {
    final static int INDEXBOX=7;
    final static int MAXNUM=13;
    static Node indexTable[]=new Node[INDEXBOX];//声明动态数组

    public static void main(String[] args) {
        int i;
        int index[]=new int[INDEXBOX];
        int data[]=new int[MAXNUM];
        Random random=new Random();
        for (i=0;i<INDEXBOX;i++){
            indexTable[i]=new Node(-1);
        }
        System.out.println("原始数据：");
        for (i=0;i<MAXNUM;i++){
            data[i]=(Math.abs(random.nextInt(30)))+1;
            System.out.print("["+data[i]+"]");
            if(i%8==7){
                System.out.println();
            }
        }
        System.out.println("\n哈希表");
        for (i=0;i< MAXNUM;i++){
            creatTable(data[i]);//建立哈希表
        }
        for (i=0;i<INDEXBOX;i++){
            printData(i);
        }
        System.out.println();
    }

    public static void creatTable(int val){
        Node newNode=new Node(val);
        int hash;
        hash=val%7;//哈希函数除以7取余
        Node current=indexTable[hash];
        if (current.next==null){
            indexTable[hash].next=newNode;
        }else {
            while (current.next!=null){
                current=current.next;
            }
        }
        current.next=newNode;//节点加在表头后面
    }

    public static void printData(int val){//打印哈希表子程序
        Node head;
        int i=0;
        head=indexTable[val].next;//起始指针
        System.out.print(" "+val+"\t");
        while (head!=null){
            System.out.print("["+head.val+"]-");
            i++;
            if (i%8==7){
                System.out.println("\n\t");
            }
            head=head.next;
        }
        System.out.println();
    }
}
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }
}
