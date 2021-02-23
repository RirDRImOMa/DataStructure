package com.sf.datastructure.part4stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 利用数组模拟堆栈的类声明
 * Created by 80002946 on 2017/12/27.
 */
class StackByArray{
    private int[] stack;
    private int top;//堆栈的索引

    public StackByArray(int stack_size){
        stack=new int[stack_size];
        top=-1;
    }

    public boolean push(int data){
        if(top>=(stack.length-1)){
            System.out.println("堆栈已满！");
            return false;
        }
        stack[++top]=data;
        return true;
    }

    public boolean empty(){
        if(top<0){
            return true;
        }
        return false;
    }

    public int pop(){
        if (empty()){
            return -1;
        }
        return stack[top--];
    }
}

public class ArrayByStack {
    public static void main(String[] args) throws IOException{
        BufferedReader buf;
        int value;
        StackByArray stack=new StackByArray(10);
        buf =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请依次输入10个数据！");
        for (int i=0;i<11;i++){
            value=Integer.parseInt(buf.readLine());
            boolean push = stack.push(value);
            System.out.println(push);
        }
        System.out.println("============================");
        while (!stack.empty()){
            System.out.println("弹栈的顺序为："+stack.pop());
        }

    }
}
