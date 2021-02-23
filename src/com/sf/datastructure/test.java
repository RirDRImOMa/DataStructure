package com.sf.datastructure;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 80002946 on 2018/3/7.
 */
public class test {
    @Test
    public void test1(){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(1521093335273l);
        Date date = cal.getTime();
        Date date1= cal.getTime();

        System.out.println(date);
        System.out.println(date1);
        cal.setTimeInMillis(2521093335273l);
        date=cal.getTime();
        System.out.println(date);
        System.out.println(date1);
    }


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int l1Size=getLinkSize(l1);
            int l2Size=getLinkSize(l2);

            ListNode l3=new ListNode(0);
            ListNode temp=l3;//保存链表位置
            ListNode temp1=l1;//保存链表头

            while(l1!=null&&l2!=null){
            /*
            while(true){
                if(l1.next==null){
                    break;
                }
                l1=l1.next;
                l2=l2.next;
            }
            */
                l3.next=new ListNode((l1.val+l2.val)/10);
                l1.val=(l1.val+l2.val+l3.val)%10;
                temp=l1;
                l1=l1.next;
                l2=l2.next;
                l3=l3.next;

                if((l1==null||l2==null)&&l3.val>0){
                    temp.next=new ListNode(l3.val);
                }

            }
            return temp1;
        }

        /*
        获取链表的长度
        */
        public int getLinkSize(ListNode l){
            int a=0;
            while(l.next!=null){
                a++;
                l=l.next;
            }
            return a;
        }

}

class ListNode {
        int val;
    ListNode next;
        ListNode(int x) { val = x; }
     }
