package com.sf.datastructure.part8sorting;

import java.util.Random;

/**
 * Created by 80002946 on 2018/4/6.
 * 基数排序法
 * 基数排序法由小到大排序
 */
public class RadixSort {

    int data[]=new int[100];
    int size=data.length;
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        radixSort.inputArr(radixSort.data);
        System.out.println("原数组为：");
        radixSort.showData(radixSort.data);
        radixSort.radix(radixSort.data);
        radixSort.showData(radixSort.data);
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

    void radix(int data[]){
        int i,j,k,n,m;
        for (n=1;n<=100;n=n*10){ //n为基数，由个位数开始排序

            //开始一轮排序

            //设定暂存数组 ,假设[0~9]位数
            int tmp[][]=new int[10][100];
            for (i=0;i<size;i++){
                m=(data[i]/n)%10;//m为n位的值  (关键)
                tmp[m][i]=data[i];//把data[i]暂时存在tmp中
            }
            k=0;

            for (i=0;i<10;i++){
                for (j=0;j<size;j++){
                    if(tmp[i][j]!=0){
                        //data暂存在tmp里的值放回data[]
                        data[k]=tmp[i][j];
                        k++;
                    }
                }
            }
            System.out.println("经过"+n+"位排序后：");
            showData(data);
        }
    }
}
