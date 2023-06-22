import java.util.*;
public class DP_52_Boolean_Evaluation_To_True {

    // Recurive Code 
    // Time Complexity : Exponential 
    // Space Complexity : O(n)
    public static int fun1(int begin,int end, int need, char[] arr){
        // Base Case 
        if(begin > end) return 0;
        if(begin == end) {
            if(need == 1) return (arr[begin] == 'T') ? 1 : 0;
            else return (arr[begin] == 'F') ? 1 : 0;
        }

        // Code 
        int count_ways = 0;
        for(int operation=begin+1;operation<=end-1;operation+=2){
            int left_T = fun1(begin, operation-1, 1, arr);
            int left_F = fun1(begin, operation-1, 0, arr);
            int right_T = fun1(operation+1, end, 1, arr);
            int right_F = fun1(operation+1, end, 0, arr);
            if(arr[operation] == '&'){
                if(need == 1) count_ways += left_T*right_T;
                else count_ways += left_F*right_T + left_T*right_F;
            }
            if(arr[operation] == '|'){
                if(need == 1) count_ways += left_F*right_T + left_T*right_F;
                else count_ways += left_F*right_F;
            }
            if(arr[operation] == '^'){
                if(need == 1) count_ways += left_F*right_T + left_T*right_F;
                else count_ways += left_T*right_T + left_F*right_F;
            }
        }
        return count_ways;
    }

    // Using Memoization 
    public static int fun2(int begin,int end, int need, char[] arr,int[][][] dp){
        // Base Case 
        if(begin > end) return 0;
        if(begin == end) {
            if(need == 1) return (arr[begin] == 'T') ? 1 : 0;
            else return (arr[begin] == 'F') ? 1 : 0;
        }

        // Code 
        if(dp[begin][end][need] != -1) return dp[begin][end][need];
        int count_ways = 0;
        for(int operation=begin+1;operation<=end-1;operation+=2){
            int left_T = fun2(begin, operation-1, 1, arr,dp);
            int left_F = fun2(begin, operation-1, 0, arr,dp);
            int right_T = fun2(operation+1, end, 1, arr,dp);
            int right_F = fun2(operation+1, end, 0, arr,dp);
            if(arr[operation] == '&'){
                if(need == 1) count_ways += left_T*right_T;
                else count_ways += left_F*right_T + left_T*right_F;
            }
            if(arr[operation] == '|'){
                if(need == 1) count_ways += left_F*right_T + left_T*right_F;
                else count_ways += left_F*right_F;
            }
            if(arr[operation] == '^'){
                if(need == 1) count_ways += left_F*right_T + left_T*right_F;
                else count_ways += left_T*right_T + left_F*right_F;
            }

        }
        return dp[begin][end][need] = count_ways;
    }

    // Tabulation Code 
    // Time Complexity : 
    // Space Complexiy : 
    public static int fun3(char[] arr){
        // Instantiate DP
        int n = arr.length;
        int[][][] dp = new int[n+1][n+1][2];

        // Tabulation 
        for(int begin=n-1;begin>=0;begin--){
            for(int end=0;end<=n-1;end++){
                for(int need=0;need<=1;need++){
                    if(begin > end){
                        dp[begin][end][need] = 0;
                    }
                    else if(begin == end){
                        if(need == 1) dp[begin][end][need] = (arr[begin] == 'T') ? 1 : 0;
                        else dp[begin][end][need] = (arr[begin] == 'F') ? 1 : 0;
                    }
                    else{
                        int count_ways = 0;
                        for(int operation=begin+1;operation<=end-1;operation+=2){
                            int left_T = dp[begin][operation-1][1];
                            int left_F = dp[begin][operation-1][0];
                            int right_T = dp[operation+1][end][1];
                            int right_F = dp[operation+1][end][0];
                            if(arr[operation] == '&'){
                                if(need == 1) count_ways += left_T*right_T;
                                else count_ways += left_F*right_T + left_T*right_F + left_F*right_F;
                            }
                            if(arr[operation] == '|'){
                                if(need == 1) count_ways += left_T*right_T + left_F*right_T + left_T*right_F;
                                else count_ways += left_F*right_F;
                            }
                            if(arr[operation] == '^'){
                                if(need == 1) count_ways += left_F*right_T + left_T*right_F;
                                else count_ways += left_T*right_T + left_F*right_F;
                            }
                
                        }
                        dp[begin][end][need] = count_ways;
                    }
                }
            }
        } 
        return dp[0][n-1][1];
    }

    public static void main(String[] args) {
        // Total number of ways to yield T : 2
        String input = "F|T^F";
        char[] arr = input.toCharArray();
        int n = arr.length;

        // Using Recursive Code
        System.out.println("The total number of ways to yield T : " + fun1(0, n-1, 1, arr));

        // Using Memoization Code 
        int[][][] dp = new int[n+1][n+1][2];
        for(int[][] demo : dp) for(int[] demo_ : demo) Arrays.fill(demo_,-1);
        System.out.println("The total number of ways to yield T : " + fun2(0, n-1, 1, arr,dp));

        // Using Tabulation Code 
        System.out.println("The total number of ways to yield T : " + fun3(arr));

    }
}
