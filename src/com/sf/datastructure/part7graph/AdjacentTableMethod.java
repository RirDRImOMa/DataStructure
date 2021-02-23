package com.sf.datastructure.part7graph;

import java.util.Date;

/**
 * Created by 80002946 on 2018/2/13.
 * 相邻表法，使用相邻表来表示图形
 */
class Node{
    int value;
    Node next;
    public Node(int value){
        this.value=value;
        this.next=null;
    }
}

class GraphLink{
    public Node first;
    public Node last;
    public boolean isEmpty(){
        return first==null;
    }

    public void print(){
        Node current=first;
        while (current!=null){
            System.out.print("["+current.value+"]");
            current=current.next;
        }
        System.out.println();
    }
    public void insert(int value){
        Node newNode =new Node(value);
        if(this.isEmpty()) {
            first = newNode;
            last = newNode;
        }else {
            last.next=newNode;
            last=newNode;
        }
    }


}
public class AdjacentTableMethod {
    public static void main(String[] args) {
        int[][] data={{1,2},{2,1},{1,5},{5,1},
                {2,3},{3,2},{2,4},{4,2},{3,4},{4,3},{3,5},{5,3}
                ,{4,5},{5,4}};
        int dataNum;
        int i,j;
        System.out.println("图形(a)的领接表内容：");
        GraphLink head[]=new GraphLink[6];
        for (i=0;i<6;i++){
            head[i]=new GraphLink();
            System.out.print("顶点"+i+"=>");
            for (j=0;j<14;j++){
                if(data[j][0]==i){
                    dataNum= data[j][1];
                    head[i].insert(dataNum);
                }
            }
            head[i].print();
        }
    }
}
