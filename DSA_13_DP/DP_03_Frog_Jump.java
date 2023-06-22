import java.util.*;
public class DP_03_Frog_Jump {
    public static int fun(int n, int[] heights){
        // Base Case 
        if(n == 0) return 0;

        // Code 
        int jump1 = fun(n-1,heights) + Math.abs(heights[n]-heights[n-1]);
        int jump2 = Integer.MAX_VALUE;
        if(n > 1) jump2 = fun(n-2,heights) + Math.abs(heights[n]-heights[n-2]);
        return Math.min(jump1,jump2);
    }
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)

    // Memoization
    public static int fun_1(int n , int[] heights , int[] dp){
        // Base Case 
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        // Code 
        int jump1 = fun_1(n-1,heights,dp) + Math.abs(heights[n-1] - heights[n]);
        int jump2 = Integer.MAX_VALUE;
        if(n>1) jump2 = fun_1(n-2,heights,dp) + Math.abs(heights[n-2] - heights[n]);
        return dp[n] = Math.min(jump1,jump2);
    }

    // Tabulation 
    public static int fun_2(int n , int[] heights){
        // Instantiating DP
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        // Code 
        for(int i=1;i<=n-1;i++){
            int jump1 = dp[i-1] + Math.abs(heights[i-1] - heights[i]);
            int jump2 = Integer.MAX_VALUE;
            if(i > 1) jump2 = dp[i-2] + Math.abs(heights[i-2] - heights[i]);
            dp[i] = Math.min(jump1,jump2);
        }
        return dp[n-1];
    }

    // Space Optimization In Tabulation 
    public static int fun_3(int n , int[] heights){
        // Instantiating DP
        int prev2 = 0, prev1 = 0;
        int curr = -1;
        for(int i=1;i<=n-1;i++){
            int jump1 = prev1 + Math.abs(heights[i-1] - heights[i]);
            int jump2 = Integer.MAX_VALUE;
            if(i > 1) jump2 = prev2 + Math.abs(heights[i-2] - heights[i]);

            curr = Math.min(jump1,jump2);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] heights = {30,10,60,10,60,50};
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(fun(n-1,heights));
        System.out.println(fun_1(n-1,heights,dp));
        System.out.println(fun_2(n,heights));
        System.out.println(fun_3(n,heights));
    }
}

// 30 10 60 10 60 50