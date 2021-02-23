package com.sf.datastructure.part5queue;

/**
 * Created by 80002946 on 2018/1/10.
 */
class QueueNode{
    int data;//节点数据
    QueueNode next;//指向下一个节点
    public QueueNode(int data){
        this.data=data;
        this.next=null;
    }
}

public class queueByLink {
    public QueueNode front;//队列的前端指针
    public QueueNode rear;//队列的尾端指针
    public queueByLink(){
        front=null;
        rear=null;
    }

    //存入
    public Boolean enqueue(int value){
        QueueNode node=new QueueNode(value);
        //检查是否为空队列
        if(rear==null) {
            front = node;//建立第一个节点
        }else {
            //将节点加入到队列尾端
            rear.next=node;
        }
        rear=node;
        return true;
    }
    //取出
    public int dequeue(){
        int value=-1;
        if(front!=null){
            if(rear==front){
                rear=null;
            }
            value=front.data;
            front=front.next;
        }
        return value;
    }

    public static void main(String[] args) {
        queueByLink queue=new queueByLink();//建立队列对象
        int temp;
        System.out.println("以链表来实现队列");
        System.out.println("=============================");
        System.out.println("在队列前端加入第1个数据,此数据值为1");
        queue.enqueue(1);
        System.out.println("在队列前端加入第1个数据,此数据值为2");
        queue.enqueue(2);
        System.out.println("在队列前端加入第1个数据,此数据值为3");
        queue.enqueue(3);
        System.out.println("在队列前端加入第1个数据,此数据值为4");
        queue.enqueue(4);
        System.out.println("在队列前端加入第1个数据,此数据值为5");
        queue.enqueue(5);
        System.out.println("==============================");
        while (true){
            if(queue.front!=null){
                temp=queue.dequeue();
                System.out.println("从队列前端依次取出的元素数据值为："+temp);
            }else{
                break;
            }
        }
    }
}
