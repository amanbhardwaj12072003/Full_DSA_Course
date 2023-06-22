import java.util.*;
public class DP_53_Palindrome_Partitioning_II {

    // Code To Find String Palindrome
    public static boolean isPalindrome(String string){
        int i = 0 , j = string.length()-1;
        while(i <= j){
            if(string.charAt(i) != string.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    // Using Recursive Code 
    // Time Complexity : Exponential 
    // Space Complexity : O(n)
    public static int fun1(int start,String string){
        // Base Case 
        if(start == string.length()) return 0;
    
        // Code 
        String temp = "";
        int min_partitions = 1000000000;
        for(int end=start;end<string.length();end++){
            temp += string.charAt(end);
            if(isPalindrome(temp)){
                int new_partitions = 1 + fun1(end+1,string);
                min_partitions = Math.min(min_partitions,new_partitions);
            }
        }
        return min_partitions;
    }

    // Using Memoization Code 
    public static int fun2(int start,String string,int [] dp){
        // Base Case 
        if(start == string.length()) return 0;

        // Code 
        if(dp[start] != -1) return dp[start];
        String temp = "";
        int min_partitions = 1000000000;
        for(int end=start;end<string.length();end++){
            temp += string.charAt(end);
            if(isPalindrome(temp)){
                int new_partitions = 1 + fun2(end+1, string, dp);
                min_partitions = Math.min(min_partitions,new_partitions);
            }
        }
        return dp[start] = min_partitions;
    }

    // Using Tabulation 
    public static int fun3(String string){
        // Instantiate DP
        int n = string.length();
        int[] dp = new int[n+1];
        dp[n] = 0;

        // Tabulation 
        for(int start=n-1;start>=0;start--){
            String temp = "";
            int min_partitions = 1000000000;
            for(int end=start;end<string.length();end++){
                temp += string.charAt(end);
                if(isPalindrome(temp)){
                    int new_partitions = 1 + dp[end+1];
                    min_partitions = Math.min(min_partitions,new_partitions);
                }
            }
            dp[start] = min_partitions;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        // Expected Output : 7
        String string = "aab";
        int n = string.length();

        // We Use Front Partition Algorithm 

        // Using Recursion 
        System.out.println("Minimum Number Of Partitions Needed : " + fun1(1, string));

        // Using Memoization 
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("Minimum Number Of Partitions Needed : " + fun2(1, string,dp));

        // Using Tabulation 
        System.out.println("Minimum Number Of Partitions Needed : " + fun3(string));
    }
}
