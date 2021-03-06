package com.sf.datastructure.part7graph;

/**
 * Created by 80002946 on 2018/3/20.
 * Dijkstra算法(单点对全部顶点的最短路径)
 */

/**
 * 图形相邻矩阵类声明
 */
class Adjacency{
    final int INFINITE=99999;
    public int[][] Graph_Matrix;

    /**
     * 构造函数
     * @param weight_path int[][]
     * @param number int
     */
    public Adjacency(int[][] weight_path,int number){
        int i,j;
        int start_point,end_point;
        Graph_Matrix=new int[number][number];
        for(i=1;i<number;i++){
            for (j=1;j<number;j++){
                if(i!=j){
                    Graph_Matrix[i][j]=INFINITE;
                }else{
                    Graph_Matrix[i][j]=0;
                }
            }
        }

        for (i=0;i<weight_path.length;i++){
            start_point=weight_path[i][0];
            end_point=weight_path[i][1];
            Graph_Matrix[start_point][end_point]=weight_path[i][2];
        }
    }

    /**
     * 显示图形的方法
     */
    public void printGraph_matrix(){
        for(int i=1;i<Graph_Matrix.length;i++){
            for (int j=1;j<Graph_Matrix[i].length;j++){
                if(Graph_Matrix[i][j]==INFINITE){
                    System.out.print(" x ");
                }else{
                    System.out.print(Graph_Matrix[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}

/**
 * Dijkstra算法类
 */
class Dijkstra extends Adjacency{
    private int[] cost;
    private int[] selected;
    /**
     * 构造函数
     *
     * @param weight_path int[][]
     * @param number      int
     */
    public Dijkstra(int[][] weight_path, int number) {
        super(weight_path, number);
        cost=new int[number];
        selected=new int[number];
        for (int i=0;i<number;i++){
            selected[i]=0;
        }
    }
    /**
     * 单点对全部顶点最短距离
     * @param source int
     */
    public void shortestPath(int source){
        int shortest_distance;
        int shortest_vertex=1;
        int i,j;
        for (i=0;i<Graph_Matrix.length;i++){
            cost[i]=Graph_Matrix[source][i];
        }
        selected[source]=1;
        cost[source]=0;
        for (i=1;i<Graph_Matrix.length-1;i++){
            shortest_distance=INFINITE;
            for (j=1;j<Graph_Matrix.length;j++){
                if(shortest_distance>cost[j]&&selected[j]==0){
                    shortest_vertex=j;
                    shortest_distance=cost[j];
                }
            }
            selected[shortest_vertex]=1;
            for (j=1;j<Graph_Matrix.length;j++){
                if(selected[j]==0&&cost[shortest_vertex]+Graph_Matrix[shortest_vertex][j]<cost[j]){
                    cost[j]=cost[shortest_vertex]+Graph_Matrix[shortest_vertex][j];
                }
            }
        }
        System.out.println("==================================");
        System.out.println("顶点1到各顶点最短距离的最终结果");
        System.out.println("==================================");
        for (j=1;j<Graph_Matrix.length;j++){
            System.out.println("顶点1到顶点"+j+"的最短距离="+cost[j]);
        }
    }
}

/**
 * 主类
 */
public class DijkstraTSPP {
    public static void main(String[] args) {
        int weight_path[][]={
                {1,2,10},{2,3,20},
                {2,4,25},{3,5,18},
                {4,5,22},{4,6,95},{5,6,77}
        };
        Dijkstra dijkstra=new Dijkstra(weight_path,7);
        System.out.println("=====================");
        System.out.println("次范例图形的相邻矩阵如下：");
        System.out.println("=======================");
        dijkstra.printGraph_matrix();
        dijkstra.shortestPath(1);
    }
}
