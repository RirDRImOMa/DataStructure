package com.sf.datastructure.part9search;

import java.util.Random;

/**
 * Created by 80002946 on 2018/5/4.
 * 线性探测法
 */
public class LinearProbing {
    final static int INDEXBOX=10;//哈希表最大元素
    final static int MAXNUM=7;//最大数据个数
    public static void main(String[] args) {
        int i;
        int index[]=new int[INDEXBOX];
        int data[]=new int[MAXNUM];
        Random random=new Random();
        System.out.println("原始数组:");
        for (i=0;i<MAXNUM;i++) {
            data[i]=(Math.abs(random.nextInt(20)))+1;
        }
        //清除哈希表
        for (i=0;i<INDEXBOX;i++){
            index[i]=-1;
        }
        printData(data,MAXNUM);
        System.out.print("哈希表内容：");
        for (i=0;i<MAXNUM;i++){
            creatTable(data[i],index);
            System.out.print(" "+data[i]+"=>");
            printData(index,INDEXBOX);
        }
        System.out.println("完成哈希表：");
        printData(index,INDEXBOX);
    }

    public static void printData(int data[],int max){
        int i;
        System.out.println();
        for (i=0;i<max;i++){
            System.out.print("["+data[i]+"]");
        }

    }

    public static void creatTable(int num,int index[]){
        int tmp;
        tmp=num%INDEXBOX;//哈希函数=数据%INDEXBOX
        while (true){
            if(index[tmp]==-1){ //如果相应的位置为空
                index[tmp]=num;//直接存入数据
                break;
            }else {
                tmp=(tmp+1)%INDEXBOX;//否则往后找
            }
        }
    }
}
