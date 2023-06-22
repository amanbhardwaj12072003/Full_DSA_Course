import java.util.*;
public class DP_36_Best_Time_To_Sell_Stock_II {

    // Recursive Code 
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public static int fun1(int index , int canBuy, int[] stock_prices){
        // Base Case
        // Even if we bought the last stock then too we will return 0 as while taking maximum it will be
        // greater then a negeting value which we got on buying
        if(index == stock_prices.length) return 0;  
        // Code 
        if(canBuy == 1){
            int bought = -stock_prices[index] + fun1(index+1,0,stock_prices);
            int not_bought = 0 + fun1(index+1,1,stock_prices);
            return Math.max(bought,not_bought);
        }
        else{
            int sold = +stock_prices[index] + fun1(index+1,1,stock_prices);
            int not_sold = 0 + fun1(index+1,0,stock_prices);
            return Math.max(sold,not_sold);
        }
    }

    // Memoization Code 
    // Time Complexity : ~ O(n)
    // Space Complexity : O(n) + O(n)..Recursive Stack Space 
    public static int fun2(int index,int canBuy,int[] stock_prices,int[][] dp){
        // Base Case 
        if(index == stock_prices.length) return 0;

        // Code 
        if(dp[index][canBuy] != -1) return dp[index][canBuy];
        if(canBuy == 1){
            int bought = -stock_prices[index] + fun2(index+1,0,stock_prices,dp);
            int not_bought = 0 + fun2(index+1,1,stock_prices,dp);
            return dp[index][canBuy] = Math.max(bought,not_bought);
        }
        else{
            int sold = +stock_prices[index] + fun2(index+1,1,stock_prices,dp);
            int not_sold = +0 + fun2(index+1,0,stock_prices,dp);
            return dp[index][canBuy] = Math.max(sold,not_sold);
        }
    }

    // Tabulation Code 
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static int fun3(int[] stock_prices){
        // Instantiate DP
        int n = stock_prices.length;
        int[][] dp = new int[n+1][2];

        // Base Tabulation
        dp[n][0] = dp[n][1] = 0;

        for(int index=n-1;index>=0;index--){
            for(int canBuy=1;canBuy>=0;canBuy--){
                if(canBuy == 1){
                    int bought = -stock_prices[index] + dp[index+1][0];
                    int not_bought = -0 + dp[index+1][1];
                    dp[index][canBuy] = Math.max(bought,not_bought);

                }
                else{
                    int sold = +stock_prices[index] + dp[index+1][1];
                    int not_sold = +0 + dp[index+1][0];
                    dp[index][canBuy] = Math.max(sold,not_sold);
                }
            }
        }
        return dp[0][1];
    }

    // Tabulation Code With Space Optimization 
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public static int fun4(int[] stock_prices){
        // Instantiate DP
        int n = stock_prices.length;
        int[] front = new int[2];
        int[] curr=  new int[2];

        // Base Tabulations 
        front[0] = front[1] = 0;

        // Tabulations 
        for(int index=n-1;index>=0;index--){
            for(int canBuy=1;canBuy>=0;canBuy--){
                if(canBuy == 1){
                    int bought = -stock_prices[index] + front[0];
                    int not_bought = -0 + front[1];
                    curr[canBuy] = Math.max(bought, not_bought);
                }
                else{
                    int sold = +stock_prices[index] + front[1];
                    int not_sold = +0 + front[0];
                    curr[canBuy] = Math.max(sold,not_sold);
                }
            }
            front = Arrays.copyOfRange(curr,0,2);
        }
        return front[1];
    }

    // Tabulation Code With 4 Variables 
    public static int fun5(int[] stock_prices){
        // Instantiate DP
        int n = stock_prices.length;
        int front_can_buy = -1 , front_cant_buy = -1 , curr_can_buy = -1 , curr_cant_but = -1;

        // Base Tabulation
        front_can_buy = front_cant_buy = 0;

        // Tabulation 
        for(int index=n-1;index>=0;index--){
            curr_can_buy = Math.max(-stock_prices[index] + front_cant_buy,front_can_buy);
            curr_cant_but = Math.max(+stock_prices[index]+front_can_buy,front_cant_buy);
            front_can_buy = curr_can_buy;
            front_cant_buy = curr_cant_but;
        }
        return front_can_buy;
    }

    public static void main(String[] args) {
        int[] stock_prices = {1,2,3,4,5,6,7}; // Expected Output : 6
        int n = stock_prices.length;
        
        // Using Recursion 
        // Initially we have liberty to buy it hence passed 1
        System.out.println("The maximum possible profit : " + fun1(0,1,stock_prices));

        // Using Memoization Code 
        int[][] dp = new int[n+1][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("The maximum possible profit : " + fun2(0,1,stock_prices,dp));

        // Using Tabulation
        System.out.println("The Maximum possible profit : " + fun3(stock_prices));

        // Using Tabulation With Space Optimization
        System.out.println("The Maximum possible profit : " + fun4(stock_prices));

        // Using Tabulations With 4 Variables
        System.out.println("The Maximum possible profit : " + fun5(stock_prices));

    }
}
