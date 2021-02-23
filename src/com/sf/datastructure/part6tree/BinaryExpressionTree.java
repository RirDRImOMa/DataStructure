package com.sf.datastructure.part6tree;

import java.util.Date;
import java.util.Vector;

/**
 * Created by 80002946 on 2018/2/2.
 */

public class BinaryExpressionTree {
    public static void main(String[] args) {
        //将二叉运算树以数组的方式声明
        //第一个表达式
        char[] information1={' ','+','*','6','3','9','5'};
        //第二个表达式
        char[] information2={' ','+','+','+','*','%','/','*','1','2','3','2','6','3','2','2'};

        ExpressionTree exp1=new ExpressionTree(information1,1);
        System.out.println("===二叉树数值运算范例1：===");
        System.out.println("==========================");
        System.out.println("===转换为中序表达式===：");
        exp1.inOrder(exp1.rootNode);
        System.out.println("\n===转换为前序表达式===：");
        exp1.preOrder(exp1.rootNode);
        System.out.println("\n===转换为后序表达式===：");
        exp1.postOrder(exp1.rootNode);

        //计算二叉树表达式的运算结果
        System.out.println("\n此二叉运算树，经过计算后所得到的结果值");
        System.out.println(exp1.answer(exp1.rootNode));
    }
}

/**
 * 二叉搜索树声明
 */
class BinarySearchTree{
    public TreeNode rootNode;
    public BinarySearchTree(){
        rootNode=null;
    }

    //构造函数:利用传入一个数组的参数来建立二叉树
    public  BinarySearchTree(int[] data){
        for (int a:data) {
            AddNode2Tree(a);
        }
    }

    //将指定的值加入到二叉树中适当的节点
    public void AddNode2Tree(int value){
        TreeNode currentNode =rootNode;
        if(rootNode==null){
            rootNode=new TreeNode(value);
            return;
        }

        //建立二叉树
        while(true){
            if(value<currentNode.value){//符合这个判断表示此节点在左子树
                if(currentNode.leftNode==null){
                    currentNode.leftNode=new TreeNode(value);
                    return;
                }else{
                    currentNode=currentNode.leftNode;
                }
            }else{ //符合这个判断表示这个节点在右子树
                if(currentNode.rightNode==null){
                    currentNode=new TreeNode(value);
                    return;
                }else{
                    currentNode=currentNode.rightNode;
                }
            }
        }
    }
}
/**
 *
 */
class ExpressionTree extends BinarySearchTree{
    //构造函数
    public ExpressionTree(char[] information,int index){
        //create方法可以将二叉树的数组表示法转换成链表表示法
        rootNode =create(information,index);
    }
    public TreeNode create(char[] sequence,int index){
        TreeNode tempNode;
        if(index>=sequence.length){ //作为递归调用的出口
            return null;
        }else{
            tempNode =new TreeNode((int)sequence[index]);
            //建立左子树
            tempNode.leftNode=create(sequence,2*index);
            //建立右子树
            tempNode.rightNode=create(sequence,2*index+1);
            return tempNode;
        }
    }

    /**
     * preOrder前序遍历
     * @param node
     */
    public void preOrder(TreeNode node){
        if(node!=null){
            System.out.print((char)node.value);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    /**
     *  中序遍历
     * @param node
     */
    public void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.leftNode);
            System.out.print((char)node.value);
            inOrder(node.rightNode);
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print((char)node.value);
        }
    }

    /**
     * 判断表达式如何运算的方法声明
     * @param oprator
     * @param num1
     * @param num2
     * @return
     */
    public int condition(char oprator,int num1,int num2){
        switch (oprator){
            case '*':return (num1*num2);
            case '/':return (num1/num2);
            case '+':return (num1+num2);
            case '-':return (num1-num2);
            case '%':return (num1%num2);
        }
        return -1;
    }

    /**
     * 传入根节点，用来计算此二叉运算树的值
     * @param node
     * @return
     */
    public int answer(TreeNode node){
        int firstnumber=0;
        int secondnumber=0;
        //递归调用的出口条件
        if(node.leftNode==null&&node.rightNode==null){
            //将节点的值转换为数值后返回
            return Character.getNumericValue((char)node.value);
        }else{
            firstnumber=answer(node.leftNode);
            secondnumber=answer(node.rightNode);
            return condition((char) node.value,firstnumber,secondnumber);
        }
    }
}
