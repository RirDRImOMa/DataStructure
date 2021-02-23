package com.sf.datastructure.part4stack;

/**
 * Created by 80002946 on 2018/1/1.
 */

class NodeMaze{
    int x;
    int y;
    NodeMaze next;
    public NodeMaze(int x,int y){
        this.x=x;
        this.y=y;
        this.next=null;
    }
}

public class TraceRecord {
    public NodeMaze first;
    public NodeMaze last;

    public boolean isEmpty(){
        return first==null;
    }

    public void insert(int x,int y){
        NodeMaze newNode=new NodeMaze(x,y);
        if(this.isEmpty()){
            first=newNode;
            last=newNode;
        }else{
            last.next=newNode;
            last=newNode;
        }

    }

    public void delete(){
        NodeMaze newNode;
        if(this.isEmpty()){
            System.out.println("队列已经为空");
            return;
        }
        newNode =first;
        while (newNode.next!=last){
            newNode=newNode.next;
        }
        newNode.next=last.next;
        last=newNode;
    }

}
