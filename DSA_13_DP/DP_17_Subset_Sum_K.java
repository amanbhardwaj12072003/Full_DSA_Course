public class DP_17_Subset_Sum_K {

    // Recursive Code 
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public static int fun1(int index, int sum , int[] nums){
        // Base Case 
        if(sum == 0) return 1;
        if(index == 0) return (nums[0]==sum) ? 1 : 0;
        
        // Code 
        int notPick = fun1(index-1,sum,nums);
        int pick = 0;
        if(nums[index] <= sum) pick = fun1(index-1,sum-nums[index],nums);
        return pick + notPick;
    }
    
    // Memoization Code
    // Time Complexity : O(n x n)
    // Space Complexity : O(n x n) + O(n)...Matrix Space + Recursive Stack Space  
    public static int fun2(int index , int sum , int[] nums , int[][] dp){
        // Base Case 
        if(sum == 0) return 1;
        if(index == 0) return (nums[0]==sum) ? 1 : 0;

        // Code 
        if(dp[index][sum] != -1) return dp[index][sum];
        int notPick = fun2(index-1,sum,nums,dp);
        int pick = 0;
        if(nums[index] <= sum) pick = fun2(index-1,sum-nums[index],nums,dp);
        return dp[index][sum] = pick + notPick;
    }

    
    // Tabulation Code 
    // Time Complexiy : O(n x n)
    // Space Complexity : O(n x n)
    public static int fun3(int sum , int[] nums){
        // Instantiate DP
        int n = nums.length;
        int[][] dp = new int[n][sum+1];

        // Base Tabulation 
        for(int index=0;index<n;index++) dp[index][0] = 1;
        if(nums[0] <= sum) dp[0][nums[0]] = 1;

        // Tabulation 
        for(int index = 1;index<n;index++){
            for(int add=0;add<=sum;add++){
                int notPick = dp[index-1][add];
                int pick = 0;
                if(nums[index] <= sum) pick = dp[index-1][add-nums[index]];
                dp[index][add] = pick + notPick;
            }
        }
        return dp[n-1][sum];
    }

    // Tabulation With Space Optimization 
    // Time Complexity : O(n x n)
    // Space Complexity : O(n)
    public static int fun4(int sum , int[] nums){
        // Instantiate DP
        int n = nums.length;
        int[] prev = new int[sum+1];
        int[] current = new int[sum+1];

        // Base Tabulation 
        prev[0] = current[0] = 1;
        if(nums[0] == sum) prev[nums[0]] = 1;
        
        // Tabulation 
        for(int index=1;index<n;index++){
            for(int add=0;add<sum;add++){
                int notpick = prev[add];
                int pick = 0;
                if(nums[index] <= sum) pick = prev[add - nums[index]];
                current[add] = pick + notpick;
            }
            prev = current;
        }
        return prev[sum];
    }

    public static void main(String[] args) {
        
    }
}
