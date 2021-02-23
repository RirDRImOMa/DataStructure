package com.sf.datastructure.part2arry;

/**
 * 执行矩阵相加
 * Created by 80002946 on 2017/12/1.
 */
public class MatrixAdd {
    /**
     * 执行矩阵相加
     * @param arrA
     * @param arrB
     * @param arrC
     * @param dimX
     * @param dimY
     */
    public static void add(int arrA[][],int arrB[][],int arrC[][],int dimX,int dimY){
        if(dimX<=0||dimY<=0){
            System.out.println("矩阵维数必须大于0");
            return;
        }
        for (int i=1;i<=dimX;i++){
            for (int j=1;j<=dimY;j++){
                arrC[(i-1)][(j-1)]=arrA[(i-1)][(j-1)]+arrB[(i-1)][(j-1)];
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
    public static void main(String args[]){
        final int ROWS=3;
        final int COLS=3;
        int[][] A={{1,2,3},{4,5,6,},{7,8,9}};
        int[][] B={{4,5,6},{7,8,9},{10,11,12}};
        int[][] C=new int[ROWS][COLS];
        System.out.println("打印A矩阵的内容");
        traversalMatrix(A,ROWS,COLS);
        System.out.println("打印B矩阵的内容");
        traversalMatrix(B,ROWS,COLS);
        //执行矩阵相加
        add(A,B,C,ROWS,COLS);
        System.out.println("打印C矩阵的内容");
       traversalMatrix(C,ROWS,COLS);
    }
}
