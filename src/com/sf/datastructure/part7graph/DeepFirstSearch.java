package com.sf.datastructure.part7graph;

/**
 * Created by 80002946 on 2018/2/26.
 * 先深后广法
 */
public class DeepFirstSearch {
    public static int run[] = new int[9];
    public static GraphLink Head[] = new GraphLink[9];

    /**
     * 深度优先遍历子程序
     *
     * @param current
     */
    public static void dfs(int current) {
        run[current] = 1;
        System.out.print("[" + current + "]");
        while ((Head[current].first) != null) {
            if (run[Head[current].first.value] == 0) {//如果顶点尚未遍历,就进行dfs的递归调用
                dfs(Head[current].first.value);
            }
            Head[current].first = Head[current].first.next;
        }
    }

    public static void main(String[] args) {
        //图线边线数组声明
        int Data[][] = {{1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 4}, {4, 2}, {2, 5}, {5, 2}, {3, 6}, {6, 3}, {3, 7}, {7, 3}, {4, 5}, {5, 4}, {6, 7}, {7, 6}, {5, 8}, {8, 5}, {6, 8}, {8, 6}};
        int DataNum;
        int i, j;
        System.out.println("图形的连接表内容");//打印图形的连接表内容
        for (i = 1; i < 9; i++) {
            run[i] = 0;//设定所有的顶点没有遍历过
            Head[i] = new GraphLink();
            System.out.print("顶点" + i + "=>");
            for (j = 0; j < 20; j++) {  //20条边线
                if (Data[j][0] == i) { //如果起点和列表首相当
                    DataNum =Data[j][1];
                    Head[i].insert(DataNum);
                }
            }
            Head[i].print();
        }
        System.out.println("深度优先遍历顶点：");//打印深度优先遍历的顶点
        dfs(1);
        System.out.println("");
    }
}
