package com.sf.datastructure.part6tree;

/**
 * Created by 80002946 on 2018/2/12.
 * 线索二叉树的建立与中序遍历
 */

/**
 * 线索二叉树节点声明
 */
class TreadNode{
    int value;
    int leftThread;
    int rightThread;
    TreadNode leftNode;
    TreadNode rightNode;
    //构造模块
    public TreadNode(int value){
        this.value=value;
        this.leftThread=0;
        this.rightThread=0;
        this.leftNode=null;
        this.rightNode=null;
    }
}

/**
 * 线索二叉树声明
 */
public class ThreadBinaryTree {
    public TreadNode rootNode;//线索二叉树根节点

    /**
     * 无参构造方法
     */
    public ThreadBinaryTree(){
        this.rootNode=null;
    }
    /**
     * 构造方法，传入一个数组建立一个线索二叉树
     */
    public ThreadBinaryTree(int data[]){
        for (int i=0;i<data.length;i++){
            AddNode2Tree(data[i]);
        }
    }
    /**
     * 将指定的值加入线索二叉树
     */
    void AddNode2Tree(int value){
        TreadNode newNode=new TreadNode(value);
        TreadNode current;
        TreadNode parent;
        TreadNode previous=new TreadNode(value);
        int pos;
        //设定线索二叉树的开头节点
        if(rootNode==null){
            rootNode=newNode;
            rootNode.leftNode=rootNode;
            rootNode.rightNode=null;
            rootNode.leftThread=0;
            rootNode.rightThread=0;
            return;
        }
        //设定开头节点所指的节点
        current=rootNode.rightNode;
        if(current==null){
            rootNode.rightNode=newNode;
            newNode.leftNode=rootNode;
            newNode.rightNode=rootNode;
            return;
        }

        parent=rootNode;
        pos=0;//设定二叉树中的行进方向
        while(current!=null){
            if(current.value>value){
                if(pos!=-1){
                    pos=-1;
                    previous=parent;
                }
                parent=current;
                if(current.leftThread==1){
                    current=current.leftNode;
                }else{
                    current=null;
                }
            }
            else {
                if(pos!=1){
                    pos=1;
                    previous=parent;
                }
                parent=current;
                if(current.rightThread==1){
                    current=current.rightNode;
                }else{
                    current=null;
                }
            }
        }
        if(parent.value>value){
            parent.leftThread=1;
            parent.leftNode=newNode;
            newNode.leftNode=previous;
            newNode.rightNode=parent;
        }else{
            parent.rightThread=1;
            parent.rightNode=newNode;
            newNode.leftNode=parent;
            newNode.rightNode=previous;
        }
        return;
    }
    /**
     * 线索二叉树中序遍历
     */
    void print(){
        TreadNode tempNode;
        tempNode=rootNode;
        do {
            if(tempNode.rightThread==0){
                tempNode=tempNode.rightNode;
            }else{
                tempNode=tempNode.rightNode;
                while(tempNode.leftThread!=0){
                    tempNode=tempNode.leftNode;
                }
            }
            if(tempNode!=rootNode){
                System.out.println("["+tempNode.value+"]");
            }
        }while (tempNode!=rootNode);
    }

    public static void main(String[] args) {
        System.out.println("线索二叉树已经建立，以中序追踪能有排序效果");
        System.out.println("除了第一个数字作为线索二叉树的开头节点外");
        int[] data1={0,10,20,30,100,399,453,43,237,373,655};
        ThreadBinaryTree tree1=new ThreadBinaryTree(data1);
        System.out.println("============================");
        System.out.println("范例1");
        System.out.println("数字有小到大的排列顺序结果为：");
        tree1.print();
    }
}
