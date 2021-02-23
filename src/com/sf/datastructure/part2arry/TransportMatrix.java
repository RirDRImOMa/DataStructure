package com.sf.datastructure.part2arry;

import java.util.Scanner;

/**
 * 执行矩阵转置
 * Created by 80002946 on 2017/12/1.
 */
public class TransportMatrix {

    public static void main(String[] args) {
        int M,N;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入矩阵的维数（M,N）:");
        System.out.println("请输入维度的M:");
        M=sc.nextInt();
        System.out.println("请输入唯度的M:");
        N=sc.nextInt();
        int A[][]=new int[M][N];
        int B[][]=new int[N][M];
        createMatrix(A,M,N);
        System.out.println("A矩阵----");
        traversalMatrix(A,M,N);


        //进行矩阵转置的动作
       for (int i=0;i<N;i++){
           for (int j=0;j<M;j++){
                B[i][j]=A[j][i];
           }
       }
        System.out.println("B矩阵");
        traversalMatrix(B,N,M);

    }

    /**
     * 创建二位数组(矩阵)
     * @param A
     * @param M
     * @param N
     */
    public static void createMatrix(int A[][],int M,int N){
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                A[i][j]= (int) (Math.random()*100);
            }
        }
    }

    /**
     * 矩阵相加
     * @param arrA
     * @param arrB
     * @param arrC
     * @param M
     * @param N
     * @param P
     */
    public static void multiply(int arrA[][],int arrB[][],int arrC[][],int M,int N,int P){
        if(M<=0||N<=0||P<=0){
            System.out.println("错误：维数M,N,P必须大于0");
            return;
        }
        for (int i=0;i<M;i++){
            for (int j=0;j<P;j++){
                for (int k=0;k<N;k++){
                    arrC[i][j]=arrA[i][k]*arrB[k][j];
                }
            }
        }
    }
    /**
     * 遍历矩阵
     * @param
     */
    public static void traversalMatrix(int arr[][],int rows,int cols){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
