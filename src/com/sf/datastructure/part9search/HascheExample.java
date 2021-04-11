package com.sf.datastructure.part9search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by 80002946 on 2018/5/6.
 * 哈希法综合案例
 */
public class HascheExample {
    final static int INDEXBOX=7;
    final static int MAXNUM=13;
    static Node indextable[]=new Node[INDEXBOX];

    public static void main(String[] args) throws Exception{
        int i,num;
        int index[]=new int[INDEXBOX];
        int data[]=new int[MAXNUM];
        Random rand=new Random();
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        for (i=0;i<INDEXBOX;i++){
            indextable[i]=new Node(-1);
        }
        System.out.println("原始数据 \nm\t");
        for (i=0;i<MAXNUM;i++){
            data[i]=(Math.abs(rand.nextInt(30)))+1;
            System.out.print("["+data[i]+"]");
            if(i%8==7){
                System.out.println();
                System.out.println();
            }
        }
        for (i=0;i<MAXNUM;i++){
            creatTable(data[i]);
        }
        System.out.println();
        while (true){
            System.out.println("请输入查找数据(1-30),结束输入-1:");
            num=Integer.parseInt(keyin.readLine());
            if(num==-1){
                break;
            }
            i=findNum(num);
            if(i==0){
                System.out.println("***********没有找到"+num+" ***********");
            }else {
                System.out.println("找到了"+num+"共"+i+"次");
            }
            System.out.println("哈希表");
            for (i=0;i<INDEXBOX;i++){
                printData(i);
            }
            System.out.println();

        }
    }

    public static int findNum(int num){
        Node ptr;
        int i=0,hash;
        hash=num%7;
        ptr=indextable[hash].next;
        while(ptr!=null){
            i++;
            if (ptr.val==num){
                return i;
            }else {
                ptr=ptr.next;
            }
        }
        return 0;
    }
    public static void creatTable(int val){
        Node newNode=new Node(val);
        int hash;
        hash=val%7;//哈希函数除以7取余
        Node current=indextable[hash];
        if (current.next==null){
            indextable[hash].next=newNode;
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
        head=indextable[val].next;//起始指针
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

