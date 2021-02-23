package com.sf.datastructure.part5queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Key;

/**
 * Created by 80002946 on 2018/1/10.
 */
public class QueueByAnnular {
    public static int front =-1,rear=-1,val;
    public static int queue[]=new int[5];

    public static void main(String[] args) throws Exception{
        String strM;
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        while (rear<5&&val!=-1){
            System.out.println("请输入一个值存入队列，要取出值请输入0.(结束输入-1)：");
            strM= keyin.readLine();
            val=Integer.valueOf(strM);
            if(val==0){
                if(front==rear){
                    System.out.println("[队列已经为空]");
                    break;
                }
                front++;
                if(front==5){
                    front=0; // 循环
                }
                System.out.println("取出队列值["+queue[front]+"]");
                queue[front]=0;
            }else if(val!=-1&&rear<5){
                if(rear+1==front||rear==4&&front<=0){
                    System.out.println("[队列已经满了]");
                    break;
                }
                rear++;
                if(rear==5){
                    rear=0;
                }
                queue[rear]=val;
            }
        }
        System.out.println("队列剩余数据：");
        if(front==rear){
            System.out.println("队列已经为空！");

        }else{
            while (front!=rear){
                front++;
                if(front==5){
                    front=0;
                }
                System.out.print("["+queue[front]+"]");
                queue[front]=0;
            }
        }
        System.out.println();
    }
}
