package com.sf.datastructure.part2arry;

import java.util.Scanner;

/**
 * 稀疏矩阵
 * Created by 80002946 on 2017/12/5.
 */
public class SparseMatrix {

    public static void main(String[] args) {
        int M,N;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入矩阵的维数（M,N）:");
        System.out.println("请输入行数M:");
        M=sc.nextInt();
        System.out.println("请输入行数M:");
        N=sc.nextInt();
        int A[][]=new int[M][N];
        //纪录矩阵中不为0的个数
       //创建稀疏矩阵
        int notzero = createSparseMatrix(A, M, N);
        //申明压缩矩阵
        int B[][]=new int[notzero+1][3];
        System.out.println("A矩阵----");
        traversalMatrix(A,M,N);
        /*开始压缩矩阵*/
        B[0][0]=M;
        B[0][1]=N;
        B[0][2]=notzero;
        int temp=1;
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if(A[i][j]!=0){
                    B[temp][0]=i;
                    B[temp][1]=j;
                    B[temp][2]=A[i][j];
                    temp++;
                }
            }
        }
        System.out.println("B矩阵稀疏矩阵");
        traversalMatrix(B,notzero+1,3);

    }

    /**
     * 创建稀疏矩阵,返回不为零的个数
     * @param A
     * @param M
     * @param N
     */
    public static int createSparseMatrix(int[][] A,int M,int N){
        int nz=0;
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                int temp= (int) (Math.random()*100);
                if(temp%3==0){
                    A[i][j]=temp;
                    nz++;
                }else{
                    A[i][j]=0;

                }
            }
        }
        return nz;
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
