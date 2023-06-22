import java.util.*;

public class DP_32_Distinct_Subsequences {
    // Recursive Code 
    // Time Complexity : O(2^(index1+index2))
    // Space Complexity : O(index1 + index)
    public static int fun1(String string1,int index1 , String string2 , int index2){
        // Base Case 
        if(index2 < 0){
            return 1;    // We found one occurence
        }
        if(index1 < 0){
            return 0;   // string1 exhausted
        }

        // Code 
        if(string1.charAt(index1) == string2.charAt(index2)){
            return fun1(string1,index1-1,string2,index2-1) + fun1(string1,index1-1,string2,index2); // This is crucial 
        }
        else{
            return fun1(string1,index1-1,string2,index2);
        }
    }

    // Memoization Code 
    // Time Complexity : O(index1 x index2)
    // Space Complexity : O(index1 x index2) + O(index1 + index2) ....We can still eliminate this recursive stack space 
    public static int fun2(String string1 , int index1 , String string2 , int index2,int[][] dp){
        // Base Case 
        if(index2 < 0){
            return 1;
        }
        if(index1 < 0){
            return 0;
        }

        // Code 
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(string1.charAt(index1) == string2.charAt(index2)){
            return dp[index1][index2] = fun2(string1,index1-1,string2,index2-1,dp) + fun2(string1,index1-1,string2,index2,dp);
        }
        else{
            return dp[index1][index2] = fun2(string1,index1-1,string2,index2,dp);
        }
    }

    // Tabulation Code 
    // Time Complexity : O(index1 x index2)
    // Space Complexity : O(index1 x index2)
    public static int fun3(String string1 , String string2){
        // Instantiate DP
        int len1 = string1.length() , len2 = string2.length();
        int[][] dp = new int[len1+1][len2+1];

        // Base Tabulations 
        for(int index1=0;index1<=len1;index1++){
            dp[index1][0] = 1;
        }
        // Starting index2 from 1 is quite crucial
        for(int index2=1;index2<=len2;index2++){
            dp[0][index2] = 0;
        }

        // Tabulation Code 
        for(int index1=1;index1<=len1;index1++){
            for(int index2=1;index2<=len2;index2++){
                if(string1.charAt(index1-1)==string2.charAt(index2-1)){
                    dp[index1][index2] = dp[index1-1][index2-1] + dp[index1-1][index2];
                }
                else{
                    dp[index1][index2] = dp[index1-1][index2];
                }
            }
        }
        return dp[len1][len2];
    }

    // Tabulation Code With Space Optimizatio 
    // Time Complexity : O(index1 x index2)
    // Space COmplexity : O(index1) + O(index2)
    public static int fun4(String string1 , String string2){
        // Instantiate DP
        int len1 = string1.length() , len2 = string2.length();
        int[] prev = new int[len2+1];
        int[] curr = new int[len2+1];

        curr[0] = prev[0] = 1;
        for(int index2=1;index2<=len2;index2++){
            prev[index2] = 0;
        }

        // Tabulations 
        for(int index1=1;index1<=len1;index1++){
            for(int index2=1;index2<=len2;index2++){
                if(string1.charAt(index1-1)==string2.charAt(index2-1)){
                    curr[index2] = prev[index2-1] + prev[index2];
                }
                else{
                    curr[index2] = prev[index2];
                }
            }
            prev = Arrays.copyOfRange(curr,0,len2+1);
        }
        return prev[len2];

    }



    public static void main(String[] args) {
        // We have to find the number of distinct occurence of string2 in string1
        // Expected Output : 20
        String string1 = "dingdingdingding";
        String string2 = "ing";
        int index1 = string1.length(), index2 = string2.length();
        
        // Using Recursion 
        System.out.println("Number of distinct occurence of string 1 in string2 : " + fun1(string1,index1-1,string2,index2-1));

        // Memoization Code 
        int[][] dp = new int[index1][index2];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        System.out.println("Number of distinct occurence of string 1 in string2 : " + fun2(string1,index1-1,string2,index2-1,dp));

        // Using Tabulation Code 
        System.out.println("Number of distinct occurence of string 1 in string2 : " + fun3(string1,string2));

        // Using Tabulation With Space Optimization Code 
        System.out.println("Number of distinct occurence of string 1 in string2 : " + fun4(string1,string2));

    }
}
