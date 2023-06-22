import java.util.*;
public class DP_24_Rod_Cutting {

    // Recursive Code 
    // Time Complexity : >> O(2^n)...Exponential 
    // Space Complexity : O(n)
    public static int fun1(int index , int N , int[] prices){
        // Base Case 
        if(index == 0) return N * prices[0];

        // Code 
        int notPick = 0 + fun1(index-1,N,prices);
        int pick = -1000000;
        int rodLength = index+1;
        if(rodLength <= N) pick = prices[index] + fun1(index,N-rodLength,prices);
        return Math.max(notPick,pick);
    }

    // Memoization Code 
    // Time Complexity : O(n x n) 
    // Space Complexity : O(n x n) + O(n)
    public static int fun2(int index , int N , int[] prices , int[][] dp){
        // Base Case 
        if(index == 0) return N * prices[0];

        // Code 
        if(dp[index][N] != -1) return dp[index][N];
        int notPick = 0 + fun2(index-1,N,prices,dp);
        int pick = -1000000;
        int rodLength = index+1;
        if(rodLength <= N) pick = prices[index] + fun2(index,N-rodLength,prices,dp);
        return dp[index][N] = Math.max(pick,notPick);
    }

    // Tabulation Code 
    // Time Complxity : O()
    // Space Complexity : O()
    public static int fun3(int N , int[] prices){
        // Instantiate DP
        int[][] dp = new int[N][N+1];

        // Base Tabulations 
        for(int n=0;n<=N;n++) dp[0][n] = n * prices[0]; // n -> rod length

        // Tabulations
        for(int index=1;index<N;index++){
            for(int n=0;n<=N;n++){
                int notPick = 0 + dp[index-1][n];
                int pick = -1000000;
                int rodLength = index+1;
                if(rodLength <= n) pick = prices[index] + dp[index][n - rodLength];
                dp[index][n] = Math.max(pick,notPick);
            }
        }
        return dp[N-1][N];
    }

    // Tabulation With Space Optimizations 
    public static int fun4(int N , int[] prices){
        // Instantiate DP
        int[] prev = new int[N+1];
        int[] curr = new int[N+1];

        // Base Tabulations 
        for(int n=0;n<=N;n++) prev[n] = n * prices[0]; // n -> rod length

        // Tabulations
        for(int index=1;index<N;index++){
            for(int n=0;n<=N;n++){
                int notPick = 0 + prev[n];
                int pick = -1000000;
                int rodLength = index+1;
                if(rodLength <= n) pick = prices[index] + prev[n - rodLength];
                curr[n] = Math.max(pick,notPick);
            }
        }
        return prev[N];
    }


    public static void main(String[] args) {
        // Expected Output : 24
        int[] prices = {3, 5, 8, 9, 10, 17, 17, 20};
        int N = prices.length;

        // Using Recursion 
        System.out.println("Maximum Cost : "+  fun1(N-1,N,prices));

        // Using Memoization 
        int[][] dp = new int[N][N+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Maximum Cost : " + fun2(N-1,N,prices,dp));

        // Using Tabulations 
        System.out.println("Maximum Cost : " + fun3(N,prices));

        // Using Tabulations With Space Optimizations 
        System.out.println("Maximum Cost : " + fun4(N,prices));
    }
}
