package com.sf.datastructure.part3link;

/**
 * Created by 80002946 on 2017/12/20.
 */
class NodeStu{
    int data;
    int np;
    String names;
    NodeStu next;

    public NodeStu(int data,String name,int np) {
        this.np=np;
        this.names=name;
        this.data=data;
        this.next=null;
    }
}

public class StuLinkedList {
    public NodeStu first;
    public NodeStu last;
    public boolean isEmpty(){
        return  first==null;
    }
    public void print(){
        NodeStu current=first;
        while (current!=null){
            System.out.println("["+current.data+" "+current.names+" "+current.np+"]");
            current=current.next;
        }
        System.out.println();
    }

    public void insert(int data,String name,int np){
        NodeStu newNode=new NodeStu(data,name,np);
        if(this.isEmpty()){
            first=newNode;
            last=newNode;
        }else{
            last.next=newNode;
            last=newNode;
        }
    }

    public void delete(NodeStu delNode){
        NodeStu newNode;
        NodeStu tmp;
        if(first.data==delNode.data){
            first=first.next;
        }else if(last.data==delNode.data){
            System.out.println("I am here\n");
            newNode=first;
            while(newNode.next!=last){
                newNode=newNode.next;
            }
            newNode.next=last.next;
            last=newNode;
        }else{
            newNode=first;
            tmp=first;
            while(newNode.data!=delNode.data){
                tmp=newNode;
                newNode=newNode.next;
            }
            tmp.next=delNode.next;
        }
    }

    public StuLinkedList concat(StuLinkedList stuList){
        this.last.next=stuList.first;
        this.last=stuList.last;
        return this;
    }
}
