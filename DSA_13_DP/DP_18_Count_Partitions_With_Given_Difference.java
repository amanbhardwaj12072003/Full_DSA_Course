import java.util.*;

public class DP_18_Count_Partitions_With_Given_Difference {

    // Recursive Code 
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public static int fun1(int index , int sum , int[] arr){
        // Base Case 
        if(sum == 0) return 1;
        if(index == 0) return (arr[index] == sum) ? 1 : 0;

        // Code 
        int notPick = fun1(index-1,sum,arr);
        int pick = 0;
        if(arr[index] <= sum) pick = fun1(index-1,sum-arr[index],arr);
        return pick + notPick;
    }

    // Memoization Code 
    // Time Complexity : O(n)
    // Space Complexity : O(n x n) + O(n)
    public static int fun2(int index , int sum , int[] arr , int[][] dp){
        // Base Case 
        if(sum == 0) return 1;
        if(index == 0) return (arr[0]==sum) ? 1 : 0;

        // Code 
        if(dp[index][sum] != -1) return dp[index][sum];
        int notPick = fun2(index-1,sum,arr,dp);
        int pick = 0;
        if(arr[index] <= sum) pick = fun2(index-1,sum-arr[index],arr,dp);
        return dp[index][sum] = pick + notPick;
    }

    // Tabulation Code 
    // Time Complexity : O(n)
    // Space Complexity : O(n x n)
    public static int fun3(int sum , int[] arr){
        // Instantiate DP
        int n = arr.length;
        int[][] dp = new int[n][sum+1];

        // Base Tabulation 
        for(int index=0;index<n;index++) dp[index][0] = 1;
        if(arr[0] < sum) dp[0][arr[0]] = 1;

        // Tabulations
        for(int index=1;index<n;index++){
            for(int add=0;add<=sum;add++){
                int notPick = dp[index-1][add];
                int pick = 0;
                if(arr[index] <= add) pick = dp[index-1][add-arr[index]];
                dp[index][add] = pick + notPick;
            }
        }
        return dp[n-1][sum];
    }

    // Tabulation With Space Optimization 
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static int fun4(int sum , int[] arr){
        // Instantiate DP
        int n = arr.length;
        int[] prev = new int[sum+1];
        int[] curr = new int[sum+1];

        // Base Tabulations
        prev[0] = curr[0] = 1;
        if(arr[0] < sum) prev[arr[0]] = 1;

        // Code 
        for(int index=1;index<n;index++){
            for(int add=0;add<=sum;add++){
                int notPick = prev[add];
                int pick = 0;
                if(arr[index] <= add) pick = prev[add-arr[index]];
                curr[add] = pick + notPick;
            }
            prev = Arrays.copyOf(curr, sum+1);
        }
        return prev[sum];

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 5, 1};
        int difference = 1;

        /*
            Logic : sum1 + sum2 = totalSum.....eq1
                    sum1 - sum2 = difference ..eq2
                    sum1 >= sum2

                    Using these 3 equations
                    2(sum2) = totalSum - difference
                    sum2 = (totalSum - difference)/2
                    [
                        But this should satisfy following conditions
                        totalSum - difference >= 0.......condition1
                        (totalSum - difference)%2 == 0...condition2
                    ]
        */

        // Base Case 
        int totalSum = 0 , n = arr.length;
        for(int i : arr) totalSum += i;
        if((totalSum-difference)<0 || (totalSum-difference)%2 != 0){
            System.out.println(" Count Of Required Partitions : " + 0);
            return;
        }
        int sum = (totalSum-difference)/2;

        // Using Recursion 
        System.out.println("Count Of Required Partitions : " + fun1(n-1,sum,arr));

        // Using Memoization Code 
        int[][] dp = new int[n][sum+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Count Of Required Partitions : " + fun2(n-1,sum,arr,dp));

        // Using Tabulation 
        System.out.println("Count Of Required Partitions : " + fun3(sum,arr));

        // Using Tabulation With Space Optimization 
        System.out.println("Count Of Required Partitions : " + fun4(sum,arr));
    
    }
}
