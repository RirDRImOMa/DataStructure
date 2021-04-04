package com.sf.datastructure.part8sorting;

import java.io.*;

/**
 * Created by 80002946 on 2018/4/13.
 * 完整合并排序法
 */
public class DirectMergeSortComplete {

    public static void main(String[] args) {
        String filep="datafile.txt";
        String filep1="sort1.txt";
        String filep2="sort2.txt";
        String filepa="sortdata.txt";

    }

    public static void showData(File p) throws Exception{
        char str;
        int str1;
        BufferedReader pfile=new BufferedReader(new FileReader(p));
        while(true){
            str1=pfile.read();
            str= (char) str1;
            if (str1==-1){
                break;
            }
            System.out.print("["+str+"]");
        }
        System.out.println();
    }

    public static void me(File p,File p1,File p2,File pa) throws Exception{
        char str1,str2;
        int n1=0,n2,n;
        BufferedReader pfile3=new BufferedReader(new FileReader(p));

        BufferedWriter pfile1=new BufferedWriter(new FileWriter(p1));
        BufferedWriter pfile2=new BufferedWriter(new FileWriter(p2));
        BufferedWriter pfilea=new BufferedWriter(new FileWriter(pa));

        while (true){
            n2=pfile3.read();
            if(n2==-1){
                break;
            }
            n1++;
        }
        pfile3.close();
        BufferedReader pfile=new BufferedReader(new FileReader(p));
        for (n2=0;n2<(n1/2);n2++){
            str1= (char) pfile.read();
            pfile1.write(str1);
        }
        pfile1.close();
        bubble(p1,n2);

        while (true){
            n=pfile.read();
            str2= (char) n;
            if (n==-1){
                break;
            }
            pfile2.write(str2);
        }
        pfile2.close();
        bubble(p2,n1/2);
        pfilea.close();
        merge(pa,p1,p2);
        pfile.close();
    }

    /**
     * 冒泡排序
     * @param p1
     * @param size
     * @throws Exception
     */
    public static void bubble(File p1,int size) throws Exception{
        char str1;
        int data[]=new int[100];
        int i,j,tmp,flag,ii;
        BufferedReader pfile=new BufferedReader(new FileReader(p1));
        for (i=0;i<size;i++){
            ii=pfile.read();
            if(ii==-1){
                break;
            }
            data[i]=ii;
        }
        pfile.close();

        BufferedWriter pfile1=new BufferedWriter(new FileWriter(p1));
        for (i=size;i>0;i--){
            flag=0;
            for (j=0;j<i;j++){
                if(data[j+1]<data[j]){
                    tmp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=tmp;
                    flag++;
                }
            }
            if(flag==0){
                break;
            }
        }
        for (i=1;i<=size;i++){
            str1= (char) data[1];
            pfile1.write(str1);
        }
       pfile1.close();
    }

    /**
     * 合并排序
     * @param p
     * @param p1
     * @param p2
     * @throws Exception
     */
    public static void merge(File p,File p1,File p2) throws Exception{
        char str1,str2;
        int n1,n2;
        BufferedWriter pfile=new BufferedWriter(new FileWriter(p));

        BufferedReader pfil1=new BufferedReader(new FileReader(p1));
        BufferedReader pfil2=new BufferedReader(new FileReader(p2));

        n1=pfil1.read();
        n2=pfil2.read();

        while (n1!=-1 && n2!=-1){  //判断是否到文件尾
            if(n1<=n2){
                str1= (char) n1;
                pfile.write(str1); //如果n1比较小这将n1存到fp内
                n1=pfil1.read();//接着读下一个数据

            }else {
                str2= (char) n2;
                pfile.write(str2);
                n2=pfil2.read();
            }
        }
        while (n2!=-1){
            str2= (char) n2;
            pfile.write(str2);
            n2=pfil2.read();
        }
        while (n1!=-1){
            str1= (char) n1;
            pfile.write(str1);
            n1=pfil2.read();
        }

        pfile.close();
        pfil1.close();
        pfil2.close();
    }
}
