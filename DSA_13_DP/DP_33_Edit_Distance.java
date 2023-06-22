import java.util.*;
public class DP_33_Edit_Distance {

    // Recursive Code 
    // Time Complexity : O(3^idnex1 x 3^index2)..Exponential
    // Space Complexity : O(index1 + index2)
    public static int fun1(String string1 , int index1, String string2, int index2){
        // Base Case 
        if(index1 < 0) return index2+1;
        if(index2 < 0) return index1+1;

        // Code 
        if(string1.charAt(index1)==string2.charAt(index2)){
            return fun1(string1,index1-1,string2,index2-1);
        }
        else{
            int delete = 1 + fun1(string1,index1-1,string2,index2);
            int replace = 1 + fun1(string1,index1-1,string2,index2-1);
            int insert = 1 + fun1(string1,index1,string2,index2-1);
            return Math.min(delete,Math.min(replace,insert));
        }
    }

    // Memoization Code
    // Time Complexity : O(index1 x index2)
    // Space COmplexity : O(index1 x index2) + O(index1 + index2)
    public static int fun2(String string1 , int index1 , String string2, int index2 , int[][] dp){
        // Base Case 
        if(index1 < 0) return index2+1;
        if(index2 < 0) return index1+1;

        // Code 
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(string1.charAt(index1) == string2.charAt(index2)){
            return dp[index1][index2] = fun2(string1,index1-1,string2,index2-1,dp);
        }
        else{
            int delete = 1 + fun2(string1,index1-1,string2,index2,dp);
            int insert = 1 + fun2(string1,index1,string2,index2-1,dp);
            int replace = 1 + fun2(string1,index1-1,string2,index2-1,dp);
            return dp[index1][index2] = Math.min(delete,Math.min(replace,insert));
        }
    }

    // Tabulation Code 
    // Time Complexity : O(index1 x index2)
    // Space Complexity : O(index1 + index2)
    public static int fun3(String string1 , String string2){
        // Instantiate DP
        int len1 = string1.length() , len2 = string2.length();
        int[][] dp = new int[len1+1][len2+1];

        // Base Tabulations 
        for(int index1=0;index1<=len1;index1++) dp[index1][0] = index1;
        for(int index2=0;index2<=len2;index2++) dp[0][index2] = index2;

        // Tabulations 
        for(int index1=1;index1<=len1;index1++){
            for(int index2=1;index2<=len2;index2++){
                if(string1.charAt(index1-1) == string2.charAt(index2-1)){
                    dp[index1][index2] = dp[index1-1][index2-1];
                }
                else{
                    int delete = 1 + dp[index1-1][index2];
                    int replace = 1 + dp[index1-1][index2-1];
                    int insert = 1 + dp[index1][index2-1];
                    dp[index1][index2] = Math.min(delete,Math.min(replace,insert));
                }
            }
        }
        return dp[len1][len2];
    }

    // Tabulation Code With Space Optimization 
    // Time Complexity : O(index1 x index2)
    // Space Complexity : O(index2+1) + O(index2+1)
    public static int fun4(String string1 , String string2){
        // Instantiate DP
        int len1 = string1.length() , len2 = string2.length();
        int[] prev = new int[len2+1];
        int[] curr = new int[len2+1];


        // Base Tabulations 
        for(int index2=0;index2<=len2;index2++) prev[index2] = index2;

        // Tabulations 
        for(int index1=1;index1<=len1;index1++){
            curr[0] = index1;
            for(int index2=1;index2<=len2;index2++){
                if(string1.charAt(index1-1) == string2.charAt(index2-1)){
                    curr[index2] = prev[index2-1];
                }
                else{
                    int delete = 1 + prev[index2];
                    int replace = 1 + prev[index2-1];
                    int insert = 1 + curr[index2-1];
                    curr[index2] = Math.min(delete,Math.min(replace,insert));
                }
            }
            prev = Arrays.copyOfRange(curr,0,len2+1);
        }
        return prev[len2];
    }

    public static void main(String[] args) {
        // Allowed Operations -> Insert/Delete/Replace
        // Return the minimum number of operations to convert string1 -> string2
        // Expected Output : 9
        String string1 = "whgtdwhgtdg";
        String string2 = "aswcfg";
        int index1 = string1.length() , index2 = string2.length();

        // Using Recursion 
        System.out.println("The Minimum Number Of Operations Needed : " + fun1(string1,index1-1,string2,index2-1));

        // Using Memoization 
        int[][] dp = new int[index1][index2];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        System.out.println("The Minimum Number Of Operations Needed : " + fun2(string1,index1-1,string2,index2-1,dp));

        // Using Tabulation 
        System.out.println("The Minimum Number Of Operations Needed : " + fun3(string1,string2));

        // Using Tabulation With Space Optimization
        System.out.println("The Minimum Number Of Operations Needed : " + fun4("a","ab"));

    }
}
