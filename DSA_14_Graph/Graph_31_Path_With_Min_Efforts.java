import java.util.*;
class Tuple{
    int difference,row,col;
    Tuple(int difference,int row,int col){
        this.difference = difference;
        this.row = row;
        this.col = col;
    }
}
public class Graph_31_Path_With_Min_Efforts {

    public static int minEfforts(int[][] grid){
        int Row = grid.length, Col = grid[0].length;
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((edge1,edge2) -> edge1.difference-edge2.difference);
        int[][] Difference = new int[Row][Col];
        for(int row=0;row<Row;row++) for(int col=0;col<Col;col++) Difference[row][col] = (int)(1e9);
        // Starting Point (0,0) -> End Point (Row-1,Col-1)
        Difference[0][0] = 0;
        minHeap.offer(new Tuple(0,0,0));
        int[] moveRow = {-1,0,1,0};
        int[] moveCol = {0,1,0,-1};
        while(!minHeap.isEmpty()){
            Tuple curTuple = minHeap.poll();
            int curDifference = curTuple.difference;
            int curRow = curTuple.row;
            int curCol = curTuple.col;

            // End Point Check 
            if(curRow==Row-1 && curCol==Col-1) return curDifference;

            for(int move=0;move<4;move++){
                int move_row = curRow + moveRow[move];
                int move_col = curCol + moveCol[move];  
                if(move_row>=0 && move_row<Row && move_col>=0 && move_col<Col){
                    int newEffort = Math.max(curDifference,Math.abs(grid[move_row][move_col]-grid[curRow][curCol]));
                    if(newEffort<Difference[move_row][move_col]){
                        Difference[move_row][move_col] = newEffort;
                        minHeap.offer(new Tuple(newEffort,move_row,move_col));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
