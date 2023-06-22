/*

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

*/

import java.util.*;
class Data{
    int row, col, time;
    Data(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class Graph_06_Rotten_Oranges {
    public static int bfs(int[][] grid){
        int row = grid.length, col = grid[0].length, countFresh = 0;
        Queue<Data> queue = new LinkedList<>();
        int[][] visited = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.offer(new Data(i, j, 0));
                    visited[i][j] = 2;
                }
                if(grid[i][j] == 1) countFresh++;
            }
        }

        int time = 0;
        int[] move_row = {-1,0,1,0};
        int[] move_col = {0,1,0,-1};
        while(!queue.isEmpty()){
            Data currentData = queue.poll();
            int current_row = currentData.row;
            int current_col = currentData.col;
            int current_time = currentData.time;
            time = Math.max(time,current_time);
            for(int move=0;move<4;move++){
                int neighbour_row = current_row + move_row[move];
                int neighbour_col = current_col + move_col[move];
                if(neighbour_row>=0 && neighbour_row<row && 
                neighbour_col>=0 && neighbour_col<col &&
                visited[neighbour_row][neighbour_col]==0 &&
                grid[neighbour_row][neighbour_col]==1){
                    queue.offer(new Data(neighbour_row,neighbour_col,current_time+1));
                    visited[neighbour_row][neighbour_col] = 2;
                    countFresh--;
                }
            }
        }
        return (countFresh==0) ? time : -1;
    }
    // Time Complexity : O(row x col) + O(row x col x 4)
    // Space Complexity : O(row x col)

    public static void main(String[] args) {
        int[][] grid = {{0,1,2}
                        ,{0,1,2},
                        {2,1,1}};
        System.out.println("The Time Taken To Rotten All Oranges : " + bfs(grid));
    }
}
