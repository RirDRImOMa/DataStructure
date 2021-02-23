package com.sf.datastructure.part2arry;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 多项式的加法
 * 数组中的第一个元素表示多项式非零的个数
 * 只存多项式的系数和指数
 * Created by 80002946 on 2017/12/6.
 */
public class PolynomialOperation {

    public static void main(String[] args) {
        int Ploy1[]={4,1,2,3,4,0};
        int Ploy2[]={4,1,2,0,3,4};
        PrintPoly(Ploy1);
        PrintPoly(Ploy2);
        int[] Ploy3 = PloySum(Ploy1, Ploy2);
        PrintPoly(Ploy3);
    }

    /**
     * 打印多项式
     * @param Ployp
     */
    public static void PrintPoly(int Ployp[]){
        int MaxExp=Ployp[0];
        for (int i=1;i<Ployp.length;i++){
            if(Ployp[i]!=0){
                MaxExp--;
                if(MaxExp>0){
                    System.out.print(Ployp[i]+"X^"+(i)+"+");
                }else {
                    System.out.print(Ployp[i]);
                }
            }
        }
        System.out.println();
    }

    /**
     * 多项式相加
     * @param Ploy1
     * @param Ploy2
     * @return int[]
     */
    public static int[] PloySum(int Ploy1[],int Ploy2[]){
        //考虑到项式可能不一样
        int len1=Ploy1.length;
        int len2=Ploy2.length;
        int len;
        int difference;
        Boolean flag;
        int Result[];
        if(len1>len2){
            len=len1;
            difference=len1-len2;
            flag=true;
        }else{
            len=len2;
            difference=len2-len1;
            flag=false;
        }
        Result=new int[len];
        if(flag){
            for (int i=1;i<len;i++){
                if(i>=difference+1){
                    //等项相加
                    Result[i]=Ploy1[i]+Ploy2[i];
                }else{
                    Result[i]=Ploy1[i];
                }
            }
        }else{
            for (int i=1;i<len;i++){
                if(i>=difference+1){
                    //等项相加
                    Result[i]=Ploy2[i]+Ploy1[i];
                }else{
                    Result[i]=Ploy2[i];
                }
            }
        }
        //计算不为0的项数
        int num=0;
        for (int i=1;i<Result.length;i++){

            if(Result[i]>0){
                num++;
            }

        }
        Result[0]=num;
        System.out.println(Arrays.toString(Result));
        return Result;
    }
}
