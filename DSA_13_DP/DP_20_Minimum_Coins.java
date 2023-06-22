import java.util.*;
public class DP_20_Minimum_Coins {

    // Recursive Code 
    // Time Complexity : >> O(2^n)...In Initerview We Have TO Just Say That It Is Exponential
    // Space Complexity : >> O(n) but at worst case O(target)
    public static int fun1(int index , int target , int[] arr){
        // Base Case 
        if(index == 0){
            if(target%arr[index] == 0) return target/arr[index];
            else return 1000000;
        }

        // Code 
        int notTake = 0 + fun1(index-1,target,arr);
        int take = 1000000;
        if(arr[index] <= target) take = 1 + fun1(index, target - arr[index], arr);
        return Math.min(take,notTake);
    }

    // Memoization Code 
    // Time Complexity : O(n x target) 
    // Space Complexity : O(n x target) + O(target)
    public static int fun2(int index , int target , int[] arr , int[][] dp){
        // Base Case 
        if(index == 0){
            if(target%arr[index] == 0) return target/arr[index];
            else return 1000000;
        }

        // Code 
        if(dp[index][target] != -1) return dp[index][target];
        int notPick = 0 + fun2(index-1,target,arr,dp);
        int pick = 1000000;
        if(arr[index] <= target) pick = 1 + fun2(index, target - arr[index], arr, dp);
        return dp[index][target] = Math.min(pick,notPick);
    }

    // Tabulation Code 
    // Time Complexity : O(n x target)
    // Space Complexity : O(n x target)
    public static int fun3(int target , int[] arr){
        // Instantiate DP
        int n = arr.length;
        int[][] dp = new int[n][target+1];

        // Base Tabulations 
        for(int tar=0;tar<=target;tar++){
            if(tar%arr[0]==0) dp[0][tar] = tar/arr[0];
            else dp[0][tar] = 1000000;
        }

        // Tabulation 
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=target;tar++){
                int notPick = 0 + dp[ind-1][tar];
                int pick = 1000000;
                if(arr[ind] <= tar) pick = 1 + dp[ind][tar-arr[ind]];
                dp[ind][tar] = Math.min(pick,notPick);
            }
        }
        return dp[n-1][target];
    }

    // Tabulation With Space Optimization
    public static int fun4(int target , int[] arr){
        // Instantiate DP
        int n = arr.length;
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        for(int tar=0;tar<=target;tar++) prev[tar] = (tar%arr[0]==0) ? tar/arr[0] : 1000000;

        // Tabulation 
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=target;tar++){
                int notPick = 0 + prev[tar];
                int pick = 1000000;
                if(arr[ind] <= tar) pick = 1 + curr[tar-arr[ind]];
                curr[tar] = Math.min(pick,notPick);
            }
            prev = Arrays.copyOfRange(curr,0,target+1);
        }
        return prev[target];
    }

    public static void main(String[] args) {
        // Expected Output : 2
        int[] arr = {12, 1, 3};
        int n = arr.length;
        int target = 4;

        // Using Recursion
        System.out.println("Minimum Coins : " + fun1(n-1,target,arr));

        // Using Memoization 
        int[][] dp = new int[n][target+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Minimum Coins : " + fun2(n-1,target,arr,dp));

        // Using Tabulations
        System.out.println("Minimum Coins : " + fun3(target,arr));

        // Using Tabulations With Space Optimization 
        System.out.println("Minimum Coins : " + fun3(target,arr));
    }
}
