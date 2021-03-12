package com.sf.datastructure.part8sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by 80002946 on 2018/4/5.
 * 希尔排序
 */
public class ShellSort {
    int data[] =new int[8];

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.inputarr();
        shellSort.showData();
        shellSort.shell();
    }

    void inputarr(){
        for (int i=0;i<data.length;i++){
            System.out.print("请输入第"+(i+1)+"个元素");
            try {
                InputStreamReader isr=new InputStreamReader(System.in);
                BufferedReader br=new BufferedReader(isr);
                data[i]=Integer.parseInt(br.readLine());
            }catch (Exception e){
            }
        }
    }

    void showData(){
        for (int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
    }

    void  shell(){
        int i;//扫描次数
        int j;//定位比较的元素
        int k=1;//k打印次数
        int tmp;//tmp用来暂存数据
        int jmp;//时间间隔
        jmp=data.length/2;

        while (jmp!=0){
            for (i=jmp;i<data.length;i++){
                tmp = data[i];
                j=i-jmp;
                while(j>=0&&tmp<data[j]){
                    data[j+jmp]=data[j];
                    j=j-jmp;
                }
                data[jmp+j]=tmp;
            }

            System.out.println("第"+(k++)+"次排序");
            showData();
            jmp=jmp/2;//控制循环数
        }
    }
}
