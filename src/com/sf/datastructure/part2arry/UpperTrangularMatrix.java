package com.sf.datastructure.part2arry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 稀疏矩阵
 * Created by 80002946 on 2017/12/5.
 */
public class UpperTrangularMatrix {

    public static void main(String[] args) {
        int M;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入矩阵的维数:");
        System.out.println("请输入行列数M:");
        M=sc.nextInt();
        int A[][]=new int[M][M];
        int arr[]=new int[M*(M+1)/2];
        //创建上三角矩阵
        createUpperTrangularMatrix(A,arr);
        //打印A矩阵
        traversalMatrix(A,M,M);

        //获取值
        System.out.println(Arrays.toString(arr));

        //根据索引获取
        System.out.println("根据索引获取");
        for (int i=0;i<M;i++){
            for (int j=i;j<M;j++){
                System.out.print(getValue(i, j, arr)+"  ");
            }
        }
    }

    /**
     * 根据一维数组获取矩阵中的值
     * @param i 行
     * @param j 列
     * @param arr 数组
     * @return
     */
    public static int getValue(int i,int j,int[] arr){
        int length = arr.length;

        //根据数组反推行数
        int a=1;
        int b=length;
        while (b>a){
            b=b-a;
            a++;
        }
        return arr[b*i-i*(i+1)/2+j];
    }

    /**
     * 随机创建上三角矩阵
     * @param A
     * @return
     */
    private static void createUpperTrangularMatrix(int[][] A,int [] arr) {
        int rows=A.length;
        int cols=A[0].length;
        int temp=0;
        for (int i=0;i<rows;i++){
            for (int j=i;j<cols;j++){
                int n = (int) (Math.random() * 100);
                A[i][j]=n;
                arr[temp++]=n;
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
