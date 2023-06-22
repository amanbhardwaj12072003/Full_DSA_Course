import java.util.Arrays;

public class DP_22_Coin_Change {

    // Recursive Code 
    // Time Complexity : >> O(2^n)
    // Space Complexity : O(target)
    public static int fun1(int index , int target , int[] arr){
        // Base Case 
        // if(target == 0) return 1;
        if(index == 0){
            if(target % arr[0]==0) return 1;
            else return 0;
        }

        // Code 
        int notPick = fun1(index-1,target,arr);
        int pick = 0;
        if(arr[index] <= target) pick = fun1(index,target-arr[index],arr);
        return pick + notPick;
    }

    // Memoization
    // Time Complexity : O(n x target)
    // Space Complexity : O(n x target) + O(target)
    public static int fun2(int index , int target , int[] arr , int[][] dp){
        // Base Case 
        if(index == 0){
            if(target % arr[0] == 0) return 1;
            else return 0; 
        }

        // Code 
        if(dp[index][target] != -1) return dp[index][target];
        int notPick = fun2(index-1,target,arr,dp);
        int pick = 0;
        if(arr[index] <= target) pick = fun2(index, target-arr[index], arr, dp);
        return dp[index][target] = pick + notPick;
    }

    // Tabulation Code 
    // Time Complexity : O(n x target)
    // Space Complexity : O(n x target)
    public static int fun3(int target , int[] arr){
        // Instantiate DP
        int n = arr.length;
        int[][] dp = new int[n][target+1];

        // Base Tabulation 
        // for index==0 possible targets are..
        for(int tar=0;tar<=target;tar++){
            if(tar % arr[0] == 0) dp[0][tar] = 1;
            else dp[0][tar] = 0; 
        }

        // Tabulation 
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=target;tar++){
                int notPick = dp[ind-1][tar];
                int pick = 0;
                if(arr[ind] <= tar) pick = dp[ind][tar-arr[ind]];
                dp[ind][tar] = pick + notPick;
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

        // Base Tabulation 
        for(int tar=0;tar<=target;tar++){
            if(tar % arr[0] == 0) prev[tar] = 1;
            else prev[tar] = 0; 
        }

        // Tabulation 
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=target;tar++){
                int notPick = prev[tar];
                int pick = 0;
                if(arr[ind] <= tar) pick = curr[tar-arr[ind]];
                curr[tar] = pick + notPick;
            }
            prev = Arrays.copyOfRange(curr, 0, target+1);
        }
        return prev[target];

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};  // Elements can be used any number of times 
        int n = arr.length;
        int target = 4;

        // Using Recursion 
        System.out.println("Possible Combination : " + fun1(n-1,target,arr));

        // Using Memoization 
        int[][] dp = new int[n][target+1];
        Arrays.stream(dp).forEach(ary -> Arrays.fill(ary,-1));
        System.out.println("Possible Combinations : " + fun2(n-1,target,arr,dp));

        // Using Tabulation
        System.out.println("Possible Combinations : " + fun3(target,arr));

        // Using Tabulation With Space Optimization
        System.out.println("Possible Combinations : " + fun4(target,arr));
    }
}
