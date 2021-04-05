package com.sf.datastructure.part9search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by 80002946 on 2018/4/29.
 * 插值查找法
 *
 * 插值算法的公式为
 * mid=low+((key-data[low])/(data[high]-data[low]))*(high-low)
 *
 */
public class InterpolationSearch {
    public static void main(String[] args) throws Exception{
        int i,j,val=1;
        int num;
        int data[]=new int[50];
        String strM;
        BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
        for (i=0;i<50;i++){
            data[i]=val;
            val+=(int)((Math.random()*100)%5+1);
        }

        while (true){
            num=0;
            System.out.println("请输入查找的键值(1-150),输入-1结束");
            strM=keyin.readLine();
            val=Integer.parseInt(strM);
            if(val==-1){
                break;
            }
            num = interpolation(data, val);
            if(num==-1){
                System.out.println("#########没有找到"+val+"#######");
            }else {
                System.out.println("在第"+(num+1)+"个位置找到["+data[num]+"]");
            }

        }
        System.out.println("数据内容：");
        for(i=0;i<data.length;i++){
            System.out.print("["+data[i]+"]");
            if(i%5==0){
                System.out.println();
            }
        }
    }

    public static int interpolation(int data[],int val){
        int low,mid,high;
        low=0;
        high=49;
        int tmp;
        System.out.println("查找处理中....");
        while (low<=high&&val!=-1){
            tmp=(int) (low+((float)(val-data[low])/(data[high]-data[low]))*(high-low));
            mid=low+tmp;
            if(mid>data.length||mid<-1){
                return -1;
            }else if(val<data[low]&&val<data[high]){
                return -1;
            }else if(val>data[low]&&val>data[high]){
                return -1;

            }
            if(val==data[mid]) {
                return mid;
            }else  if(val>data[mid]){
                System.out.println(val+"介于"+(mid+1)+"和"+(high+1)+"之间");
                high=mid+1;
            }else if(val<data[mid]){
                System.out.println(val+"介于"+(low+1)+"和"+(mid+1)+"之间");
                low=mid+1;
            }else {
                return -1;
            }
        }
        return -1;
    }
}
