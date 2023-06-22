import java.util.*;
public class DP_23_Unbounded_Knapsack {

    // Recursive Code 
    public static int fun1(int index , int capacity , int[] weight , int[] value){
        // Base Case 
        if(index == 0) return (capacity/weight[0])*value[0];

        // Code 
        int notPick = 0 + fun1(index-1,capacity,weight,value);
        int pick = Integer.MIN_VALUE;
        if(weight[index] <= capacity) pick = value[index] + fun1(index,capacity-weight[index],weight,value);
        return Math.max(pick , notPick);
    }

    public static int fun2(int index , int capacity , int[] weight , int[] value , int[][] dp){
        // Base Case 
        if(index == 0) return (capacity/weight[0])*value[0];

        // Code 
        if(dp[index][capacity] != -1) return dp[index][capacity];
        int notPick = 0 + fun2(index-1,capacity,weight,value,dp);
        int pick = Integer.MIN_VALUE;
        if(weight[index] <= capacity) pick = value[index] + fun2(index,capacity-weight[index],weight,value,dp);
        return dp[index][capacity] = Math.max(pick,notPick);
    }


    public static void main(String[] args) {
        // Expected OutPut : 28
        int[] value = {3, 4, 5, 1};
        int[] weight = {4, 1, 2, 3};
        int n = value.length;
        int capacity = 7;

        // Using Recursion 
        System.out.println("Maximum Value ToBe Stolen : " + fun1(n-1,capacity,weight,value));

        
    }
}
