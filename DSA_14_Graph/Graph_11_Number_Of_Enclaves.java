import java.util.*;
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class Graph_11_Number_Of_Enclaves {
    public static int countEnclaves(int[][] grid){
        int Row = grid.length;
        int Col = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[Row][Col];
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(i==0 || i==Row-1 || j==0 || j==Col-1){
                    if(grid[i][j]==1){
                        visited[i][j] = 1;
                        queue.offer(new Pair(i, j));
                    }
                }
            }
        }
        int[] moveRow = {-1, 0, 1, 0};
        int[] moveCol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            Pair curPair = queue.poll();
            int row = curPair.row;
            int col = curPair.col;
            for(int move=0;move<4;move++){
                int move_row = row + moveRow[move];
                int move_col = col + moveCol[move];
                if(move_row>=0 && move_row<Row 
                && move_col>=0 && move_col<Col && visited[move_row][move_col]==0 && 
                grid[move_row][move_col]==1){
                    queue.offer(new Pair(move_row,move_col));
                    visited[move_row][move_col] = 1;
                }
            }
        }

        // Count enclaves
        int countEnclaves = 0;
        for(int i=0;i<Row;i++) for(int j=0;j<Col;j++) countEnclaves += (grid[i][j]==1 && visited[i][j]==0) ? 1:  0;
        return countEnclaves;
    }
    public static void main(String[] args) {
        int[][] grid = 
        {{0, 0, 0, 1},
        {0, 1, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 1},
        {0, 1, 1, 0}};
        System.out.println("Number Of Enclaves In Given Graph : " + countEnclaves(grid));
    }
}
