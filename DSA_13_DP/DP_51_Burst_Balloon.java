import java.util.*;
public class DP_51_Burst_Balloon {

    // Recursive Code 
    // Time Complexity : Exponential 
    // Space Complexity : O(n)
    public static int fun1(int begin,int end,List<Integer> coins){
        // Base Case 
        if(begin > end) return 0;

        // Code 
        int max_cost = -1000000000;
        for(int last_burst=begin;last_burst<=end;last_burst++){
            int cost = (coins.get(begin-1) * coins.get(last_burst) * coins.get(end+1)) + 
            (fun1(begin, last_burst-1, coins) + fun1(last_burst+1, end, coins));
            if(cost > max_cost) max_cost = cost;
        }
        return max_cost;
    }

    // Memoization Code 
    // Time Complexity : O(n x n) x O(n)
    // Space Complexity : O(n x n)
    public static int fun2(int begin,int end,List<Integer> coins,int[][] dp){
        // Base Case 
        if(begin > end) return 0;

        // Code 
        if(dp[begin][end] != -1) return dp[begin][end];
        int max_cost = -1000000000;
        for(int last=begin;last<=end;last++){
            int cost = coins.get(begin-1)*coins.get(last)*coins.get(end+1) + 
            (fun2(begin, last-1, coins, dp) + fun2(last+1, end, coins, dp));
            if(cost > max_cost) max_cost = cost;
        }
        return dp[begin][end] = max_cost;
    }

    // Tabulation Code 
    // Time Compelxity : 
    // Space Complexity : 
    public static int fun3(List<Integer> coins){
        // Instantiate DP
        int n = coins.size()-2;
        int[][] dp = new int[n+2][n+2];

        //  Tabulations 
        for(int begin=n;begin>=1;begin--){
            for(int end=1;end<=n;end++){
                if(begin > end) dp[begin][end] = 0;
                else{     
                    int max_cost = -1000000000;
                    for(int last=begin;last<=end;last++){
                        int cost = coins.get(begin-1)*coins.get(last)*coins.get(end+1) + 
                        (dp[begin][last-1] + dp[last+1][end]);
                        if(cost > max_cost) max_cost = cost;
                    }
                    dp[begin][end] = max_cost;   
                }         
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        // Expected Output : 110
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> coins = new ArrayList<>();
        for(int item : arr) coins.add(item);
        int n = arr.length;
        coins.add(0,1);
        coins.add(1);

        // Using Recursion Code 
        System.out.println("The Maximum Coins Possible To Earn : " + fun1(1, n, coins));

        // Using Memoization Code 
        int[][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("The Maximum Coins Possible To Earn : " + fun2(1,n,coins,dp));

        // Using Tabulations Code 
        System.out.println("The Maximum Coins Possible To Earn : " + fun3(coins));

    }
}
