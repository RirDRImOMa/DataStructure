package com.sf.datastructure.part7graph;

/**
 * Created by 80002946 on 2018/3/6.
 * Kruskal算法实现最小生产树
 */
public class KruskalMST {
    public static int VERTS=6;
    public static int v[]=new int[VERTS+1];
    public static MSTNode newList=new MSTNode();
    public static int findMincost(){
        int minval=100;
        int retptr=0;
        int a=0;
        while(newList.next[a]!=-1){
            if (newList.val[a]<minval && newList.find[a]==0) {
                minval=newList.val[a];
                retptr=a;
            }
            a++;
        }
        newList.find[retptr]=1;
        return retptr;
    }

    public static void mintree(){
        int i,result=0;
        int mceptr;
        int a=0;
        for (i=0;i<VERTS;i++){
            v[i]=0;
        }
        while(newList.next[a]!=-1){
            mceptr=findMincost();
            v[newList.from[mceptr]]++;
            v[newList.to[mceptr]]++;
            if(v[newList.from[mceptr]]>1&&v[newList.to[mceptr]]>1){
                v[newList.from[mceptr]]--;
                v[newList.to[mceptr]]--;
                result=1;
            }else{
                result=0;
            }
            if(result==0){
                System.out.print("起始顶点["+newList.from[mceptr]+"] 终止顶点 [");
                System.out.print(newList.to[mceptr]+"] 路径长度 ["+newList.val[mceptr]+"]");
                System.out.println();
            }
            a++;
        }
    }

    public static void main(String[] args) {
        int data[][]=/*图形数组声明*/
                {{1,2,6},{1,6,12},{1,5,10},{2,3,3},{2,4,5},{2,6,8},{3,4,7},{4,6,11},{4,5,9},{5,6,16}};
        int dataNum;
        int fromNum;
        int toNum;
        int findNum;
        int header=0;
        int freeNode;
        int i,j;
        System.out.println("建立图形表：");
        /*打印图形的邻表内容*/
        for(i=0;i<10;i++){
            for(j=0;j<VERTS;j++){
                if(data[j][0]==j){
                    fromNum=data[i][0];
                    toNum=data[i][1];
                    dataNum=data[i][2];
                    findNum=0;
                    freeNode=newList.findFree();
                    newList.createTree(header,freeNode,dataNum,fromNum,toNum,findNum);
                }
            }
        }
        newList.printList(header);
        System.out.println("建立最小成本生成树");
        mintree();
    }
}

class MSTNode{
    int MaxLength=20;//定义链表的最大长度
    int from[] =new int[MaxLength];
    int to[]=new int[MaxLength];
    int find[]=new int[MaxLength];
    int val[]=new int[MaxLength];
    int next[]=new int[MaxLength];//链表的下一个节点位置

    public MSTNode(){//构造方法
        for(int i=0;i<MaxLength;i++){
            next[i]=-2;//-2表示未用的节点
        }
    }

    /**
     * 搜索可用节点
     */
    public int findFree(){
        int i;
        for (i=0;i<MaxLength;i++){
            if(next[i]==-2){
                break;
            }
        }
        return i;
    }

    /**
     * 建立链表
     */
    public void createTree(int header,int freeNode,int dataNum,int fromNum,int toNum,int findNum){
        int pointer;//现在的节点位置
        if(header==freeNode){//新的链表
            val[header]=dataNum;
            from[header]=fromNum;
            find[header]=findNum;
            to[header]=toNum;
            next[header]=-1;
        }else{
            pointer=header;//现在的节点的位置，-1表示空节点
            val[freeNode]=dataNum;//设定数据的编号
            from[freeNode]=fromNum;
            find[freeNode]=findNum;
            to[freeNode]=toNum;
            //设定数据名称
            next[freeNode]=-1;//下个节点的位置，-1表示空节点
            //寻找链表尾端
            while(next[pointer]!=-1){
                pointer=next[pointer];
                //将新节点串连在原表尾端
                next[pointer]=freeNode;
            }
        }
    }

    /**
     * 打印链表数据
     */
    public void printList(int header){
        int pointer;
        pointer=header;
        while (pointer!=-1){
            System.out.print("起始顶点["+from[pointer]+"] 终止顶点 [");
            System.out.print(to[pointer]+"] 路径长度 ["+val[pointer]+"]");
            System.out.println();
            pointer=next[pointer];
        }
    }
}
