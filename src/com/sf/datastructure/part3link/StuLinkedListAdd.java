package com.sf.datastructure.part3link;

import java.util.Random;

/**
 * 将两个学生的成绩表串联起来
 * Created by 80002946 on 2017/12/20.
 */
public class StuLinkedListAdd {
    public static void main(String[] args) {
        Random rand = new Random();
        StuLinkedList stuLinkedList1 = new StuLinkedList();
        StuLinkedList stuLinkedList2 = new StuLinkedList();
        int data[][]=new int[12][10];
        String name1[]=new String[]{"Allen","Scott","Marry","Jon","Mark","Ricky","Michael","Tom"};
        String name2[]=new String[]{"Lisa","Jasica","Hanson","Amy","Bob","Jack","John","Andy"};
        System.out.println("学号成绩学号成绩" +
                "\n");
        for (int i=0;i<8;i++){
            data[i][0]=i+1;
            data[i][1]=Math.abs(rand.nextInt(50))+50;
            stuLinkedList1.insert(data[i][0],name1[i],data[i][1]);
        }
        for (int i=0;i<2;i++){
            for (int j=0;j<4;j++){
                System.out.print("["+data[j+i*4][0]+"]["+data[j+i*4][i]+"]");
            }
            System.out.println();
        }
        for (int i=0;i<8;i++){
            data[i][0]=i+9;
            data[i][1]=Math.abs(rand.nextInt(50))+50;
            stuLinkedList2.insert(data[i][0],name2[i],data[i][1]);
        }
        for (int i=0;i<2;i++){
            for (int j=0;j<4;j++){
                System.out.print("["+data[j+i*4][0]+"]["+data[j+i*4][i]+"]");
            }
            System.out.println();
        }

        stuLinkedList1.concat(stuLinkedList2);
        stuLinkedList1.print();
    }
}

