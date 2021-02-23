package com.sf.datastructure.part6tree;

/**
 * Created by 80002946 on 2018/2/1.
 */

/*class TreeNode{
    int value;
    TreeNode leftNode;
    TreeNode rightNode;
    public TreeNode(int value){
        this.value=value;

    }
}*/
/*class BinaryTree{
    public TreeNode rootNode;
    public void addNode2Tree(int value){
        if(rootNode==null){
            rootNode=new TreeNode(value);
            return;
        }
        TreeNode  currentNode=rootNode;
        while (true){
            if(value<currentNode.value){
                if(currentNode.leftNode==null){
                    currentNode.leftNode=new TreeNode(value);
                    return;
                }else {
                    currentNode=currentNode.leftNode;
                }
            }else{
                if(currentNode.rightNode==null){
                    currentNode.rightNode=new TreeNode(value);
                    return;
                }else {
                    currentNode=currentNode.rightNode;
                }
            }
        }
    }
}*/

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        int i;
        int arr[]={7,4,1,5,16,8,11,12,15,9,2};
        BinaryTree tree=new BinaryTree(arr);

        System.out.println("原始数组的内容：");
        for (i =0;i<11;i++){
            System.out.print("["+arr[i]+"]");
        }
        System.out.println();
        System.out.println("中序遍历：\n");
        tree.InOrder(tree.rootNode);
        System.out.println("前序遍历：\n");
        tree.PreOrder(tree.rootNode);
        System.out.println("后序遍历：\n");
        tree.PostOrder(tree.rootNode);
    }

}

