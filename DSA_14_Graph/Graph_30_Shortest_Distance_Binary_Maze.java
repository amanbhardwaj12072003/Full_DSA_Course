import java.util.*;
class Tuple{
    int distance,row,col;
    Tuple(int distance,int row,int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
public class Graph_30_Shortest_Distance_Binary_Maze {

    // We are using Dijkstra's algorithm but not using PQ as this will take log(N) extra time, instead of the fact that
    // we do not need minimim distance at every operation
    public static int minDistance(int[][] grid,int[] source,int[] target){
        // Edge Case 
        if(source[0]==target[0] && source[1]==target[0]) return 0;

        // Code 
        int Row = grid.length, Col = grid[0].length;
        Queue<Tuple> queue = new LinkedList<>();
        int[][] distance = new int[Row][Col];
        for(int row=0;row<Row;row++) for(int col=0;col<Col;col++) distance[row][col] = (int)(1e9);
        int source_row = source[0], source_col = source[1], target_row = target[0], target_col = target[1];
        distance[source_row][source_col] = 0;
        queue.offer(new Tuple(0, source_row, source_col));
        int[] moveRow = {-1,0,1,0};
        int[] moveCol = {0,1,0,-1};
        while(!queue.isEmpty()){
            Tuple curTuple = queue.poll();
            int curDistance = curTuple.distance;
            int curRow = curTuple.row;
            int curCol = curTuple.col;
            for(int move=0;move<4;move++){
                int move_row = curRow + moveRow[move];
                int move_col = curCol + moveCol[move];
                if(move_row>=0 && move_row<Row && move_col>=0 && move_col<Col &&
                grid[move_row][move_col]==1 && curDistance+1 < distance[move_row][move_col]){
                    distance[move_row][move_col] = curDistance+1;
                    if(move_row==target_row && move_col==target_col) return distance[move_row][move_col];
                    queue.offer(new Tuple(curDistance+1,move_row,move_col));
                }
            }
        }
        // If nothing possible 
        return -1; 
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1,0,0},
            {1,1,0},
            {1,1,0},
        };
        int[] source = {0,0}, target = {2,2};
        int ans = minDistance(grid,source,target);
        System.out.println(ans);
    }
}
