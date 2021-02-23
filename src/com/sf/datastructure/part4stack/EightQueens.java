package com.sf.datastructure.part4stack;

import java.io.IOError;
import java.io.IOException;

/**
 * Created by 80002946 on 2018/1/1.
 * 八皇后问题
 *
 * 堆栈中第一个元素表示第一列,值表示皇后位置
 */


public class EightQueens {
    static int TRUE=1,FALSE=0,EIGHT=8;
    static int[] queen=new int[EIGHT];//存放八皇后的位置
    static int number=0;//计算共有多少组解
    EightQueens(){
        number=0;
    }
    //按Enter健继续
    public static void PressEnter(){
        char tChar;
        System.out.println("\n\n");
        try {
            tChar=(char) System.in.read();
        }catch (IOException e){

        }
    }
    //决定皇后存放的位置
    public static void decide_position(int value){
        int i=0;
        while (i<EIGHT){
            //判断受到攻击
            if(attack(i,value)!=1){
                queen[value]=i;
                if(value==7){
                    print_table();
                }else{
                    decide_position(value+1);
                }
            }
            i++;
        }
    }

    //判断在(row,col)上皇后是否遭受攻击
    public static int attack(int row,int col){
        int i=0,atk=FALSE;
        int offset_row=0,offset_col=0;
        while ((atk!=1)&&i<col){
            offset_col=Math.abs(i-col);
            offset_row=Math.abs(queen[i]-row);
            //判断两皇后是否在同一列或同一对角线上(一列一列的进行判断)
            if((queen[i]==row)||(offset_row==offset_col)){
                atk=TRUE;
            }
            i++;
        }
        return atk;
    }

    //输出所需要的结果
    public static void print_table(){
        number+=1;
        System.out.println();
        System.out.println("八皇后问题的第"+number+"组解\n\t");
        for (int i=0;i<EIGHT;i++){
            for (int j=0;j<EIGHT;j++){
                if(i==queen[j]){
                    System.out.print("<*>");
                }else {
                    System.out.print("<->");
                }
            }
            System.out.println("\t");
        }
        PressEnter();
    }

    public static void main(String[] args) {
        EightQueens.decide_position(0);
    }
}
