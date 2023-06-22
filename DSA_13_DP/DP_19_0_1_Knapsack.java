import java.util.Arrays;

public class DP_19_0_1_Knapsack {

    // Recursive Code 
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public static int fun1(int index , int W , int[] weight , int[] value){
        // Base Case 
        if(index == 0){
            if(weight[index] <= W) return value[index];
            else return 0;
        } 

        // Code 
        int notPick = 0 + fun1(index-1,W,weight,value);
        int pick = Integer.MIN_VALUE;
        if(weight[index] <= W) pick = value[index] + fun1(index-1,W-weight[index],weight,value);
        return Math.max(pick,notPick);
    }

    // Memoization Code 
    // Time Complexity : O(n x w)
    // Space Complexity : O(n x w) + O(n)
    public static int fun2(int index , int W , int[] weight , int[] value , int[][] dp){
        // Base Case 
        if(index == 0){
            if(weight[0] <= W) return value[0];
            else return 0;
        } 

        // Code 
        if(dp[index][W] != -1) return dp[index][W]; 
        int notPick = 0 + fun2(index-1,W,weight,value,dp);
        int pick = Integer.MIN_VALUE;
        if(weight[index] <= W) pick = value[index] + fun2(index-1,W-weight[index],weight,value,dp);
        return dp[index][W] = Math.max(pick,notPick);
    }

    // Tabulation Code 
    // Time Complexity : O(n x n)
    // Space Complexity : O(n x w)
    public static int fun3(int W , int[] weight , int[] value){
        // Instantiate DP
        int n = weight.length;
        int[][] dp = new int[n][W+1];

        // Base Tabulations 
        for(int w=weight[0];w<=W;w++) dp[0][w] = value[0];

        // Code 
        for(int index=1;index<n;index++){
            for(int w=0;w<=W;w++){
                int notPick = 0 + dp[index-1][w];
                int pick = Integer.MIN_VALUE;
                if(weight[index] <= w) pick = value[index] + dp[index-1][w-weight[index]];
                dp[index][w] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][W];
    }

    // Tabulation With Space Optimization
    // Time Complexity : O(n x n)
    // Space Complexity : O(n) + O(n)...double list 
    public static int fun4(int W , int[] weight , int[] value){
        // Instantiate DP
        int n = weight.length;
        int[] prev = new int[W+1];
        int[] current = new int[W+1];

        // Base Tabulations 
        for(int w=weight[0];w<=W;w++) prev[w] = value[0];

        // Tabulations 
        for(int index=1;index<n;index++){
            for(int w=0;w<=W;w++){
                int notPick = 0 + prev[w];
                int pick = Integer.MIN_VALUE;
                if(weight[index] <= w) pick = value[index] + prev[w-weight[index]];
                current[w] = Math.max(pick,notPick);
            }
            prev = Arrays.copyOf(current, W+1);
        }
        return prev[W];
    }

    // Most Optimal Code 
    // Time Complexity : O(n x n)
    // Space Complexity : O(n)..single list 
    public static int fun5(int W , int[] weight , int[] value){
        // Instantiate DP
        int n = weight.length;
        int[] prev = new int[W+1];

        // Base Tabulations 
        for(int w=weight[0];w<=W;w++) prev[w] = value[0];

        // Tabulations 
        for(int index=1;index<n;index++){
            for(int w=0;w<=W;w++){
                int notPick = 0 + prev[w];
                int pick = Integer.MIN_VALUE;
                if(weight[index] <= w) pick = value[index] + prev[w-weight[index]];
                prev[w] = Math.max(pick,notPick);
            }
        }
        return prev[W];
    }



    public static void main(String[] args) {
        // Input with expected output : 13
        int[] weight = {1, 2, 4, 5};
        int[] value = {5, 4, 8, 6};
        int W = 5 , n = weight.length;

        // Using Recursion 
        System.out.println("Max Value : " + fun1(n-1,W,weight,value));

        // Using Memoization 
        int[][] dp = new int[n][W+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Max Value : " + fun2(n-1,W,weight,value,dp));

        // Using Tabulation 
        System.out.println("Max Value : " + fun3(W,weight,value));
        
        // Using Space Optimization In Tabulations 
        System.out.println("Max Value : " + fun4(W,weight, value));
    }
}