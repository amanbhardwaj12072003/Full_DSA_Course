import java.util.*;
public class DP_39_Best_Time_To_Sell_Stock_V_Cooldown {

    // Using Recursion 
    // Time Complexity : O(2^n)....Exponential Complexity
    // Space Complexity : O(n)
    public static int fun1(int index,int canBuy,int[] stock_prices){
        // Base Case 
        if(index >= stock_prices.length) return 0;

        // Code 
        if(canBuy == 1){
            int bought = -stock_prices[index] + fun1(index+1,0,stock_prices);
            int not_bought = -0 + fun1(index+1,1,stock_prices);
            return Math.max(bought,not_bought);
        }
        else{
            int sold = +stock_prices[index] + fun1(index+2,1,stock_prices);
            int not_sold = +0 + fun1(index+1,0,stock_prices);
            return Math.max(sold,not_sold);
        }
    }

    // Using Memoization 
    // Time Complexity : O(n x 2)
    // Space Complexity : O(n x 2) + O(n)..Recursive Stack Space
    public static int fun2(int index, int canBuy, int[] stock_prices,int[][] dp){
        // Base Case 
        if(index == stock_prices.length-1){
            if(canBuy == 1) return 0;
            else return stock_prices[stock_prices.length-1];
        }
        if(index == stock_prices.length) return 0;

        // Code 
        if(dp[index][canBuy] != -1) return dp[index][canBuy];
        if(canBuy == 1){
            int bought = -stock_prices[index] + fun2(index+1,0,stock_prices,dp);
            int not_bought = -0 + fun2(index+1,1,stock_prices,dp);
            return dp[index][canBuy] = Math.max(bought,not_bought);
        }
        else{
            int sold = +stock_prices[index] + fun2(index+2,1,stock_prices,dp);
            int not_sold = +0 + fun2(index+1,0,stock_prices,dp);
            return dp[index][canBuy] = Math.max(sold,not_sold);
        }
    }
    
    // Tabulation Code 
    public static int fun3(int[] stock_prices){
        // Instantiate DP
        int n = stock_prices.length;
        int[][] dp = new int[n+1][2];

        // Base Tabulations 
        dp[n][0] = dp[n][1] = 0;
        dp[n-1][0] = stock_prices[n-1];
        dp[n-1][1] = 0;

        // Tabulations 
        for(int index=n-2;index>=0;index--){
            for(int canBuy=1;canBuy>=0;canBuy--){
                if(canBuy==1){
                    int bought = -stock_prices[index] + dp[index+1][0];
                    int not_bought = -0 + dp[index+1][1];
                    dp[index][canBuy] = Math.max(bought,not_bought);
                }
                else{
                    int sold = +stock_prices[index] + dp[index+2][1];
                    int not_sold = +0 + dp[index+1][0];
                    dp[index][canBuy] = Math.max(sold,not_sold);
                }
            }
        }
        return dp[0][1];
    }

    // Tabulation Code 
    public static int fun4(int[] stock_prices){
        // Instantiate DP
        int n = stock_prices.length;
        int[] front1 = new int[2];
        int[] front2 = new int[2];
        int[] curr = new int[2];

        // Base Tabulations 
        front2[0] = front2[1] = 0;
        front1[0] = stock_prices[n-1];
        front1[1] = 0;

        // Tabulations 
        for(int index=n-2;index>=0;index--){
            for(int canBuy=1;canBuy>=0;canBuy--){
                if(canBuy==1){
                    int bought = -stock_prices[index] + front1[0];
                    int not_bought = -0 + front1[1];
                    curr[canBuy] = Math.max(bought,not_bought);
                }
                else{
                    int sold = +stock_prices[index] + front2[1];
                    int not_sold = +0 + front1[0];
                    curr[canBuy] = Math.max(sold,not_sold);
                }
            }
            front2 = Arrays.copyOfRange(front1, 0, 2);
            front1 = Arrays.copyOfRange(curr,0, 2);
        }
        return curr[1];
    }

    public static void main(String[] args) {
        // Expected Output : 15
        int[] stock_prices = {4, 5, 2, 10, 1, 15};
        int n = stock_prices.length;

        // Using Recursion 
        System.out.println("Maximum Possible Profit : " + fun1(0,1,stock_prices));

        // Using Memoization 
        int[][] dp = new int[n+1][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Maximum Possible Profit : " + fun2(0, 1, stock_prices, dp));
 
        // Using Tabulation
        System.out.println("Maximum Possible Profit : " + fun3(stock_prices));

        // Using Tabulation With Space Optimization
        System.out.println("Maximum Possible Profit : " + fun4(stock_prices));
        
    }
}
