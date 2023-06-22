import java.util.*;

public class DP_05_Max_Sum_Non_Adjacent_Array {

    // Recursive Approach 
    public static int fun1(int index , int[] nums){
        // Base case 
        if(index == 0) return nums[index];
        if(index < 0) return 0;

        // Code 
        int pick = nums[index] + fun1(index-2,nums);
        int notPick = 0 + fun1(index-1,nums);

        // Return the max
        return Math.max(pick,notPick);
    }
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)

    // Memoization
    public static int fun2(int index , int[] nums , int[] dp){
        // Base Case 
        if(index == 0) return nums[index];
        if(index < 0) return 0;

        // DP Algo
        if(dp[index] != -1) return dp[index];

        // Code 
        int pick = nums[index] + fun2(index-2,nums,dp);
        int notPick = 0 + fun2(index-1,nums,dp);

        // Storing in dp
        return dp[index] = Math.max(pick,notPick);
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n) + O(n) , {Recursive Stack Space + Array Space}

    // Tabulation 
    public static int fun3(int index , int[] nums){
        // Instantiate DP
        int n = nums.length;
        int[] dp = new int[n];

        // Base Case 
        dp[0] = nums[0];

        // Code 
        for(int i=1;i<n;i++){
            int pick = (i > 1) ? nums[i] + dp[i-2] : nums[i] + 0;
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[n-1];
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n)

    // Space Optimiszation In Tabulation 
    public static int fun4(int index,int[] nums){
        // Base Case 
        int prev = nums[0], prevPrev = -1 , current = -1;
        int n = nums.length;

        for(int i=1;i<n;i++){
            int pick = (i > 1) ? nums[i] + prevPrev : nums[i] + 0;
            int notPick = 0 + prev;
            current = Math.max(pick,notPick);
            prevPrev = prev;
            prev = current;
        }
        return current;
    }
    // Time Complexity : O(n)
    // Space Complexity : O(1)


    public static void main(String[] args) {
        
        int[] nums = {2,1,4,9};
        int n = nums.length;
        // Recursive Code 
        System.out.println("The maximum sum of non adjacent elements using recursion : " + fun1(n-1,nums));

        // Memoization 
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println("The maximum sum of non adjacent elements using memoization : " + fun2(n-1,nums,dp));

        // Tabulation 
        System.out.println("The maximum sum of non adjacent elements using tabulation : " + fun3(n-1,nums));

        // Space Optimization in Tabulation 
        System.out.println("The maximum sum of non adjacent elements using space optimization in tabulation : " + fun4(n-1,nums));
    }
}
