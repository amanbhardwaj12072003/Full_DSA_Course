import java.util.*;
public class DP_10_Min_Path_Sum {

    // Using Recursion 
    // Time Complexity : O(2^(m*n))
    // Space Complexity : O((m-n) + (n-1))
    public static int fun1(int row,int col,int[][] grid){
        // Base Case 
        if(row==0 && col==0) return grid[0][0];
        if(row<0 || col<0) return 100000000;  // Return a very big value 

        // Code 
        int move_left = grid[row][col] + fun1(row,col-1,grid);
        int move_up = grid[row][col] + fun1(row-1,col,grid);
        return Math.min(move_up,move_left);
    }

    // Memoization Code 
    public static int fun2(int row,int col,int[][] grid,int[][] dp){
        // Base Case 
        if(row==0 && col==0) return grid[0][0];
        if(row<0 || col<0) return 10000000;
        
        // Code 
        if(dp[row][col] != -1) return dp[row][col];
        int move_left = grid[row][col] + fun2(row,col-1,grid,dp);
        int move_up = grid[row][col] + fun2(row-1,col,grid,dp);
        return dp[row][col] = Math.min(move_left,move_up);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},
                        {4,5,4},
                        {7,5,9}};
        int row = grid.length;
        int col = grid[0].length;

        // Using Recursion 
        System.out.println("Minimum Path Sum : " + fun1(row-1,col-1,grid));

        // Using Memoization 
        int[][] dp = new int[row][col];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Minimum Path Sum : " + fun2(row-1,col-1,grid,dp));
    }
}
