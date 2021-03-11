package com.sf.datastructure.part8sorting;

/**
 * Created by 80002946 on 2018/4/2.
 * 传统的冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int i,j,temp;
        //原始数据
        int data[]={2,3,7,3,22,12,45};
        System.out.println("冒泡排序法：");
        System.out.println("原始数据为");
        for (i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
        for(i=data.length-1;i>0;i--){
            for (j=0;j<i;j++){
                //比较相邻两个数的大小，如果数大则交换
                if(data[j]>data[j+1]){
                    temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
            System.out.println("第"+(data.length-i)+"次排序的结果");
            for (j=0;j<data.length;j++){
                System.out.print(data[j]+" ");
            }
            System.out.println();
        }
        System.out.println("排序后的数据");
        for (i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
}
