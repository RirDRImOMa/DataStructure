package com.sf.datastructure.part8sorting;

/**
 * Created by 80002946 on 2018/4/5.
 * 插入排序
 */
public class InsertionSort {
    int data[] =new int[]{22,3,4,1,33,45,11};

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.showData();
        insertionSort.insert();
    }

    void  showData(){
        for (int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    void  insert(){
        int temp;
        int j;
        for (int i=0;i<data.length;i++){
            temp=data[i];
            j=i-1;
            while (j>=0&&temp<data[j]){
                data[j+1]=data[j];
                j--;
            }
            data[j+1]=temp;
            System.out.println("第"+i+"次扫描：");
            showData();
        }
    }
}
