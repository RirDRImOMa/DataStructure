package com.sf.datastructure.part5queue;

/**
 * Created by 80002946 on 2018/1/12.
 */
class LinkedListQueue{
    public QueueNode front;//队列的前端指针
    public QueueNode rear;//队列的尾端指针
    public LinkedListQueue(){
        front=null;
        rear=null;
    }
    //队列数据存入
    public Boolean enqueue(int value){
        QueueNode node=new QueueNode(value);//建立节点
        //检查队列是否为空
        if(rear==null){//队列为空
            front=node;
        }else{
            rear.next=node;//将节点加入到队列的尾端
        }
        rear=node;
        return true;
    }

    //队列数据取出
    public int dequeue(int action){
        int value;
        QueueNode tempNode,startNode;
        //从前端取出数据
        if(!(front==null)&&action==1){
            if(rear==front){
                rear=null;
            }
            value=front.data;
            front=front.next;
            return value;
        }else if(!(rear==null)&&action==2){
            //先记录前端的指针值
            startNode=front;
            //取出目前尾端的数据
            value=rear.data;

            //找寻最尾端节点的前一个节点
            tempNode=front;
            while (front.next!=rear&&front.next!=null){//直到找到最尾端节点的前一个节点
                front=front.next;
                tempNode=front;
            }
            front=startNode;
            rear=tempNode;
            if((front.next==null)||(rear.next==null)){
                front=null;
                rear=null;
            }
            return value;
        }else{
            return  -1;
        }


    }


}

public class BidirectionalQueues {
    public static void main(String[] args) {
        LinkedListQueue queue=new LinkedListQueue();
        int temp;
        System.out.println("以链表实现双向队列");
        System.out.println("=============================");
        System.out.println("在队列前端加入第1个数据，次数据为1");
        queue.enqueue(1);
        System.out.println("在队列前端加入第1个数据，次数据为2");
        queue.enqueue(2);
        System.out.println("在队列前端加入第1个数据，次数据为3");
        queue.enqueue(3);
        System.out.println("在队列前端加入第1个数据，次数据为4");
        queue.enqueue(4);
        System.out.println("在队列前端加入第1个数据，次数据为5");
        queue.enqueue(5);
        System.out.println("===============================");
        temp=queue.dequeue(1);
        System.out.println("前:"+temp);
        temp=queue.dequeue(2);
        System.out.println("后:"+temp);
        temp=queue.dequeue(1);
        System.out.println("前:"+temp);
        temp=queue.dequeue(2);
        System.out.println("后:"+temp);
        temp=queue.dequeue(1);
        System.out.println("前:"+temp);
    }
}
