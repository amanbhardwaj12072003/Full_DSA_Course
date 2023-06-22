import java.util.*;
public class DP_48_Partition_DP_Matrix_Chain_Multiplication {
    
    // Using Recursion 
    // Time Complexity : Exponential
    public static int fun1(int begin, int end, int[] dimensions){
        // Base Case 
        if(begin == end) return 0;

        // Code 
        int minimum_multiplication = 1000000000;
        for(int k=begin;k<end;k++){
            int number_of_multiplication = dimensions[begin-1]*dimensions[k]*dimensions[end] + 
            fun1(begin, k, dimensions) + fun1(k+1, end, dimensions);      
            if(number_of_multiplication < minimum_multiplication){
                minimum_multiplication = number_of_multiplication;
            }
        }
        return minimum_multiplication;
    }

    // Using Memoization 
    // Time Complexity : O(n x n x n)
    // Space Complexity : O(n x n) + O(n)
    public static int fun2(int begin,int end,int[] dimensions,int[][] dp){
        // Base Case 
        if(begin == end) return 0;

        // Code 
        if(dp[begin][end] != -1) return dp[begin][end];
        int minimum_multiplication = 1000000000;
        for(int k=begin;k<end;k++){
            int number_of_multiplication = dimensions[begin-1]*dimensions[k]*dimensions[end] + 
            fun1(begin, k, dimensions) + fun1(k+1, end, dimensions);
            if(number_of_multiplication < minimum_multiplication) minimum_multiplication = number_of_multiplication;

        }
        return dp[begin][end] = minimum_multiplication;
    }

    // Using Tabulation 
    public static int fun3(int[] dimensions){
        // Instantiate DP
        int len = dimensions.length;
        int[][] dp = new int[len][len];

        // Tabulation 
        // We could also start end = 1 but that does not makes sense 
        for(int begin=len-1;begin>=1;begin--){
            for(int end=begin+1;end<=len-1;end++){
                if(begin == end){
                    dp[begin][end] = 0;
                }
                else{
                    int minimum_multiplication = 1000000000;
                    for(int k=begin;k<end;k++){
                        int number_of_multiplication = dimensions[begin-1]*dimensions[k]*dimensions[end] + 
                        dp[begin][k] + dp[k+1][end];
                        if(number_of_multiplication < minimum_multiplication) minimum_multiplication = number_of_multiplication;
                    }
                    dp[begin][end] = minimum_multiplication;
                }
            }
        }
        return dp[1][len-1];
    }

    public static void main(String[] args) {
        // (10x15), (15x20), (20x25) Expected Output
        int[] dimensions = {10, 15, 20, 25};
        int len = dimensions.length;
        // Using Recursion 
        System.out.println("The Minimum Number Of Multiplication Needed For Matrix Multiplication : " + fun1(1, len-1, dimensions));

        // Using Memoization
        int[][] dp = new int[len][len];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("The Minimum Number Of Multiplication Needed For Matrix Multiplication : " + fun2(1, len-1, dimensions,dp));

        // Using Tabulation 
        System.out.println("The Minimum Number Of Multiplication Needed For Matrix Multiplication : " + fun3(dimensions));

    }
}
