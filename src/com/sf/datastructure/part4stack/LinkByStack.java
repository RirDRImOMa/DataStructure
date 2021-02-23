package com.sf.datastructure.part4stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 80002946 on 2017/12/28.
 */

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

class StackByLink{
    public Node front;
    public Node rear;

    public boolean isEmpty(){
        return front==null;
    }

    public void output_of_Stack(){
        Node current=front;
        while(current!=null){
            System.out.println("["+current.data+"]");
            current=current.next;
        }
        System.out.println();
    }

    public void insert(int data){
        Node newNode=new Node(data);
        if(this.isEmpty()){
            front=newNode;
            rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
    }

    public void pop(){
        Node newNode;
        if(this.isEmpty()){
            System.out.println("===堆栈已经为空===");
            return;
        }
        newNode =front;
        if(newNode==rear){
            front=null;
            rear=null;
            System.out.println("===目前为空堆栈===");
        }else{
            while (newNode.next!=rear){
                newNode=newNode.next;
            }
            newNode.next=rear.next;
            rear=newNode;
        }
    }
}

public class LinkByStack {
    public static void main(String[] args) throws IOException{
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        StackByLink stackByLink=new StackByLink();
        int choice=0;
        while (true){
            System.out.println("(0)结束（1）在堆栈中加入数据（2）弹出堆栈数据：");
            choice=Integer.parseInt(buf.readLine());
            if(choice==0){
                break;
            }else if(choice==1){
                System.out.println("输入要添加的内容：");
                stackByLink.insert(Integer.parseInt( buf.readLine()));
                System.out.println("数据加入后的堆栈内容");
                stackByLink.output_of_Stack();
            }else if(choice==2){
                stackByLink.pop();
                System.out.println("数据弹出后的堆栈内容");
                stackByLink.output_of_Stack();
            }else{
                System.out.println("输入错误");
            }
        }
    }

}
