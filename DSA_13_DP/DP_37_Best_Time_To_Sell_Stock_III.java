// It is a special case of DP on stocks_IV with total_transaction = 2;

import java.util.*;
public class DP_37_Best_Time_To_Sell_Stock_III {

    // Using Recursion 
    // Time Complexity : O(2^n)..Exponential Complexity
    // Space Complexity : O(n)..Recursive Stack Space   
    public static int fun1(int index,int canBuy,int total_transactions,int[] stock_prices){
        // Base Case 
        if(total_transactions == 0) return 0;
        if(index == stock_prices.length) return 0;

        // Code 
        if(canBuy == 1){
            int bought = -stock_prices[index] + fun1(index+1,0,total_transactions,stock_prices);
            int not_bought = -0 + fun1(index+1,1,total_transactions,stock_prices);
            return Math.max(bought,not_bought);
        }
        else{
            int sold = +stock_prices[index] + fun1(index+1,1,total_transactions-1,stock_prices);
            int not_sold = +0 + fun1(index+1,0,total_transactions,stock_prices);
            return Math.max(sold,not_sold);
        }
    }

    // Using Memoization
    // Time Complexity : O(n x 2 x 3) ~ O(n).linear complexity
    // Space Complexity : O(n) + O(n)..recursive stack space 
    public static int fun2(int index,int canBuy,int total_transactions,int[] stock_prices,int[][][] dp){
        // Base Case 
        if(total_transactions==0 ) return 0;
        if(index == stock_prices.length) return 0;

        // Code 
        if( dp[index][canBuy][total_transactions] != -1 ) return  dp[index][canBuy][total_transactions]; 
        if(canBuy == 1){
            int bought = -stock_prices[index] + fun2(index+1,0,total_transactions,stock_prices,dp);
            int not_bought = -0 + fun2(index+1,1,total_transactions,stock_prices,dp);
            return dp[index][canBuy][total_transactions] = Math.max(bought,not_bought);
        }
        else{
            int sold = stock_prices[index] + fun2(index+1,1,total_transactions-1,stock_prices,dp);
            int not_sold = +0 + fun2(index+1,0,total_transactions,stock_prices,dp);
            return dp[index][canBuy][total_transactions] =  Math.max(sold,not_sold);
        }
    }

    // Using Tabulation Code 
    // Time Complexity : O(n x 3 x 2) ~ O(n)
    // Space Complexity : O(n)
    public static int fun3(int[] stock_prices,int total_transactions){
        // Instantiate DP
        int n = stock_prices.length;
        int[][][] dp = new int[n+1][2][total_transactions+1];

        // Base Tabulation 
        for(int index=0;index<=n;index++) for(int canBuy=0;canBuy<2;canBuy++) dp[index][canBuy][0] = 0;
        for(int canBuy=0;canBuy<2;canBuy++) for(int transactions=0;transactions<=total_transactions;transactions++) dp[n][canBuy][transactions] = 0;

        // Tabulations 
        for(int index=n-1;index>=0;index--){
            for(int canBuy=1;canBuy>=0;canBuy--){
                for(int transactions=1;transactions<=total_transactions;transactions++){
                    if(canBuy == 1){
                        int bought = -stock_prices[index] + dp[index+1][0][transactions];
                        int not_bought = 0 + dp[index+1][1][transactions];
                        dp[index][canBuy][transactions] = Math.max(bought,not_bought);
                    }
                    else{
                        int sold = +stock_prices[index] + dp[index+1][1][transactions-1];
                        int not_sold = +0 + dp[index+1][0][transactions];
                        dp[index][canBuy][transactions] = Math.max(sold,not_sold);
                    }
                }
            }
        }
        return dp[0][1][total_transactions];
    }

    // Using Tabulation Code With Space Optimization 
    // Time Complexity : O(n x 3 x 2) ~ O(n)
    // Space Complexity : O(1)
    public static int fun4(int[] stock_prices,int total_transactions){
        // Instantiate DP
        int n = stock_prices.length;
        int[][] front = new int[2][total_transactions+1];
        int[][] curr = new int[2][total_transactions+1];

        // Base Tabulation 
        curr[1][0] = front[1][0] = 0;
        for(int canBuy=0;canBuy<2;canBuy++) for(int transactions=0;transactions<=total_transactions;transactions++) front[canBuy][transactions] = 0;

        // Tabulations 
        for(int index=n-1;index>=0;index--){
            for(int canBuy=1;canBuy>=0;canBuy--){
                for(int transactions=1;transactions<=total_transactions;transactions++){
                    if(canBuy == 1){
                        int bought = -stock_prices[index] + front[0][transactions];
                        int not_bought = 0 + front[1][transactions];
                        curr[canBuy][transactions] = Math.max(bought,not_bought);
                    }
                    else{
                        int sold = +stock_prices[index] + front[1][transactions-1];
                        int not_sold = +0 + front[0][transactions];
                        curr[canBuy][transactions] = Math.max(sold,not_sold);
                    }
                }
            }
            for(int i=1;i>=0;i--) for(int j=0;j<=total_transactions;j++) front[i][j] = curr[i][j];
        }
        return front[1][2]; 
    }

    // Memoization Code Using dp of dimension (n x 4)
    public static int fun5(int index, int transactions,int total_transactions, int[] stock_prices, int[][] dp){
        // Base Case 
        if(index == stock_prices.length || transactions == 2*total_transactions){
            return 0;
        }

        // Code 
        if(dp[index][transactions] != -1) return dp[index][transactions];
        if(transactions%2 == 0){
            int bought = -stock_prices[index] + fun5(index+1,transactions+1,total_transactions,stock_prices,dp);
            int not_bought = -0 + fun5(index+1,transactions,total_transactions,stock_prices,dp);
            return dp[index][transactions] = Math.max(bought,not_bought);
        }
        else{
            int sold = +stock_prices[index] + fun5(index+1,transactions+1,total_transactions,stock_prices,dp);
            int not_sold = +0 + fun5(index+1,transactions,total_transactions,stock_prices,dp);
            return dp[index][transactions] = Math.max(sold,not_sold);
        }
    }


    public static void main(String[] args) {
        // Expected Output : 6
        int[] stock_prices = {3, 3, 5, 0, 3, 1, 4};
        int n = stock_prices.length;
        int total_transactions = 2;

        // Using Recursion
        System.out.println("Maximum Possible Profit : " + fun1(0,1,total_transactions,stock_prices));

        // Using Memoization
        int[][][] dp = new int[n+1][2][total_transactions+1];
        for(int[][] temp1 : dp) for(int[] temp2 : temp1) Arrays.fill(temp2,-1);
        System.out.println("Maximum Possible Profit : " + fun2(0,1,total_transactions,stock_prices,dp));

        // Using Tabulation 
        System.out.println("Maximum Possible Profit : " + fun3(stock_prices, total_transactions));

        // Using Tabulation Space Optimization
        System.out.println("Maximum Possible Profit : " + fun4(stock_prices, total_transactions));

        // Memoization Using dp[n][4]
        int[][] dp_ = new int[2*n+1][4];
        Arrays.stream(dp_).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Maximum Possible Profit : " + fun5(0,0,total_transactions,stock_prices,dp_));

    }
}
