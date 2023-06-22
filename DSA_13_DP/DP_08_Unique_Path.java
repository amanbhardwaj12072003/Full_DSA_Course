import java.util.*;
public class DP_08_Unique_Path {

    // Recursive Code 
    // Time Complexity : O(2^(m*n))
    // Space Complexity : O((m-1) + (n-1))
    public static int fun1(int row_index , int col_index){
        // Base Case 
        if(row_index == 0 && col_index == 0) return 1;
        if(row_index < 0 || col_index < 0) return 0;

        // Code 
        int move_left = fun1(row_index, col_index-1);
        int move_up = fun1(row_index-1,col_index);
        return move_left + move_up;
    }

    // Memoization Code 
    // Time Complexity : O(m x n)
    // Space Compelxity : O((m-1) + (n-1)) + O(m x n)
    public static int fun2(int row_index , int col_index , int[][] dp){
        // Base Case 
        if(row_index == 0 && col_index == 0) return 1;
        if(row_index < 0 || col_index < 0) return 0;
        
        // Code 
        if(dp[row_index][col_index] != -1) return dp[row_index][col_index];
        int move_left = fun2(row_index,col_index-1,dp);
        int move_up = fun2(row_index-1,col_index,dp);
        return dp[row_index][col_index] = move_left + move_up;
    }

    // Tabulation Code 
    public static int fun3(int row_index , int col_index){
        // Instantiate DP
        int[][] dp = new int[row_index+1][row_index+1];

        // Tabulation 
        for(int row_move = 0;row_move < row_index+1;row_move++){
            for(int col_move = 0;col_move < col_index+1;col_move++){
                // Base Tabulation 
                if(row_move == 0 && col_move == 0) dp[row_move][col_move] = 1;

                // General Tabulation
                else{
                    int move_left = 0 , move_up = 0; 
                    if(col_move > 0) move_left = dp[row_move][col_move-1];
                    if(row_move > 0) move_up = dp[row_move-1][col_move];
                    dp[row_move][col_move] = move_left + move_up;
                }
            }
        }
        return dp[row_index][col_index];
    }

    // Space Optimization In Tabulation (Optional In Interview)
    public static int fun4(int row_index , int col_index){
        int[] prev = new int[col_index+1];
        for(int row_move=0;row_move<row_index+1;row_move++){
            int[] temp = new int[col_index+1];
            for(int col_move=0;col_move<col_index+1;col_move++){
                // Base Case 
                if(row_move==0 && col_move==0){
                    temp[col_move] = 1;
                }
                else{
                    if(col_move > 0) temp[col_move] = prev[col_move] + temp[col_move-1];
                }
            }
            prev = temp;
        }
        return prev[col_index];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        // Using Recursion 
        System.out.println("Count Of Unique Paths : " + fun1(row-1,col-1));

        // Using Memoization 
        int[][] dp = new int[row][col];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Count Of Unique Paths : " + fun2(row-1,col-1,dp));

        // Using Tabulation 
        System.out.println("Count Of Unique Paths : " + fun3(row-1,col-1));

        // Using Space Optimization In Tabulation 
        System.out.println("Count Of Unique Paths : " + fun4(row-1,col-1));

    }
}
