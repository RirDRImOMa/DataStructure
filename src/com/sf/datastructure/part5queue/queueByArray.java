package com.sf.datastructure.part5queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by 80002946 on 2018/1/9.
 */
public class queueByArray {
    public static int front=-1,rear=-1,max=20;//rear后端 front前端
    public static int val;
    public static int queue[] =new int[max];

    public static void main(String[] args) throws Exception{
        String strM;
        int M=0;
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        while(rear<max-1&&M!=3){
            System.out.println("[1]存入一个数值[2]取出一个数值[3]结束");
            strM=keyin.readLine();
            M=Integer.parseInt(strM);
            switch (M){
                case 1:
                    System.out.println("\n[请输入数值]：");
                    strM=keyin.readLine();
                    val=Integer.parseInt(strM);
                    rear++;
                    queue[rear]=val;
                    break;
                case 2:
                    if(rear>front){
                        front++;
                        System.out.print("\n[取出数值为]：["+queue[front]+"]\n");
                        queue[front]=0;
                    }else{
                        System.out.print("\n[队列已经为空]\n");
                        break;
                    }
                    break;
                default:
                    System.out.println();
                    break;
            }
        }
        if(rear==max-1){
            System.out.println("[队列已经满了\n");
        }
        System.out.println("[目前队列中的数量为]：");
        if(front>=rear){
            System.out.println("没有[队列已经为空]");
        }else{
            while(rear>front){
                front++;
                System.out.print("["+queue[front]+"]");
            }
            System.out.println();
        }
    }
}
