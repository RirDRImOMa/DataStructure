package com.sf.datastructure.part7graph;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 80002946 on 2018/2/26.
 * 先广后深发
 */
public class BreadthFirstSearch {
    @Test
    public void  test() throws Exception{
        long time = new Date().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time1 = formatter.parse("2018-03-02 15:00:00").getTime();
        long result=time-time1;
        double v = result / 3600000.0;
        DecimalFormat df = new DecimalFormat("#0.0");
        System.out.println(df.format(111.012));
        System.out.println(v);

        System.out.println();
    }

    public static int run[]=new int[9];//用来记录各个顶点是否遍历过
    public static GraphLink Head[]=new GraphLink[9];
    public final static int MAXSIZE=10;//定义队列的最大容量
    static int[] queue=new int[MAXSIZE];//队列数组的申明
    static int front=-1;//队列的前端
    static int rear=-1;//队列的后端

    /**
     * 队列数据的存入
     * @param value
     */
    public static void enqueue(int value){
        if(rear>=MAXSIZE){//空间已满
            return;
        }
        rear++;
        queue[rear]=value;
    }

    /**
     * 队列的取出
     */
    public static int dequeue(){
        if (front==rear){//队列中无数据
            return -1;
        }
        front++;
        return queue[front];
    }

    /**
     * 广度优先算法
     * @param current
     */
    public static void dfs(int current){
        Node tempnode;//临时的节点指针
        enqueue(current);//将第一个顶点存入队列
        run[current]=1;//将遍历过的顶点设定为1
        System.out.println("["+current+"]");//打印改遍历过的顶点
        while (front!=rear){//判断目前是否为空队列
            current=dequeue();//将顶点从队列中取出
            tempnode=Head[current].first;//先记录目前顶点的位置
            while(tempnode!=null){
                if(run[tempnode.value]==0){
                    enqueue(tempnode.value);
                    run[tempnode.value]=1;//记录已遍历过的顶点
                    System.out.println("["+tempnode.value+"]");
                }
                tempnode=tempnode.next;
            }
        }
    }

    public static void main(String[] args) {
        //图线边线数组声
        int Data[][] =
                {{1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 4}, {4, 2}, {2, 5}, {5, 2}, {3, 6}, {6, 3}, {3, 7}, {7, 3}, {4, 5}, {5, 4}, {6, 7}, {7, 6}, {5, 8}, {8, 5}, {6, 8}, {8, 6}};
        int DataNum;
        int i, j;
        System.out.println("图形的连接表内容");//打印图形的连接表内容
        for (i = 1; i < 9; i++) {
            run[i] = 0;//设定所有的顶点没有遍历过
            Head[i] = new GraphLink();
            System.out.print("顶点" + i + "=>");
            for (j = 0; j < 20; j++) {  //20条边线
                if (Data[j][0] == i) { //如果起点和列表首相当
                    DataNum = Data[j][1];
                    Head[i].insert(DataNum);
                }
            }
            Head[i].print();
        }
        System.out.println("深度优先遍历顶点：");//打印深度优先遍历的顶
         dfs(1);
        System.out.println("");
    }
}
