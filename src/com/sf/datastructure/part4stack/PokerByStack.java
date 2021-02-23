package com.sf.datastructure.part4stack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 利用栈模拟 扑克洗牌和发牌过程
 * Created by 80002946 on 2017/12/27.
 */
public class PokerByStack {

    static int top =-1;

    public static void main(String[] args) {
        int card[]=new int[52];
        int stack[] =new int[52];
        int test;
        int style;
        char ascVal='H';
        ArrayList<Object> list = new ArrayList<>();
        for (int i=0;i<52;i++){
            card[i]=i;
            list.add(i);
        }

        Collections.shuffle(list);
        System.out.println("洗牌中...");
        int k=0;
        while(k<30){//切牌牌次数
            for (int i=0;i<52;i++){
                for (int j=i+1;j<52;j++){
                    if(Math.random()>0.5){
                        //洗牌
                        test=card[i];
                        card[i]=card[j];
                        card[j]=test;
                    }
                }
            }
            k++;
        }
        int n=0;
        while (n!=52){
            push(stack,52,card[n]);
            //push(stack,52,(int)list.get(n));
            n++;
        }
        System.out.println("逆时针开始发牌！");
        System.out.println("[显示各家的牌子]\n 东家  \t北家    西家\t    南家");
        System.out.println("=========================================");
        while (top>=0){
            style=stack[top]/13; //计算牌的花色
            switch (style){
                case 0:
                    ascVal='C';
                    break;
                case 1:
                    ascVal='D';
                    break;
                case 2:
                    ascVal='H';
                    break;
                case 3:
                    ascVal='S';
                    break;
            }
            System.out.print("["+ascVal+(stack[top]%13+1)+"]");
            System.out.print("\t");
            if(top%4==0){
                System.out.println();
            }
            top--;
        }
    }

    public static void push(int stack[],int MAX,int val){
            if(top>MAX-1){
                System.out.println("牌堆已满！");
            }else{
                stack[++top]=val;
            }
    }

    public static int pop(int stack[]){
            if (top<0){
                System.out.println("牌已经派完了！");
                return -1;
            }else{
                top--;
                return stack[top];
            }
    }
}
