package com.sf.datastructure.part6tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 80002946 on 2018/1/18.
 */
public class BinaryTreeByLink {
    public static void main(String[] args) throws IOException{
        /*System.out.println("tt_mvs_transfer_task_Monitor_trail".length());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println("odmses~transferbatchtotalmonitor~"+df.format(new Date()));
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());
        int i = cd.get(Calendar.HOUR_OF_DAY);
        System.out.println("当前小时为："+i);*/
        System.out.println("22".equals(null));
        int ArraySize =10;
        int tempdata;
        int[] content =new int[ArraySize];
        BufferedReader  keyin=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请连续输入"+ArraySize+"个数据");
        for (int i=0;i<ArraySize;i++){
            System.out.println("请输入第"+(i+1)+"");
            tempdata =Integer.parseInt(keyin.readLine());
            content[i]=tempdata;
        }
        new  BinaryTree(content);
        System.out.println("===以链表的方式建立二叉树,成功！===");
    }
}

/**
 * 二叉树节点声明
 */
class TreeNode{
    int value;
    TreeNode leftNode;
    TreeNode rightNode;
    public TreeNode(int value){
        this.value=value;
        this.leftNode=null;
        this.rightNode=null;
    }
}
/**
 * 二叉树类声明
 */
class BinaryTree{
    public TreeNode rootNode;//二叉树的根节点
    //构造函数 利用传入的一个数组建立二叉树
    public BinaryTree(int [] data){
        for(int i=0;i<data.length;i++){
            addNodeToTree(data[i]);
        }
    }

    private void addNodeToTree(int value) {
        if(rootNode==null){
            rootNode=new TreeNode(value);
            return;
        }
        TreeNode currentNode=rootNode;
        //建立二叉树
        while (true){
            if(value<currentNode.value){//在左子树
                if(currentNode.leftNode==null){
                    currentNode.leftNode=new TreeNode(value);
                    return;
                }else{
                    currentNode=currentNode.leftNode;
                }
            }else{//在右子树
                if(currentNode.rightNode==null){
                    currentNode.rightNode=new TreeNode(value);
                    return;
                }else{
                    currentNode=currentNode.rightNode;
                }
            }
        }
    }

    /**
     * 中序遍历
     * 左子树->树根->右子树
     * @param node
     */
    public void InOrder(TreeNode node){
        if(node!=null){
            InOrder(node.leftNode);
            System.out.print("["+node.value+"]");
            InOrder(node.rightNode);
        }
    }

    /**
     * 前序遍历
     * 树根->左子树->右子树
     * @param node
     */
    public void PreOrder(TreeNode node){
        if(node!=null){
            System.out.print("["+node.value+"]");
            PreOrder(node.leftNode);
            PreOrder(node.rightNode);
        }
    }

    /**
     * 后序遍历
     * 左子树->右子树->树根
     * @param node
     */
    public void PostOrder(TreeNode node){
        if(node!=null){
            PostOrder(node.leftNode);
            PostOrder(node.rightNode);
            System.out.print("["+node.value+"]");
        }
    }
}


