package com.sf.datastructure.part9search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by 80002946 on 2018/4/29.
 * s顺序查找法
 *
 * 数据量大时，不适合使用顺序查找法，但如果预估所查询的数据在文件前端则可以减少查找时间
 */
public class SequentialSearch {
    public static void main(String[] args) throws Exception {
        String strM;
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        int data[]=new int[100];
        int i,j,find,val=0;
        for (i=0;i<80;i++)
            data[i]=((int)(Math.random()*150)%150+1);

        while (val!=-1){
            find=0;
            System.out.println("请输入查找健值(150),输入-1离开");
            strM=keyin.readLine();
            val=Integer.parseInt(strM);
            for(j=0;j<80;j++){
                if(data[j]==val){
                    System.out.println("在第"+(j+1)+"个位置找到键值["+data[j]+"]");
                    find++;
                }
            }
            if(find==0||val==-1){
                System.out.println("没有找到");
            }
        }
        System.out.println("数据的内容");
        for (i=0;i<80;i++){
            System.out.print("["+data[i]+"]");
            if(i%10==0){
                System.out.println();
            }
        }

    }
}
