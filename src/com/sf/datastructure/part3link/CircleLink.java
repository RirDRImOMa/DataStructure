package com.sf.datastructure.part3link;


/**
 * 节点类
 */
class Node1{
        int data;
        Node1 next;
        public Node1(int data){
            this.data=data;
            this.next=null;
        }
}

/**
 * 环形链表
 * Created by 80002946 on 2017/12/14.
 */
public class CircleLink {
    public Node1 first;
    public Node1 last;
    public boolean isEmpty(){
        return first==null;
    }

    public void print(){
        Node1 current=first;
        while(current!=last){
            System.out.println("["+current.data+"]");
            current=current.next;
        }
        System.out.println("["+current.data+"]");
        System.out.println();
    }
    /**
     * 插入节点
     */
    public void insert(Node1 trp){
        Node1 tmp;
        Node1 newNode;
        if(this.isEmpty()){//链表为空
            first=trp;
            last=trp;
            last.next=first; //环形链表
        }else if(trp.next==null){
            last.next=trp;
            last=trp;
            last.next=first;
        }
        {
            newNode=first;
            tmp=first;
            while(newNode.next!=tmp.next){
                if(tmp.next==first){
                    break;
                }
                tmp=newNode;
                newNode=newNode.next;
            }
            tmp.next=trp;
            trp.next=newNode;
        }
    }
    /**
     * 删除节点
     */
    public void delete(Node1 delNode){
        Node1 newNode;
        Node1 tmp;
        if(this.isEmpty()){
            System.out.println("链表已经为空");
            return;
        }
        //要删除的是头节点
        if(first.data==delNode.data){
            first=first.next;
            if(this.isEmpty()){
                System.out.println("链表已经为空");
            }
            return;
        }else if(last.data==delNode.data){//要删除的节点为尾节点
            newNode=first;
            while(newNode.next!=last){
                newNode =newNode.next;
            }
            newNode.next=last.next;
            last=newNode;
            last.next=first;
        }else{
            newNode=first;
            tmp=first;
            while(newNode.next!=last){
                tmp=newNode;
                newNode =newNode.next;
            }
            tmp.next=delNode.next;
        }

    }
}
