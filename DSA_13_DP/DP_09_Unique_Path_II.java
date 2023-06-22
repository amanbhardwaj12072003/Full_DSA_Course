import java.util.*;
public class DP_09_Unique_Path_II {

    // Recursive Code 
    // Time Complexity : O(2^(m*n))
    // Space Complxity : O((m-1) + (n-1))
    public static int fun1(int row , int col , int[][] grid){
        // Base Case 
        if(row >=0 && col >= 0 && grid[row][col] == -1) return 0; // Dead Cell 
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;

        // Code 
        int move_left = fun1(row,col-1,grid);
        int move_up = fun1(row-1,col,grid);
        return move_left + move_up;
    }

    // Memoization Code 
    // Time Complexity : O(m*n)
    // Space Complexity : O((m-1) + (n-1)) + O(m*n)
    public static int fun2(int row,int col,int[][] grid,int[][] dp){
        // Base Case
        if(row>=0 && col>=0 && grid[row][col]==-1) return 0;
        if(row==0 && col==0) return 1;
        if(row<0 || col<0) return 0;

        // Code 
        if(dp[row][col]!=-1) return dp[row][col];
        int move_left = fun2(row,col-1,grid,dp);
        int move_up = fun2(row-1,col,grid,dp);
        return dp[row][col] = move_left + move_up; 
    }

    // Tabulation Code 
    public static int fun3(int row,int col,int[][] grid){
        // Instantiate dp
        int[][] dp = new int[row+1][col+1];
        for(int i=0;i<row+1;i++){
            for(int j=0;j<col+1;j++){
                if(grid[i][j]==-1) dp[i][j] = 0;
                else if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int move_left = 0 , move_up = 0;
                    if(i>0) move_up = dp[i-1][j];
                    if(j>0) move_left = dp[i][j-1];
                    dp[i][j] = move_up + move_left;
                }
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},
                        {0,-1,0}, 
                        {0,0,0}};
        int row = grid.length;
        int col = grid[0].length;

        // Using Recursion 
        System.out.println("Unique Paths Not Passing Through A Dead Cell : " + fun1(row-1,col-1,grid));

        // Using Memoization 
        int[][] dp = new int[row][col];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Unique Paths Not Passing Through A Dead Cell : " + fun2(row-1,col-1,grid,dp));

        // Using Tabulation
        System.out.println("Unique Paths Not Passing Through A Dead Cell : " + fun3(row-1,col-1,grid));

    }
}
