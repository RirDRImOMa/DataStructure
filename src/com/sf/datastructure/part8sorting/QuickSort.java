package com.sf.datastructure.part8sorting;

import java.util.Random;

/**
 * Created by 80002946 on 2018/4/6.
 * 快速排序
 */
public class QuickSort {
    int process = 0;
    int data[]=new int[30];

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println("原始数据为：");
        quickSort.inputArr();
        quickSort.showData();
        quickSort.quick(quickSort.data,0,quickSort.data.length-1);
        System.out.println("排序结果为：");
        quickSort.showData();
    }
    void inputArr(){
        //以随机数输入
        Random rand=new Random();
        for (int i=0;i<data.length;i++){
            data[i]=Math.abs(rand.nextInt(99))+1;
        }
    }

    void  showData(){
        for (int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    void quick(int d[],int lf,int rg){
        int tmp;
        int lf_idx; //左
        int rf_idx; //右
        int t;
        if(lf<rg){
            lf_idx=lf+1;
            rf_idx=rg;
            //排序
            while (true){
                System.out.print("[处理过程"+(process++)+"]");
                for (t=0;t<d.length;t++){
                    System.out.print("["+d[t]+"]");
                }
                System.out.println();
                //向右找一个健值小于d[lf]者
                for (int i=lf+1;i<=rg;i++){
                    if(d[i]>=d[lf]){
                        lf_idx=i;
                        break;
                    }
                    lf_idx++;
                }

                //向左找一个键值大于d[rf]者
                for (int j=rg;j>=lf+1;j--){
                    if(d[j]<=d[lf]){
                        rf_idx=j;
                        break;
                    }
                    rf_idx--;
                }
                //交换
                if(lf_idx<rf_idx){
                    tmp=d[lf_idx];
                    d[lf_idx]=d[rf_idx];
                    d[rf_idx]=tmp;
                }else{
                    break;
                }
            }
            //整理
            if(lf_idx>=rf_idx){
                //若lf_idx大于等于rg_idx,则将的d[lf]的d[rg_idx]互换
                tmp=d[lf];
                d[lf]=d[rf_idx];
                d[rf_idx]=tmp;
                //以rf_idx作为基准点分成左右两半
                quick(d,lf,rf_idx-1);
                quick(d,rf_idx+1,rg);
            }
        }
    }
}
