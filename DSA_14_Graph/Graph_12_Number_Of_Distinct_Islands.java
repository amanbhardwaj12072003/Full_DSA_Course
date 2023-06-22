import java.util.*;
class Pair{
    int row, col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class Graph_12_Number_Of_Distinct_Islands {
    public static void dfs(int row,int col,int[][]visited,int[][] grid,List<String> store,int row0,int col0){
        visited[row][col] = 1;
        store.add(toString(row-row0,col-col0));
        int Row = grid.length, Col = grid[0].length;
        int[] moveRow = {-1, 0, 1, 0};
        int[] moveCol = {0, 1, 0, -1};
        for(int move=0;move<4;move++){
            int move_row = row + moveRow[move];
            int move_col = col + moveCol[move];
            if(move_row>=0 && move_row<Row &&
            move_col>=0 && move_col<Col &&
            visited[move_row][move_col]==0 && 
            grid[move_row][move_col]==1){
                dfs(move_row, move_col, visited, grid, store, row0, col0);
            }
        }
    }
    public static String toString(int val1, int val2){
        return (Integer.toString(val1) + " " + Integer.toString(val2));
    }
    public static int count(int[][] grid){
        int Row = grid.length;
        int Col = grid[0].length;
        int[][] visited = new int[Row][Col];
        HashSet<List<String>> set = new HashSet<>();
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    List<String> list = new ArrayList<>();
                    dfs(i, j, visited, grid, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        
    }
}
