import java.util.*;
public class DP_02_Jumping_Stairs {

    // Recursive Code 
    public static int jump(int n){
        // Base Case 
        if(n == 0) return 1;
        if(n == 1) return 1;

        // Code 
        int jump1 = jump(n-1);
        int jump2 = jump(n-2);
        return jump1 + jump2;  // Returning the total number of possible ways 
    }
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)

    // We have to understand that what fun(x) represents...number of ways to reach the xth stair  

    // Memoizaion code 
    public static int jump_1(int n , int[] dp){
        // Base Case 
        if(n == 0) return 1;
        if(n == 1) return 1;

        // Apply DP
        if(dp[n] != -1) return dp[n];

        // Code 
        return dp[n] = jump_1(n-1,dp) + jump_1(n-2,dp);
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n) + O(n) , {Recursive Stack Space + Memoization}

    // Tabulation Code 
    public static int jump_2(int n){
        // Instantiate DP
        int[] dp = new int[n+1];

        // Base Tabulation 
        dp[0] = 1;
        dp[1] = 1;

        // Code (Reverse Tabulation)
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n) , {Tabulation}

    // Space Optimisation In Tabulation
    public static int jump_3(int n){
        // Base Case 
        int jump1 = 1 , jump2 = 1;
        int current_jump = -1;
        for(int i=2;i<=n;i++){
            current_jump = jump1 + jump2;
            jump1 = jump2;
            jump2 = current_jump;
        }
        return current_jump;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(jump(n));
        System.out.println(jump_1(n,dp));
        System.out.println(jump_2(n));
        System.out.println(jump_3(n));


    }
}
