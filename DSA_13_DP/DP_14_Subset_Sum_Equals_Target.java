import java.util.Arrays;

public class DP_14_Subset_Sum_Equals_Target {

    // Recursive Code 
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public static boolean fun1(int index , int target , int[] arr){
        // Base Case 
        if(target == 0) return true;
        if(index == 0) return (arr[0] == target);

        // Code 
        boolean notTake = fun1(index-1,target,arr);
        boolean take = false;
        if(arr[index] <= target) take = fun1(index-1,target-arr[index],arr);

        // Return In Any Of Case Works 
        return take || notTake; 
    }

    // Memoization 
    // Time Complexity : O(n x target)
    // Space Complexity : O(n x targer) + O(n)
    public static boolean fun2(int index,int target,int[] arr , int[][] dp){
        // Base Case 
        if(target == 0) return true;
        if(index == 0) return (arr[index] == target);

        // Code 
        if(dp[index][target] != -1) return (dp[index][target]==target) ? true : false;

        boolean notTake = fun2(index-1,target,arr,dp);
        boolean take = false;
        if(arr[index] <= target) take = fun2(index-1,target-arr[index],arr,dp);
        dp[index][target] = (take || notTake) ? target : 0;
        return take || notTake;
    }

    // Tabulation 
    // Time Complexity : O(n x target)
    // Space Complexity : O(n x target)
    public static boolean fun3(int[] arr , int target){
        // Instantiate dp 
        int n = arr.length;
        boolean[][] dp = new boolean[n][target+1];

        // Base Tabulations 
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;

        // Tabulations 
        for(int index=1;index<n;index++){
            for(int j=1;j<=target;j++){
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if(arr[index] <= target) take = dp[index-1][target-arr[index]];
                dp[index][j] = take||notTake;
            }
        }
        return dp[n-1][target];
    }

    // Space Optimization In Tabulation 
    public static boolean fun4(int[] arr , int target){
        int n = arr.length;
        boolean[] prev = new boolean[target+1];
        boolean[] curr = new boolean[target+1];
        prev[0] = curr[0] = true;
        prev[arr[0]] = true;
        for(int index=1;index<n;index++){
            for(int j=1;j<=target;j++){
                boolean notTake = prev[j];
                boolean take = false;
                if(arr[index] <= j) take = prev[j-arr[index]];
                curr[j] = take||notTake;
            }
            prev = Arrays.copyOfRange(curr, 0, n);
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 7, 2, 9, 10}; // Expected Output : False
        int target1 = 6;
        int[] arr2 = {6, 1, 2, 1}; // Expected Output : True
        int target2 = 4;

        // Using Recursion 
        System.out.println("Exist : " + fun1(arr1.length-1,target1,arr1));
        System.out.println("Exist : " + fun1(arr2.length-1,target2,arr2));

        // Using Memoization 
        int[][] dp = new int[arr1.length][target1+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a , -1));
        System.out.println("Exist : " + fun2(arr1.length-1,target1,arr1,dp));
        System.out.println("Exist : " + fun2(arr2.length-1,target2,arr2,dp));

        // Using Tabulation
        System.out.println("Exist : " + fun3(arr1,target1));
        System.out.println("Exist : " + fun3(arr2,target2));

        // Using Space Optimization In Tabulation
        System.out.println("Exist : " + fun4(arr1,target1));
        System.out.println("Exist : " + fun4(arr2,target2)); 
    }
}
