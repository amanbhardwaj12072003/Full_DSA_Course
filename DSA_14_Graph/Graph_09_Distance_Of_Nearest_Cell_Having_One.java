import java.util.*;
class Data{
    int row;
    int col;
    int distance;
    Data(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class Graph_09_Distance_Of_Nearest_Cell_Having_One {
    public static int[][] findDistance(int[][] grid){
        int row = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] visited = new int[row][col];
        Queue<Data> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    queue.offer(new Data(i,j,0));
                    visited[i][j] = 1;
                }else{
                    visited[i][j] = 0;
                }
            }
        }
        int[] move_row = {-1, 0, 1, 0};
        int[] move_col = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            Data curData = queue.poll();
            int curRow = curData.row;
            int curCol = curData.col;
            int curDistance = curData.distance;
            distance[curRow][curCol] = curDistance;
            for(int move=0;move<4;move++){
                int moveRow = curRow + move_row[move];
                int moveCol = curCol + move_col[move];
                if(moveRow>=0 && moveRow<row &&
                moveCol>=0 && moveCol<col &&
                visited[moveRow][moveCol]==0){
                    visited[moveRow][moveCol] = 1;
                    queue.offer(new Data(moveRow,moveCol,curDistance+1));
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {

        int[][] grid = {{0,1,1,0},
                        {1,1,0,0},
                        {0,0,1,1}};
        System.out.println("Distance Array : ");
        printArray(findDistance(grid));
    }

    // Function To Print 2-D Array 
    public static void printArray(int[][] arr){
        int row = arr.length , col = arr[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /*
        Input:grid ={{0,1,1,0},
                    {1,1,0,0},
                    {0,0,1,1}}
        Output: {{1,0,0,1},
                {0,0,1,1},
                {1,1,0,0}}
    */
}
