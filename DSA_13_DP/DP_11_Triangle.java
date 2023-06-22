import java.util.Arrays;

public class DP_11_Triangle {

    // Recursive Code 
    // Time Complexity : O(2^(1+2+3+4...(n)))...as we have (1+2+3..(n)) elements and each have 2 cases to go
    // Space Complexity : O(n)...recursive stack space 
    public static int fun1(int row , int col , int[][] triangle , int n){
        // Base Case 
        if(row == n-1) return triangle[n-1][col];
        
        // Code 
        int move_down = triangle[row][col] + fun1(row+1,col,triangle,n);
        int move_right = triangle[row][col] + fun1(row+1,col+1,triangle,n);
        return Math.min(move_down,move_right);
    }

    // Memoization
    // Time Complexoty : O(n x n)
    // Space Complexity : O(n x n) + O(n) , {Matrix Storage + Recursive Stack Space}
    public static int fun2(int row, int col, int[][] triangle, int n, int[][] dp){
        // Base Case 
        if(row == n-1) return triangle[n-1][col];

        // Code 
        if(dp[row][col] != -1) return dp[row][col];
        int move_down = triangle[row][col] + fun2(row+1, col, triangle, n, dp);
        int move_right = triangle[row][col] + fun2(row+1, col+1, triangle, n, dp);
        return dp[row][col] = Math.min(move_down,move_right);
    }

    // Tabulation.. Note that tabulation always move opposite to recursive code flow 
    // Time Complexity : O(n x n)
    // Space Complexity : O(n x n)
    public static int fun3(int[][] triangle , int n){
        // Instantiate DP
        int[][] dp = new int[n][n];

        // Base Tabulations 
        for(int col=0;col<n;col++){
            dp[n-1][col] = triangle[n-1][col];
        }

        // Tabulations 
        for(int row=n-2;row>=0;row--){
            for(int col=row;col>=0;col--){
                int move_up = triangle[row][col] + dp[row+1][col];
                int move_left = triangle[row][col] + dp[row+1][col+1];
                dp[row][col] = Math.min(move_up,move_left);
            }
        }
        return dp[0][0];
    }

    // Space Optimizations In Tabulation 
    public static int fun4(int[][] triangle , int n){
        // Instantiate DPs
        int[] front = new int[n];
        int[] curr = new int[n];

        // Base Tabulation 
        for(int col=0;col<n;col++) front[col] = triangle[n-1][col];

        // Tabulations 
        for(int row=n-2;row>=0;row--){
            for(int col=row;col>=0;col--){
                int move_up = triangle[row][col] + front[col];
                int move_left = triangle[row][col] + front[col+1];
                curr[col] = Math.min(move_up,move_left);
            }
            front = curr;
        }
        return front[0];
    }

    public static void main(String[] args) {
        int[][] triangle = {
                            {2},
                            {3, 4},
                            {6, 5, 7}, 
                            {4, 1, 8, 3}
                        };
        int n = triangle.length;

        // Using Recursive Code 
        System.out.println("Min Path Sum from (0,0) --> (n-1,j) : " + fun1(0, 0, triangle, n));

        // Using Memoization 
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Min Path Sum from (0,0) --> (n-1,j) : " + fun2(0, 0, triangle, n,dp));

        // Using Tabulations
        System.out.println("Min Path Sum from (0,0) --> (n-1,j) : " + fun3(triangle, n));

        // Using Space Optimization In Tabulation 
        System.out.println("Min Path Sum from (0,0) --> (n-1,j) : " + fun4(triangle, n));

    }
}
