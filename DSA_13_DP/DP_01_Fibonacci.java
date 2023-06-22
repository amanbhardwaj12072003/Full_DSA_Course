import java.util.*;
public class DP_01_Fibonacci {

    // Recursive Code 
    public static int fib(int n){
        // Base Case
        if(n <= 1) return n;

        // Code 
        return fib(n-1) + fib(n-2);
    }
    
    // Memoization (Top Down Approach) , (Query --> Base Case)
    public static int fib_1(int n,int[] dp){

        // Base Case 
        if(n <= 1) return n;

        // Code 
        if(dp[n] != -1) return dp[n];
        return dp[n] = fib_1(n-1,dp) + fib_1(n-2,dp);
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n) + O(n) , {Stack Space  + Array Used}      
    
    // Tabulation (Bottom Up Approach) , (Base Case --> Query)
    // Direct ye sochna seekhna padega yarrrrr
    public static int fib_2(int n){
        int[] dp = new int[n+1];
        
        // Base Case
        dp[0] = 0;
        dp[1] = 1;

        // Tabulation
        for(int i=2;i<=n;i++) dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n) , {Tabulation}

    // Optimising The Space Of Tabulation
    public static int fib_3(int n){
        int prev1 = 1 , prev2 = 0;
        int curr = -1;
        for(int i=2;i<=n;i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    } 
    // Time Complexity : O(n)
    // Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fib(n));
        System.out.println(fib_1(n,dp));
        System.out.println(fib_2(5));
        System.out.println(fib_3(5));
    }
}
