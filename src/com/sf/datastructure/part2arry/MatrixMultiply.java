package com.sf.datastructure.part2arry;

import java.util.Scanner;

/**
 * 执行矩阵相乘
 * Created by 80002946 on 2017/12/1.
 */
public class MatrixMultiply {

    public static void main(String[] args) {
        int M,N,P;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入矩阵A的维数（M,N）:");
        System.out.println("请输入矩阵A的M:");
        M=sc.nextInt();
        System.out.println("请输入矩阵A的M:");
        N=sc.nextInt();
        int A[][]=new int[M][N];
        createMatrix(A,M,N);
        System.out.println("A矩阵----");
        traversalMatrix(A,M,N);
        System.out.println("请输入矩阵B的维数（N,P）:");
        System.out.println("请输入矩阵B的N:");
        N=sc.nextInt();
        System.out.println("请输入矩阵B的P:");
        P=sc.nextInt();
        int B[][]=new int[N][P];
        createMatrix(B,N,P);
        System.out.println("B矩阵----");
        traversalMatrix(B,N,P);

        System.out.println("C矩阵----");
        int C[][]=new int[M][P];
        multiply(A,B,C,M,N,P);
        traversalMatrix(C,M,P);
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
