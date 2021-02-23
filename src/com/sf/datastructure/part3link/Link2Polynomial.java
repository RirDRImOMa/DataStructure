package com.sf.datastructure.part3link;



/**
 * Node节点类
 */
class Node{
    int coef;
    int exp;
    Node next;
    public Node(int coef,int exp) {
        this.coef = coef;
        this.exp = exp;
        this.next = null;
    }
}
/**
 * 多项式链表
 */
class PolyLinkedList{
    public Node first;//首节点
    public Node last;//尾节点
    public boolean isEmpty(){
        //如果首节点为空
        return first==null;
    }

    /**
     * 创建项式
     */
    public void createLink(int coef,int exp){
        Node newNode=new Node(coef,exp);
        if(this.isEmpty()){
                first=newNode;
                last=newNode;
        }else{
                last.next=newNode;
                last=newNode;
        }
    }

    /**
     * 输出多项式
     */
    public void print_link(){
        Node current=first;
        while (current!=null){
            if(current.exp==1&&current.coef!=0){//X^1时显示
                System.out.print(current.coef+"X+");
            }else if(current.exp!=0&&current.coef!=0){
                System.out.print(current.coef+"X^"+current.exp+"+");
            }else if(current.coef!=0){
                System.out.print(current.coef);
            }

            current=current.next;
        }
        System.out.println();
    }

    /**
     *
     * @param b
     * @return
     */
    public PolyLinkedList sumLink(PolyLinkedList b){
        int sum[] =new int[10];
        int i=0,maxnumber;
        PolyLinkedList tempLinkedList=new PolyLinkedList();

        PolyLinkedList a=new PolyLinkedList();
        int tempexp[] =new int[10];
        Node ptr;
        a=this;
        ptr=b.first;
        while(a.first!=null){  //判断多项式
            b.first=ptr;
            while(b.first!=null){
                if(a.first.exp==b.first.exp){//重复比较A和B指数
                    sum[i]=a.first.coef+b.first.coef;
                    tempexp[i]=a.first.exp;
                    a.first=a.first.next;
                    b.first=b.first.next;
                    i++;
                }else if(b.first.exp>a.first.exp){//B指数比较大
                    sum[i]=b.first.coef;
                    tempexp[i]=b.first.exp;
                    b.first=b.first.next;
                    i++;
                }else if(b.first.exp<a.first.exp){//A的指数较大
                    sum[i]=a.first.coef;
                    tempexp[i]=a.first.exp;
                    a.first=a.first.next;
                    i++;
                }
            }
        }
        maxnumber=i-1;
        for (int j=0;j<maxnumber+1;j++){
            tempLinkedList.createLink(sum[j],maxnumber-j);
        }
        return tempLinkedList;
    }
}

/**
 * 多项式链表表示法
 * Created by 80002946 on 2017/12/12.
 */
public class Link2Polynomial {
    public static void main(String[] args) {
        PolyLinkedList a=new PolyLinkedList();
        PolyLinkedList b=new PolyLinkedList();
        PolyLinkedList c=new PolyLinkedList();
        int data1[]={8,25,7,0,1,3,0,4,2};
        int data2[]={2,6,0,0,0,5,6,8,6,9};
        System.out.println("原始多项式：\nA=");
        for (int i=0;i<data1.length;i++){
            a.createLink(data1[i],data1.length-i-1);//建立多项式A,系数由3递减
        }
        a.print_link();
        System.out.println("原始多项式：\nB=");
        for (int i=0;i<data2.length;i++) {
            b.createLink(data2[i], data2.length - i - 1);//建立多项式A,系数由3递减
        }
        b.print_link();
        System.out.println("多项式相加的结果：\nC=");
        c = a.sumLink(b);
        c.print_link();
    }
}
