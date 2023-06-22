/*
Given an m x n 2D binary grid "grid" which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water. 
*/

import java.util.*;
class Pair{
    int row,col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}

public class Graph_04_Number_Of_Islands {

    public static void bfs(int row, int col, int[][] visited, int[][] grid){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row,col));
        visited[row][col] = 1;
        int Row = grid.length, Col = grid[0].length;

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            int row_current = current.row, col_current = current.col;
            for(int move1=-1;move1<=1;move1++){
                for(int move2=-1;move2<=1;move2++){
                    int move_row = row_current+move1, move_col = col_current+move2;
                    if(move_row>=0 && move_row<Row && move_col>=0 && move_col<Col && 
                    grid[move_row][move_col]==1 && visited[move_row][move_col]==0){
                        visited[move_row][move_col] = 1;
                        queue.offer(new Pair(move_row,move_col));
                    }
                }
            }
        }
    }
    // We can use dfs too

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,1,0,0,0},
                        {0,0,1,1,0,1,0}};
        int Row = grid.length, Col = grid[0].length;
        int[][] visited = new int[Row][Col];
        int count = 0;
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        System.out.println("The number of islands are : " + count);
    }
}
