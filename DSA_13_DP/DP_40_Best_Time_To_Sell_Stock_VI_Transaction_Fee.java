import java.util.*;
public class DP_40_Best_Time_To_Sell_Stock_VI_Transaction_Fee {

    // Using Recursion 
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public static int fun1(int index,int canBuy,int[] stock_prices, int transaction_fee){
        // Base Case 
        if(index == stock_prices.length) return 0;

        // Code 
        if(canBuy == 1){
            int bought = -stock_prices[index] + fun1(index+1,0,stock_prices,transaction_fee);
            int not_bought = -0 + fun1(index+1,1,stock_prices,transaction_fee);
            return Math.max(bought,not_bought);
        }
        else{
            int sold = +stock_prices[index] - transaction_fee + fun1(index+1,1,stock_prices,transaction_fee);
            int not_sold = +0 + fun1(index+1,0,stock_prices,transaction_fee);
            return Math.max(sold,not_sold);
        }
    }

    // Using Memoization
    // Time Complexity : O(n x 2)
    // Space Complexity : O(n x 2) + O(n)...recursive stack space 
    public static int fun2(int index,int canBuy,int[] stock_prices,int transaction_fee, int[][] dp){
        // Base Case 
        if(index == stock_prices.length) return 0;

        // Code 
        if(dp[index][canBuy] != -1) return dp[index][canBuy];
        if(canBuy == 1){
            int bought = -stock_prices[index] + fun2(index+1,0,stock_prices,transaction_fee,dp);
            int not_bought = -0 + fun2(index+1,1,stock_prices,transaction_fee,dp);
            return dp[index][canBuy] = Math.max(bought,not_bought);
        }
        else{
            int sold = +stock_prices[index] - transaction_fee + fun2(index+1,1,stock_prices,transaction_fee,dp);
            int not_sold = +0 + fun2(index+1,0,stock_prices,transaction_fee,dp);
            return dp[index][canBuy] = Math.max(sold,not_sold);
        }
    }

    // Using Tabulation 
    // Time Complexity : O(n x 2)
    // Space Complexity : O(n x 2)
    public static int fun3(int[] stock_prices,int transaction_fee){
        // Instantiate DP
        int n = stock_prices.length;
        int[][] dp = new int[n+1][2];

        // Base Tabulation 
        dp[n][0] = dp[n][1] = 0;

        // Tabulations 
        for(int index=n-1;index>=0;index--){
            for(int canBuy=1;canBuy>=0;canBuy--){
                if(canBuy == 1){
                    int bought = -stock_prices[index] + dp[index+1][0];
                    int not_bought = -0 + dp[index+1][1];
                    dp[index][canBuy] = Math.max(bought,not_bought);
                }
                else{
                    int sold = +stock_prices[index] - transaction_fee + dp[index+1][1];
                    int not_sold = +0 + dp[index+1][0];
                    dp[index][canBuy] = Math.max(sold,not_sold);
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        // Expected Output : 3
        int[] stock_prices = {6, 3, 1, 3, 5, 6};
        int transaction_fee = 2;

        // Using Recursion 
        System.out.println("Maximum Possible Profit Including The Transaction Fee : " + fun1(0,1,stock_prices,transaction_fee));

        // Using Memoization 
        int n = stock_prices.length;
        int[][] dp = new int[n+1][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Maximum Possible Profit Including The Transaction Fee : " + fun2(0,1,stock_prices,transaction_fee,dp));

        // Using Tabulation 
        System.out.println("Maximum Possible Profit Including The Transaction Fee : " + fun3(stock_prices,transaction_fee));

    }
}
