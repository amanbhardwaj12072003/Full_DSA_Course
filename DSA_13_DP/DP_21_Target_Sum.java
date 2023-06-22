import java.util.Arrays;

public class DP_21_Target_Sum {

    // Recursive Code 
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public static int fun1(int index , int target , int[] arr){
        // Base Case 
        if(target==0) return 1;
        if(index == 0){
            if(target==arr[0]) return 1;
            else return 0;
        }
        // Code 
        int notPick = fun1(index-1,target,arr);
        int pick = 0;
        if(arr[index] <= target) pick = fun1(index-1,target-arr[index],arr);
        return pick + notPick;
    }

    // Memoization
    // Time Complexity : O(n x target)
    // Space Complexity : O(n x target) + O(n)
    public static int fun2(int index , int target , int[] arr , int[][] dp){
        // Base Case 
        if(target == 0) return 1;
        if(index == 0){
            if(target == arr[0]) return 1;
            else return 0; 
        }
        // Code 
        if(dp[index][target] != -1) return dp[index][target];
        int notPick = fun2(index-1,target,arr,dp);
        int pick = 0;
        if(arr[index] <= target) pick = fun2(index-1,target-arr[index],arr,dp);
        return dp[index][target] = pick + notPick;
    }

    // Tabulation Code 
    public static int fun3(int target , int[] arr){
        // Instantiate Dp
        int n = arr.length;
        int[][] dp = new int[n][target+1];

        // Base Tabulations 
        // Time Complexity : O(n x target)
        // Space Complexity : O(n x target)
        for(int ind=0;ind<n;ind++) dp[ind][0] = 1;
        if(arr[0] <= target) dp[0][arr[0]] = 1;

        // Tabulations 
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=target;tar++){
                int notPick = dp[ind-1][tar];
                int pick = 0;
                if(arr[ind] <= tar) pick = dp[ind-1][tar-arr[ind]];
                dp[ind][tar] = pick + notPick;
            }
        }
        return dp[n-1][target];
    }

    // Using Space Optimization In Tabulations 
    public static int fun4(int target, int[] arr){
        // Instantiate DP
        int n = arr.length;
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        // Base Tabulation 
        prev[0] = curr[0] = 1;
        if(arr[0] <= target) prev[arr[0]] = 1;

        // Tabulation 
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=target;tar++){
                int notPick = prev[tar];
                int pick = 0;
                if(arr[ind] <= tar) pick = prev[tar-arr[ind]];
                curr[tar] = pick + notPick;
            }
            prev = Arrays.copyOfRange(curr , 0, target+1);
        }
        return prev[target];
    }

    public static void main(String[] args) {
        // Expected Output : 2
        int[] arr = {1, 2, 3, 1};
        int n = arr.length;
        int difference = 3; // (D) 
        int totalSum = 0;   // (T)
        for(int i : arr) totalSum += i;

        /*
        s1 - s2 = D
        s1 + s2 = T
        2(s2) = (T-D)
        s2 = (T-D)/2
        with conditions :
        1) T>=D
        2) (T-D)%2==0
        */

        if((totalSum < difference) || ((totalSum-difference) % 2) != 0){
            System.out.println("Possible Combinations Of + and - : " + 0);
            return;
        }

        int target = (totalSum-difference)/2;

        // Using Recursion 
        System.out.println("Possible Combinations Of + and - : " + fun1(n-1,target,arr));

        // Using Memoization 
        int[][] dp = new int[n][target+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Possible Combinations Of + and - : " + fun2(n-1,target,arr,dp));

        // Using Tabulation 
        System.out.println("Possible Combinations Of + and - : " + fun3(target,arr));

        // Using Tabulation With Space Optimization 
        System.out.println("Possible Combinations Of + and - : " + fun4(target,arr));
    }
}
