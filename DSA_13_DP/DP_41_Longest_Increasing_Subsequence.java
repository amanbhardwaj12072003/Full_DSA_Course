import java.util.*;
public class DP_41_Longest_Increasing_Subsequence {

    // Using Recursion 
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public static int fun1(int index,int prev_index,int[] arr){
        // Base Case 
        if(index == arr.length) return 0;
        // Code 
        int len_not_take = 0 + fun1(index+1,prev_index,arr);
        if(prev_index == -1) len_take = 1 + fun1(index+1,index,arr);
        else if(arr[index] > arr[prev_index]) len_take = 1 + fun1(index+1, index, arr);
        return Math.max(len_not_take,len_take);
    }

    // Memoization Code 
    // Time Complexity : O(n x n)
    // Space Complexity : O(n x n) + O(n)..recursive stack space 
    public static int fun2(int index,int prev_index,int[] arr, int[][] dp){
        // Base Case 
        if(index == arr.length) return 0;

        // Code 
        if(dp[index][prev_index+1] != -1) return dp[index][prev_index+1];
        int len_not_take = 0 + fun2(index+1,prev_index,arr,dp);
        int len_take = -1;
        if(prev_index == -1) len_take = 1 + fun2(index+1,index,arr,dp);
        else if(arr[index-1] > arr[prev_index]) len_take = 1 + fun2(index+1,index,arr,dp);
        return dp[index][prev_index+1] = Math.max(len_not_take,len_take);
    }

    
    // Tabulation Code 
    // Time Complexity : O(n x n)
    // Space Complexity : O(n x n)
    public static int fun3(int[] arr){
        // Instantiate DP
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        // Base Tabulations 
        for(int prev=n-1;prev>=0;prev--) dp[n][prev] = 0;

        // Tabulations 
        for(int index=n-1;index>=1;index--){
            for(int prev=index-1;prev>=-1;prev--){
                int len_not_take = 0 + dp[index+1][prev+1];
                int len_take = -1;
                if(prev == -1) len_take = 1 + dp[index+1][index];
                if(arr[index-1] > arr[prev+1]) len_take = 1 + dp[index+1][index];
                dp[index][prev+1] = Math.max(len_not_take,len_take);
            }
        }
        return dp[1][-1+1];
    }

    // Tabulation Code 
    // Time Complexity : O(n x n)
    // Space Complexity : O(n x n)
    public static int fun4(int[] arr){
        // Instantiate DP
        int n = arr.length;
        int[] front = new int[n+1];
        int[] back = new int[n+1];

        // Base Tabulations 
        for(int prev=n-1;prev>=0;prev--) front[prev] = 0;

        // Tabulations 
        for(int index=n-1;index>=1;index--){
            for(int prev=n-1;prev>=0;prev--){
                int len_not_take = 0 + front[prev];
                int len_take = -1;
                if(prev == 0) len_take = 1 + front[index];
                if(arr[index-1] > arr[prev]) len_take = 1 + front[index];
                back[prev] = Math.max(len_not_take,len_take);
            }
            front = Arrays.copyOfRange(back,0,n+1);
        }
        return front[0];
    }

    //             ################## Important ##################               //
    // Time Complexity : O(n x n) Code 
    // Space Complexity : O(n)
    public static int fun5(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int maximum = 0;
        for(int index=0;index<n;index++){
            for(int prev=0;prev<index;prev++){
                if(arr[prev] < arr[index]){
                    dp[index] = Math.max(1+ dp[prev],dp[index]);
                }
            }
            maximum = Math.max(maximum,dp[index]);
        }
        return maximum;
    }

    public static void main(String[] args) {
        // Expected Output : 3
        int[] arr = {5, 4, 11, 1, 16, 8};
        int n = arr.length;

        // Using Recursion 
        System.out.println("The Longest Increasing Subsequence : " + fun1(0,-1,arr));

        // Using Memoization 
        int[][] dp = new int[n][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("The Longest Increasing Subsequence : " + fun2(0,-1,arr,dp));

        // Using Tabulation 
        System.out.println("The Longest Increasing Subsequence : " + fun3(arr));

        // Using Tabulation With Space Optimization 
        System.out.println("The Longest Increasing Subsequence : " + fun4(arr));
    }
}
