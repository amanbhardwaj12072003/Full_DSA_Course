import java.util.*;
public class DP_34_Wildcard_Matching {

    // Recursive Code 
    // Time Complexity : ~ O(2^(index1 + index2))..Exponential Time Complexity 
    // Space Complexity : O(index1 + index2)
    public static boolean fun1(String string1, int index1, String string2,int index2){
        // Base Case 
        if(index1 < 0 && index2 < 0) return true;
        if(index1 < 0 && index2 >= 0) return false; 
        if(index1 >= 0 && index2 < 0){
            for(int i=0;i<=index1;i++){
                if(string1.charAt(i) != '*') return false;
            }
            return true;
        }

        // Code 
        if(string1.charAt(index1)==string2.charAt(index2) || string1.charAt(index1) == '?'){
            return fun1(string1,index1-1,string2,index2-1);
        }
        if(string1.charAt(index1) == '*'){
            return fun1(string1,index1-1,string2,index2) || fun1(string1,index1,string2,index2-1); // This is crucial
        }
        return false;
    }

    // Memoization Code 
    // Time Complexity : 
    // Space COmplexity : 
    public static boolean fun2(String string1 , int index1, String string2, int index2 , int[][] dp){
        // Base Case 
        if(index1 < 0 && index2 < 0) return true;
        if(index1 < 0 && index2 >= 0) return false;
        if(index1 >= 0 && index2 < 0){
            for(int index=0;index<=index1;index++){
                if(string1.charAt(index) != '*') return false;
            }
            return true;
        }

        // Code 
        // -1 -> Not Calculated
        // 0 or 1 -> Calculated (0 -> Stores false) and (1 -> Stores true)
        if(dp[index1][index2] != -1) return dp[index1][index2] == 1;
        if((string1.charAt(index1) == string2.charAt(index2)) || (string1.charAt(index1) == '?')){
            dp[index1][index2] = (fun2(string1,index1-1,string2,index2-2,dp)) ? 1 : 0;
            return fun2(string1,index1-1,string2,index2-2,dp);
        }
        if(string1.charAt(index1) == '*'){
            dp[index1][index2] = (fun2(string1,index1-1,string2,index2,dp) || fun2(string1,index1,string2,index2-1,dp)) ? 1 : 0;
            return fun2(string1,index1-1,string2,index2,dp) || fun2(string1,index1,string2,index2-1,dp);
        }
        dp[index1][index2] = 0;
        return false;
    }

    public static void main(String[] args) {
        // Expected Output : True
        String string1 = "ba*a?";
        String string2 = "baaabab";
        int index1 = string1.length() , index2 = string2.length();

        // Using Recursion 
        System.out.println("Is Matching : " + fun1(string1,index1-1,string2,index2-1));

        // Using Memoization Code 
        int[][] dp = new int[index1][index2];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        System.out.println("Is Matching : " + fun2(string1,index1-1,string2,index2-1,dp));
        
    }
}
