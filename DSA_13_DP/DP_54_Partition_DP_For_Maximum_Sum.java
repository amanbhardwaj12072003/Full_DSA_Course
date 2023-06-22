import java.util.*;;
public class DP_54_Partition_DP_For_Maximum_Sum {

    // Recursive Code 
    // Time Complexity : Exponential 
    // Space Complexity : O(n)
    public static int fun1(int start,int[] arr,int k){
        // Base Case 
        if(start == arr.length) return 0;

        // Code 
        int max_ans = -1000000000, current_max = -1000000000, len = 0;
        for(int end=start;end<Math.min(arr.length,start+k);end++){
            len++;
            current_max = Math.max(current_max,arr[end]);
            int sum = len*current_max + fun1(end+1,arr,k);
            max_ans = Math.max(max_ans,sum);
        }
        return max_ans;
    }

    // Memoization Code 
    // Time Complexity : 
    // Space Complexity : 
    public static int fun2(int start,int[] arr,int k,int[] dp){
        // Base Case 
        if(start == arr.length) return 0;

        // Code 
        if(dp[start] != -1) return dp[start];
        int max_ans = -1000000000, current_max = -1000000000, len = 0;
        for(int end=start;end<Math.min(arr.length,start+k);end++){
            len++;
            current_max = Math.max(current_max,arr[end]);
            int sum = len*current_max + fun2(end+1, arr, k, dp);
            max_ans = Math.max(max_ans,sum);
        }
        return dp[start] = max_ans;
    }

    // Tabulation Code 
    // Time Complexity : 
    // Space ComplexitY : 
    public static int fun3(int[] arr,int k){
        // Instantiate DP
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;

        // Tabulation 
        for(int start=n-1;start>=0;start--){
            int max_ans = -1000000000, current_max = -1000000000, len = 0;
            for(int end=start;end<Math.min(arr.length,start+k);end++){
                len++;
                current_max = Math.max(current_max,arr[end]);
                int sum = len*current_max + dp[end+1];
                max_ans = Math.max(max_ans,sum);
            }
            dp[start] = max_ans;
        }
        return dp[0];
    }
    
    public static void main(String[] args) {
        // Expected Output : 84
        int[] arr = {1,15,7,9,2,5,10};
        int n = arr.length;
        int k = 3;
        // Using Recursive Code 
        System.out.println("The Maximum Sum Possible : " + fun1(0, arr, k));

        // Using Memoization Code 
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("The Maximum Sum Possible : " + fun2(0, arr, k,dp));

        // Using Tabulation Code 
        System.out.println("The Maximum Sum Possible : " + fun3(arr,k));
    }
}
