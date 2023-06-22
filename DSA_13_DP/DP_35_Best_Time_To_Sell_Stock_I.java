public class DP_35_Best_Time_To_Sell_Stock_I {

    private static int max(int num1,int num2){
        return Math.max(num1,num2);
    }

    private static int min(int num1,int num2){
        return Math.min(num1,num2);
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        int minBuyPrice = prices[0]; // Bought at day 0 
        for(int sell=1;sell<len;sell++){
            int currentPrice = prices[sell];
            int currentProfit = currentPrice - minBuyPrice;
            maxProfit = max(maxProfit,currentProfit);
            minBuyPrice = min(minBuyPrice,currentPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stock_prices = {17, 20, 11, 9, 12, 6};
        System.out.println("Maximum Possible Profit : " + maxProfit(stock_prices));
    }
}
