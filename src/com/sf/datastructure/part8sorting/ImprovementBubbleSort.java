package com.sf.datastructure.part8sorting;

/**
 * Created by 80002946 on 2018/4/5.
 * 改良后的冒泡排序
 */
public class ImprovementBubbleSort {
    int data[] =new int[]{3,2,34,5,44,22};

    public static void main(String[] args) {
        ImprovementBubbleSort improvementBubbleSort = new ImprovementBubbleSort();
        improvementBubbleSort.showData(improvementBubbleSort.data,0);
        improvementBubbleSort.bubble(improvementBubbleSort.data);
    }

    public  void showData(int[] data,int flag){
        if(flag==0){
            System.out.println("数组的内容为：");
        }else {
            System.out.println("第"+flag+"次排序：");
        }
        for (int i=0;i<data.length;i++){
            System.out.print(data[i]);
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     * @param data
     */
    public void bubble(int[] data){
        int temp;
        for (int i=data.length-1;i>0;i--){
            boolean flag=true;
            for (int j=0;j<i;j++){
                if(data[j]>data[j+1]){
                    temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                    flag=false;
                }
            }
            if (flag){
                break;
            }
            //如果flag为true表示数组已经排好序，无需进行再次循环了
            showData(data,i);
        }
        showData(data,0);
    }
}
