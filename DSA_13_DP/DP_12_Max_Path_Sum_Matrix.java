import java.util.Arrays;

public class DP_12_Max_Path_Sum_Matrix {

    // Recursive Code 
    // Time Complexity : O(3^(row x col))
    // Space Complexity : O(col)
    public static int fun1(int row , int col , int[][] matrix){
        // Base Case 
        if(col<0 || col>=matrix[0].length) return -100000000;
        if(row == 0) return matrix[0][col];

        // Code 
        int move_left = matrix[row][col] + fun1(row-1,col-1,matrix);
        int move_up = matrix[row][col] + fun1(row-1,col,matrix);
        int move_right = matrix[row][col] + fun1(row-1,col+1,matrix);
        return Math.max(move_left,Math.max(move_up,move_right));
    }

    // Using Memoization 
    // Time Complexity : O(row x col)
    // Space Complexity : O(col) + O(row x col)
    public static int fun2(int row,int col,int[][] matrix,int[][] dp){
        // Base Case 
        if(col<0 || col>=matrix[0].length) return -100000000;
        if(row == 0) return matrix[0][col];

        // Code 
        if(dp[row][col] != -1) return dp[row][col];
        int move_left = matrix[row][col] + fun2(row-1, col-1, matrix, dp);
        int move_up = matrix[row][col] + fun2(row-1, col, matrix, dp);
        int move_right = matrix[row][col] + fun2(row-1, col+1, matrix, dp);
        return dp[row][col] = Math.max(move_left,Math.max(move_up,move_right));
    }

    // Using Tabulation 
    // Time Complexity : O(row x col)
    // Space Complexity : O(row x col)
    public static int fun3(int[][] matrix){
        // Instantiate DP
        int row = matrix.length , col = matrix[0].length;
        int[][] dp = new int[matrix.length][matrix[0].length];

        // Base Tabulations 
        for(int j=0;j<col;j++) dp[0][j] = matrix[0][j];

        // Tabulation 
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int move_left = -10000000 , move_right = -10000000;
                if(j-1>=0) move_left = matrix[i][j] + dp[i-1][j-1];
                int move_up = matrix[i][j] + dp[i-1][j];
                if(j+1<col) move_right = matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.max(move_left,Math.max(move_up,move_right));
            }
        }
        int max = Integer.MIN_VALUE;
        for(int j=0;j<col;j++){
            max = Math.max(max,dp[row-1][j]);
        }
        return max;
    }

    // Space Optimization In Tabulation 
    public static int fun4(int[][] matrix){
        // Instantite DPs
        int row = matrix.length , col = matrix[0].length;
        int[] prev = new int[col];
        int[] curr = new int[col];

        // Base Tabulations 
        for(int j=0;j<col;j++) prev[j] = matrix[0][j];

        // Tabulation 
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int move_left = -10000000 , move_right = -10000000;
                if(j-1>=0) move_left = matrix[i][j] + prev[j-1];
                int move_up = matrix[i][j] + prev[j];
                if(j+1<col) move_right = matrix[i][j] + prev[j+1];
                curr[j] = Math.max(move_left,Math.max(move_up,move_right));
            }

            // prev = curr ... This will give wrong output of 76

            // This is the proper way of copying one array into the other 
            for(int k=0;k<col;k++) prev[k] = curr[k];
        }
        int max = Integer.MIN_VALUE;
        for(int j=0;j<col;j++){
            max = Math.max(max,prev[j]);
        }
        return max;

    }

    public static void main(String[] args) {
        // Expected Output : 74
        int[][] matrix = {
            {10, 10, 2, -13, 20, 4},
            {1, -9, -81, 30, 2,  5},
            {0, 10, 4, -79, 2,  -10},
            {1, -5, 2, 20, -11,  4},
        };
        int row = matrix.length;
        int col = matrix[0].length;

        // Using Recursion 
        int max1 = Integer.MIN_VALUE;
        for(int j=0;j<col;j++){
            max1 = Math.max(max1,fun1(row-1, j, matrix));
        }
        System.out.println("Max Path Sum : " + max1);

        // Using Memoization 
        int[][] dp = new int[row][col];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        int max2 = Integer.MIN_VALUE;
        for(int j=0;j<col;j++){
            max2 = Math.max(max2,fun2(row-1,j,matrix,dp));
        }
        System.out.println("Max Path Sum : " + max2);

        // Using Tabulation 
        System.out.println("Max Path Sum : " + fun3(matrix));

        // Using Space Optimization In Tabulation 
        System.out.println("Max Path Sum : " + fun4(matrix));



    }
}
