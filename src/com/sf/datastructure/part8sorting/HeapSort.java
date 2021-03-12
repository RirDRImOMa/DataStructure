package com.sf.datastructure.part8sorting;

import java.util.Random;

/**
 * Created by 80002946 on 2018/4/6.
 * 堆排序(快得不行)
 */
public class HeapSort {

    public static void main(String[] args) {
        //数组头舍弃不要 数组length为9,实际有效长度为8
        int data[]=new int[1001];
        HeapSort heapSort = new HeapSort();
        heapSort.inputArr(data);
        heapSort.heap(data,data.length);
        System.out.println("排序结果：");
        heapSort.showData(data);
    }

    void inputArr(int data[]){
        //以随机数输入
        Random rand=new Random();
        for (int i=1;i<data.length;i++){
            data[i]=Math.abs(rand.nextInt(999))+1;
        }
    }

    void  showData(int data[]){
        for (int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    void  heap(int data[],int size){
        int tmp;
        for(int i=(size/2);i>0;i--){ //建立堆积树
            adHeap(data,i,size-1);
        }
        System.out.println("原始数组内容：");
        showData(data);
        for (int i=size-2;i>0;i--){  //堆积排序  数组头舍弃
            //头尾节点互换
            tmp=data[i+1];
            data[i+1]=data[1];
            data[1]=tmp;
            adHeap(data,1,i);
            System.out.println("处理过程"+i);
            showData(data);
        }
    }

    void adHeap(int data[],int i,int size){
        int j,tmp,post;
        j=2*i;
        tmp=data[i];
        post=0;
        while (j<size&&post==0){
            if(j<size){
                if(data[j]<data[j+1]){
                   if(data[j]<data[j+1]){ //找出最大的节点
                       j++;
                   }
                }
            }
            if(tmp>=data[j]){ //若树根比较大，结束比较进程
                post=1;
            }else{
                data[j/2]=data[j]; //若树根比较小则继续比较
                j=2*j;
            }
        }
        data[j/2]=tmp; //指定树根为父节点
    }
}
