package com.sf.datastructure.part8sorting;

/**
 * Created by 80002946 on 2018/4/5.
 * 选择排序
 */
public class SelectionSort {
    int data[]=new int[]{2,5,3,66,44,33};

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.showData();
        selectionSort.select();
    }

    void  showData(){
        for (int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    void  select(){
        int temp;
        for (int i=0;i<data.length-1;i++){
            for (int j=i+1;j<data.length;j++){
                if(data[i]>data[j]){
                    temp=data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
            System.out.println("第"+i+"排序");
            showData();
        }
        System.out.println("排序结果");
        showData();
    }
}
