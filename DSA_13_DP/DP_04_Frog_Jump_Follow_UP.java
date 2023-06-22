import java.util.*;
public class DP_04_Frog_Jump_Follow_UP {

    public static int fun(int n , int[] heights , int k){
        // Base Case 
        if(n == 0) return 0;

        // Code 
        int minEnergy = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            int jump = Integer.MAX_VALUE;
            if(n-j > 0) jump = fun(n-j,heights,k) + Math.abs(heights[n] - heights[n-j]);
            minEnergy = Math.min(minEnergy,jump);
        }
        return minEnergy;
    }
    // Time Complexity : O(2^n)*O(k)
    // Space Complexity : O(n)   
    
    // Memoization 
    public static int fun1(int n , int[] heights , int k , int[] dp){
        // Base Case 
        if(n == 0) return 0;

        // Code 
        if(dp[n] != -1) return dp[n];
        int minEnergy = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            int jump = Integer.MAX_VALUE;
            if((n-i) > 0) jump = Math.abs(heights[i] - heights[n-i]) + fun1(n-i,heights,k,dp);
            minEnergy = Math.min(minEnergy,jump);
        }
        return dp[n] = minEnergy;
    }

    public static void main(String[] args) {
        int[] heights = {30 , 10 , 60 , 10 , 60 , 50};
        int n = heights.length;
        int k = 5;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(fun(n,heights,k));
        System.out.println(fun1(n,heights,k,dp));
    }
}
