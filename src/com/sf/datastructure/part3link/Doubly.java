package com.sf.datastructure.part3link;

/**
 * Created by 80002946 on 2017/12/21.
 */

class NodeD{
    int data;
    NodeD rnext;
    NodeD lnext;
    public NodeD(int data){
        this.data=data;
        this.rnext=null;
        this.lnext=null;
    }
}
public class Doubly {
    public NodeD first;
    public NodeD last;
    public boolean isEmpty(){
        return first==null;
    }
    public void print(){
        NodeD current=first;
        if(current!=null){
            System.out.println("["+current.data+"]");
            current=current.rnext;
        }
        System.out.println();
    }
    public void insert(NodeD newN){
        NodeD tmp;
        NodeD newNode;
        if(this.isEmpty()){
            first=newN;
            first.rnext=last;
            last=newN;
            last.lnext=first;
        }else{//链表不为空
            if(newN.lnext==null){/*插入表头位置*/
                first.lnext=newN;
                newN.rnext=first;
                first=newN;
            }else{
                if(newN.rnext==null){/*插入表尾位置*/
                    last.rnext=newN;
                    newN.lnext=last;
                    last=newN;
                }else{
                    newNode=first;
                    tmp=first;
                    while(newN.rnext!=newN.rnext){
                        tmp=newNode;
                        newNode=newNode.rnext;
                    }
                    tmp.rnext=newN;
                    newN.rnext=newNode;
                    newNode.lnext=newN;
                    newN.lnext=tmp;
                }
            }
        }
    }
    /*删除节点*/
    public void delete(NodeD delNode){
        NodeD newNode;
        NodeD tmp;
        if(first==null){
            System.out.println("[链表为空]\n");
            return;
        }
        if(delNode==null){
            System.out.println("[传入要删除的不能为空]");
            return;
        }
        if(first.data==delNode.data) {//删除表头
            first = first.rnext;
            if (first != null) {
                first.lnext = null;
            }

        }else if(last.data==delNode.data){//要删除的是标表尾
            last=last.lnext;
            if(last!=first&&last!=null){
                last.rnext=null;
            }
        }else{
            newNode=first;
            tmp=first;
            while(newNode.data!=delNode.data){
                tmp=newNode;
                newNode=newNode.lnext;
            }
            tmp.lnext=delNode.lnext;
            tmp.rnext=delNode.rnext;
        }
    }
}

