package com.sf.datastructure.part6tree;

/**
 * Created by 80002946 on 2018/1/18.
 */
public class BinaryTreeByArray {
    public static void main(String[] args) {
        int i,level;
        int data[]={6,3,5,9,7,8,4,2};//原始数据
        int btree[]=new int[16];
        for(i=0;i<btree.length;i++){
            btree[i]=0;
        }
        //遍历数组
        System.out.println("原数组内容：\n");
        for(i=0;i<data.length;i++){
            System.out.print("["+data[i]+"]");
            for(level=1;btree[level]!=0;){/*比较树根及数组内的值*/
                /*如果数组内的值大于树根，则往右子数比较*/
                if(data[i]>btree[level]){
                    level=level*2+1;
                }else{
                    level=level*2;
                }
            }
                /*如果子树节点的值不为0，则再与数组内的值比较一次*/
            btree[level]=data[i];
        }
        System.out.println("\n二叉树内容：\n");
        for(i=1;i<btree.length;i++){
            System.out.print("["+btree[i]+"]");
        }
        System.out.println();
    }
}
