import java.util.*;
public class DP_13_Cherry_Pickup_II {

    // Recursive Code 
    // Time Complexity : O(3^n x 3^m)....Exponential 
    // Space Complexity : O(n)
    public static int fun1(int i , int j1 , int j2 , int[][] grid){
        // Base Case 
        int row = grid.length , col = grid[0].length;
        if(j1<0 || j1>=col || j2<0 || j2>=col) return -10000000;
        if(i == row-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        // Code 
        int maximum = 0;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                if(j1==j2) maximum = Math.max(maximum , grid[i][j1] + fun1(i+1,j1+dj1,j2+dj2,grid));
                else maximum = Math.max(maximum , grid[i][j1] + grid[i][j2] + fun1(i+1,j1+dj1,j2+dj2,grid));
                
            }
        }
        return maximum;
    }

    // Memoization 
    // Time Complexity : O(9 x n x m x m)
    // Space Complexity : O(n x m x m) + O(n)
    public static int fun2(int i , int j1 , int j2 , int[][] grid , int[][][] DP_3D){
        // Base Case 
        int row = grid.length , col = grid[0].length;
        if(j1<0 || j1>=col || j2<0 || j2>=col) return -1000000;
        if(i == row-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        // DP Step
        if(DP_3D[i][j1][j2] != -1) return DP_3D[i][j1][j2];

        // Code 
        int maximum = 0;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                if(j1 == j2) maximum = Math.max(maximum, grid[i][j1]+ fun2(i+1,j1+dj1,j2+dj2,grid,DP_3D)); 
                else maximum = Math.max(maximum, grid[i][j1] + grid[i][j2] +fun2(i+1, j1+dj1, j2+dj2, grid, DP_3D));
            }
        }
        return DP_3D[i][j1][j2] = maximum;
    }

    // Tabulation 
    public static int fun3(int[][] grid){
        // Instantiate DP
        int row = grid.length , col = grid[0].length;
        int[][][] dp = new int[row][col][col];

        // Base Tabulation 
        for(int j1=0;j1<col;j1++){
            for(int j2=0;j2<col;j2++){
                if(j1 == j2) dp[row-1][j1][j2] = grid[row-1][j1];
                else dp[row-1][j1][j2] = grid[row-1][j1] + grid[row-1][j2];
            }
        }

        // Tabulations 
        for(int i=row-2;i>=0;i--){
            for(int j1=0;j1<col;j1++){
                for(int j2=0;j2<col;j2++){
                    int maximum = 0;
                    for(int dj1=-1;dj1<=+1;dj1++){
                        for(int dj2=-1;dj2<=+1;dj2++){
                            int value = -1000000;
                            if(j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<col && j2+dj2>=0 && j2+dj2<col) value += dp[i+1][j1+dj1][j2+dj2];
                            else value = -10000000;
                            maximum = Math.max(maximum, value); 
                        }
                    }
                    dp[i][j1][j2]= maximum;
                }
            }
        }
        return dp[0][0][col-1];
    }

    // Space Optimization In Tabulations 
    public static int fun4(int[][] grid){
        // Instantiate a 2D DP
        int row = grid.length , col = grid[0].length;
        int[][] front = new int[col][col];
        int[][] curr = new int[col][col];

        // Base Tabulation 
        for(int j1=0;j1<col;j1++){
            for(int j2=0;j2<col;j2++){
                if(j1 == j2) front[j1][j2] = grid[row-1][j1];
                else front[j1][j2] = grid[row-1][j1] + grid[row-1][j2];
            }
        }

        // Tabulations 
        for(int i=row-2;i>=0;i--){
            for(int j1=0;j1<col;j1++){
                for(int j2=0;j2<col;j2++){
                    int maximum = 0;
                    for(int dj1=-1;dj1<=+1;dj1++){
                        for(int dj2=-1;dj2<=+1;dj2++){
                            int value = -1000000;
                            if(j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<col && j2+dj2>=0 && j2+dj2<col) value += front[j1+dj1][j2+dj2];
                            else value = -10000000;
                            maximum = Math.max(maximum, value); 
                        }
                    }
                    curr[j1][j2]= maximum;
                }
            }
            for(int x1=0;x1<col;x1++) for(int y1=0;y1<col;y1++) front[x1][y1] = curr[x1][y1];
        }
        return front[0][col-1];

    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 3, 1, 2},
            {3, 4, 2, 2},
            {5, 6, 3, 5},
        };
        int row = grid.length;
        int col = grid[0].length;

        // Using Recursion 
        System.out.println("Maximum Path Sum : " + fun1(0,0,col-1,grid));

        // Using Memoization 
        int[][][] DP_3D = new int[row][col][col];

        // Arrays.stream(DP_3D).forEach(a -> Arrays.fill(a,-1)); ... This will throw error 
        Arrays.stream(DP_3D).flatMap(twoDArray -> Arrays.stream(twoDArray)).forEach(a->Arrays.fill(a,-1));;

        System.out.println("Maximum Path Sum : " + fun2(0,0,col-1,grid,DP_3D));

        // Using Tabulation 
        System.out.println("Maximum Path Sum : " + fun3(grid));

        // Using Space Optimization In Tabulation 
        System.out.println("Maximum Path Sum : " + fun4(grid));
    }
}
