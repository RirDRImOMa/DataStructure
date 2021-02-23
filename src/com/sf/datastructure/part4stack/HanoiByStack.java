package com.sf.datastructure.part4stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 80002946 on 2017/12/29.
 */
public class HanoiByStack {
    public static void main(String[] args) throws IOException {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入盘中的数量：");
        String line = buf.readLine();
        int i = Integer.parseInt(line);
        hanoi(i,1,2,3);
    }

    public static void hanoi(int n,int p1,int p2,int p3){
        if(n==1){
            System.out.println("盘子从"+p1+"移动到"+p3);
        }else {
            hanoi(n-1,p1,p3,p2);
            System.out.println("盘中从"+p1+"移动到"+p3);
            hanoi(n-1,p2,p1,p3);
        }
    }

}
