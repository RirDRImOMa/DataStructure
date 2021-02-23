package com.sf.datastructure.part4stack;

/**
 * Created by 80002946 on 2018/1/1.
 * 老鼠走迷宫
 */
public class MazeGame {
    public static int ExitX=8;
    public static int ExitY=10;
    public static int[][] MAZE={
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,1,1,1,1,1,1,1},
            {1,1,1,0,1,1,0,0,0,0,1,1},
            {1,1,1,0,1,1,0,1,1,0,1,1},
            {1,1,1,0,0,0,0,1,1,0,1,1},
            {1,1,1,0,1,1,0,1,1,0,1,1},
            {1,1,0,0,0,1,0,0,1,0,1,1},
            {1,1,1,1,1,1,0,1,1,0,1,1},
            {1,1,0,0,0,0,0,0,1,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            };

    public static void main(String[] args) {
        int x,y;
        TraceRecord path=new TraceRecord();
        x=1;
        y=1;
        System.out.println("[迷宫的路径(0的部分)]\n");
        for (int i=0;i<10;i++){
            for (int j=0;j<12;j++){
                System.out.print(MAZE[i][j]);
            }
            System.out.println();
        }
        while (x<=ExitX&&y<=ExitY){
            MAZE[x][y]=2;//标记已经走过
            if(MAZE[x-1][y]==0){
                x-=1;
                path.insert(x,y);
            }
            else if(MAZE[x+1][y]==0){
                x+=1;
                path.insert(x,y);
            }
            else if(MAZE[x][y-1]==0){
                y-=1;
                path.insert(x,y);
            }else if(MAZE[x][y+1]==0){
                y+=1;
                path.insert(x,y);
            }else if(chkExit(x,y,ExitX,ExitY)==1){
                break;
            }else{
                //MAZE[x][y]=2;
                //回退
                path.delete();
                x=path.last.x;
                y=path.last.y;
            }
            System.out.println("x:"+x+"y:"+y);
        }
        System.out.println("[老鼠走过的路径(2的部分)]\n");
        for (int i=0;i<10;i++){
            for (int j=0;j<12;j++){
                System.out.print(MAZE[i][j]);
            }
            System.out.println();
        }
    }

    public static int chkExit(int x,int y,int ex,int ey){
        if(x==ex&&y==ey){
            if(MAZE[x-1][y]==1||MAZE[x+1][y]==1||MAZE[x][y-1]==1||MAZE[x][y+1]==2){
                return 1;
            }else if(MAZE[x-1][y]==1||MAZE[x+1][y]==1||MAZE[x][y-1]==2||MAZE[x][y+1]==1){
                return 1;
            }else if(MAZE[x-1][y]==1||MAZE[x+1][y]==2||MAZE[x][y-1]==1||MAZE[x][y+1]==1){
                return 1;
            }else if(MAZE[x-1][y]==2||MAZE[x+1][y]==1||MAZE[x][y-1]==1||MAZE[x][y+1]==1){
                return 1;
            }

        }
        return 0;
    }
}
