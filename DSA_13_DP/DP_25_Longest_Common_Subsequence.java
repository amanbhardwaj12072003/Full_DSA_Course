import java.util.*;
public class DP_25_Longest_Common_Subsequence {

    // Recursive Code -> What fun() represent in the length of the longest subsequence in s1 upto index1 and in s2 upto index2
    // Time Complexity : O(2^n1 * 2^n2)
    // Space Complexity : O(n1 + n2)
    public static int fun1(int index1 , String s1 , int index2 , String s2){
        // Base Case 
        if(index1<0 || index2<0){
            return 0;
        }

        // Code 
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + fun1(index1-1,s1,index2-1,s2);
        }

        return Math.max(fun1(index1-1,s1,index2,s2) , fun1(index1,s1,index2-1,s2));
    }

    // Memoization Code 
    // Time Complexity : O(n1 x n2)
    // Space Complexity : O(n1 x n2) + O(n1 + n2)
    public static int fun2(int index1 , String s1 , int index2 , String s2 , int[][] dp){
        // Base Case 
        if(index1<0 || index2<0){
            return 0;
        }

        // Code 
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(s1.charAt(index1) == s2.charAt(index2)){
            return dp[index1][index2] = 1 + fun2(index1-1,s1,index2-1,s2,dp);
        }

        return dp[index1][index2] = Math.max(fun2(index1-1,s1,index2,s2,dp),fun2(index1,s1,index2-1,s2,dp));
    }

    // Tabulation Code -> Using the shifting of index
    // Time Complexity : O(n1 x n2)
    // Space Complexity : O(n1 x n2)
    public static int fun3(String s1 , String s2){
        // Instantiate DP
        int n1 = s1.length() , n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        // Base Tabulation 
        for(int i1=0;i1<=n1;i1++) dp[i1][0] = 0;
        for(int i2=0;i2<=n2;i2++) dp[0][i2] = 0;

        // Tabulations 
        for(int i1=1;i1<=n1;i1++){
            for(int i2=1;i2<=n2;i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }
                else{
                    dp[i1][i2] = Math.max(dp[i1-1][i2] , dp[i1][i2-1]);
                }
            }
        }
        return dp[n1][n2];
    }

    // Space Optimization In Tabulation 
    public static int fun4(String s1 , String s2){
        int n1 = s1.length() , n2 = s2.length();
        int[] prev = new int[n2+1];
        int[] curr = new int[n2+1];

        // Base Tabulation 
        for(int i2=0;i2<=n2;i2++) prev[i2] = 0;

        // Tabulations 
        for(int i1=1;i1<=n1;i1++){
            for(int i2=1;i2<=n2;i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    curr[i2] = 1 + prev[i2-1];
                }
                else{
                    curr[i2] = Math.max(prev[i2] , curr[i2-1]);
                }
            }
        }
        return curr[n2];
    }


    public static void main(String[] args) {
        // Expected Output : 3
        String s1 = "adebc";
        String s2 = "dcadb";
        int n1 = s1.length() , n2 = s2.length();

        // Using Recursion
        System.out.println("Length Of Longest Common Subsequence : " + fun1(n1-1,s1,n2-1,s2));

        // Using Memoization 
        int[][] dp = new int[n1][n2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println("Length Of Longest Common Subsequence : " + fun2(n1-1,s1,n2-1,s2,dp));

        // Using Tabulation 
        System.out.println("Length Of Longest Common Subsequence : " + fun3(s1,s2));

        // Using Tabulation with Space Optimization
        System.out.println("Length Of Longest Common Subsequence : " + fun3(s1,s2));
    }
}
