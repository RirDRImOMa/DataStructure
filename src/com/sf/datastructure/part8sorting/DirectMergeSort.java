package com.sf.datastructure.part8sorting;

import java.io.*;

/**
 * Created by 80002946 on 2018/4/7.
 * 直接合并排序法
 */
public class DirectMergeSort {
    public static void main(String[] args) throws Exception{
        String filep= "D:\\workspace\\DataStructure\\src\\com\\sf\\datastructure\\part8sorting\\data.txt";
        String filep1= "D:\\workspace\\DataStructure\\src\\com\\sf\\datastructure\\part8sorting\\data1.txt";
        String filep2= "D:\\workspace\\DataStructure\\src\\com\\sf\\datastructure\\part8sorting\\data2.txt";

        File fp=new File(filep);
        File fp1=new File(filep1);
        File fp2=new File(filep2);
        BufferedReader pfile=new BufferedReader(new FileReader(fp));
        BufferedReader pfile1=new BufferedReader(new FileReader(fp1));
        BufferedReader pfile2=new BufferedReader(new FileReader(fp2));

        if(!fp.exists()){
            System.out.println("开启主文件失败");
        }else if(!fp1.exists()){
            System.out.println("开启文件1失败");
        }else if(!fp2.exists()){
            System.out.println("开启文件2失败");
        }else{
            System.out.println("数据排序中...");
            DirectMergeSort.merge(fp,fp1,fp2);
            System.out.println("数据处理完成!");
        }

        System.out.println("data1.txt数据内容为：");
        DirectMergeSort.print(pfile1);
        System.out.println("data2.txt数据内容为：");
        DirectMergeSort.print(pfile2);
        System.out.println("data.txt数据内容为：");
        DirectMergeSort.print(pfile);

        pfile.close();
        pfile1.close();
        pfile2.close();

    }

   public static void merge(File p,File p1,File p2) throws Exception{
        char str1,str2;
        int n1,n2;//声明变量n1,n2暂存数据文件data1及data2内元素值
        BufferedWriter pfile=new BufferedWriter(new FileWriter(p));
        BufferedReader pfile1=new BufferedReader(new FileReader(p1));
        BufferedReader pfile2=new BufferedReader(new FileReader(p2));

        n1=pfile1.read();
        n2=pfile2.read();
        while (n1!=-1&&n2!=-1){
            if(n1<n2){
                str1= (char) n1;
                pfile.write(str1);//如果n1比较小则把n1存入fp内
                n1=pfile1.read();//接着读下一个n1的数据
            }else{
                str2= (char) n2;
                pfile.write(str2);//如果n2比较小，则把n2存到fp里面
                n2=pfile2.read();//接着读下一个n2数据
            }
        }

        while (n2!=-1){
            str2= (char) n2;
            pfile.write(str2);
            n2=pfile2.read();
        }
        while (n1!=-1){
            str1= (char) n1;
            pfile.write(str1);
            n1=pfile2.read();
        }
        pfile.close();
        pfile1.close();
        pfile2.close();

    }

    public static void print(BufferedReader pfile) throws Exception{
        char str;
        int str1;
        while(true){
            str1=pfile.read();
            str= (char) str1;
            if(str1==-1){
                break;
            }
            System.out.print("["+str+"]");
        }
    }
}
