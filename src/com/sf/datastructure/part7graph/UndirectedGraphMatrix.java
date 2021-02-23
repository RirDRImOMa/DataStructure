package com.sf.datastructure.part7graph;

/**
 * Created by 80002946 on 2018/2/13.
 * 无向图形矩阵(有向图)
 */
public class UndirectedGraphMatrix {
    public static void main(String[] args) {
        int[][] data={{1,2},{2,1},{1,5},{5,1},
                {2,3},{3,2},{2,4},{4,2},{3,4},{4,3},{3,5},{5,3}
                ,{4,5},{5,4}};
        //声明矩阵
        int arr[][]=new int[6][6];
        int i,j,k,tmpi,tmpj;
        for (i=0;i<arr.length;i++){
            for (j=0;j<arr[0].length;j++){
                arr[i][j]=0;
            }
        }
        for (i=0;i<data.length;i++){
            for (j=0;j<arr.length;j++){
                for (k=0;k<arr[0].length;k++){
                    tmpi=data[i][0];//tmpi为起始顶点
                    tmpj=data[i][1];//tmpj为起始终点
                    arr[tmpi][tmpj]=1;//有边的点填入1
                }
            }
        }
        System.out.println("无向图矩阵：\n");
        for (i=1;i<6;i++){
            for (j=1;j<6;j++){
                System.out.print("["+arr[i][j]+"]");
            }
            System.out.println();
        }
    }
}
