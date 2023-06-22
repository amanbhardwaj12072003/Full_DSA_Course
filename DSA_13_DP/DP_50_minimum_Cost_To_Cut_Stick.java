import java.util.*;
public class DP_50_minimum_Cost_To_Cut_Stick {

    // Recursive Code 
    // Time Complexity : Exponential 
    // Space Complexity : O(n)
    public static int fun1(int begin,int end,List<Integer> cuts){
        // Base Case 
        if(begin > end) return 0;

        // Code
        int minimum = 1000000000;
        for(int cut=begin;cut<=end;cut++){
            int cost = (cuts.get(end+1) - cuts.get(begin-1)) + fun1(begin, cut-1, cuts) + fun1(cut+1, end, cuts); 
            minimum = Math.min(minimum,cost);
        } 
        return minimum;
    }

    // Memoization Code 
    // Time Complexity : O(n x n)*O(n) ~ O(n^3)
    // Space Complexity : O(n x n) + O(n)
    public static int fun2(int begin,int end,List<Integer> cuts,int[][] dp){
        // Base 
        if(begin > end) return 0;

        // Code 
        if(dp[begin][end] != -1) return dp[begin][end];
        int minimum = 1000000000;
        for(int cut=begin;cut<=end;cut++){
            int cost = (cuts.get(end+1)-cuts.get(begin-1)) + fun2(begin,cut-1,cuts,dp) + fun2(cut+1,end,cuts,dp);
            if(cost < minimum) minimum = cost;
        }
        return dp[begin][end] = minimum;
    }

    // Tabulation Code 
    // Time Complexity : 
    // Space Complexity : 
    public static int fun3(List<Integer> cuts){
        // Instantiate DP
        int n = cuts.size()-2;
        int[][] dp = new int[n+2][n+2];

        // Tabulations 
        for(int begin=n;begin>=1;begin--){
            for(int end=1;end<=n;end++){
                if(begin > end){
                    dp[begin][end] = 0;
                }
                else{
                    int minimum = 1000000000;
                    for(int cut=begin;cut<=end;cut++){
                        int cost = (cuts.get(end+1)-cuts.get(begin-1)) + dp[begin][cut-1] + dp[cut+1][end];
                        if(cost < minimum) minimum = cost;
                    }
                    dp[begin][end] = minimum;                    
                }
            }
        }

        return dp[1][n];
    } 

    public static void main(String[] args) {
        // Expected Output : 23
        int len = 10;
        int[] cuts_ = {1, 3, 4, 7};
        List<Integer> cuts = new ArrayList<>();
        for(int item : cuts_) cuts.add(item);
        int n = cuts.size();
        Collections.sort(cuts);
        cuts.add(0,0);
        cuts.add(len);

        // Using Recursion 
        System.out.println("The Minimum Cost Of Cutting Stick : " + fun1(1, n, cuts));

        // Using Memoization 
        int[][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("The Minimum Cost Of Cuttinh Stick : " + fun2(1,n,cuts,dp));

        // Using Tabulation 
        System.out.println("The Minimum Cost Of Cutting Stick : " + fun3(cuts));

        // Using Tabulation With Space Optimization 
    }
}