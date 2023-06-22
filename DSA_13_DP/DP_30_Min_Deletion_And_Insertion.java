import java.util.*;
public class DP_30_Min_Deletion_And_Insertion {

    // Recursive Code 
    public static int lcs1(String s1, int index1,String s2,int index2){
        // Base Case 
        if(index1<0 || index2<0) return 0;

        // Code 
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + lcs1(s1,index1-1,s2,index2-1);
        }
        return Math.max(lcs1(s1,index1-1,s2,index2) , lcs1(s1,index1,s2,index2-1));
    }

    // Memoization Code 
    public static int lcs2(String s1, int index1,String s2,int index2 , int[][] dp){
        // Base Case 
        if(index1<0 || index2<0) return 0;

        // Code 
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + lcs1(s1,index1-1,s2,index2-1);
        }
        return dp[index1][index2] = Math.max(lcs1(s1,index1-1,s2,index2) , lcs1(s1,index1,s2,index2-1));
    }

    // Tabulations Code 
    public static int lcs3(String s1 , String s2){
        // Instantiate DP
        int n1 = s1.length() , n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        // Base Tabulations 
        for(int i=0;i<=n1;i++) dp[i][0] = 0;
        for(int j=0;j<=n2;j++) dp[0][j] = 0;

        // Tabulations 
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }


    public static void main(String[] args) {
        String string1 = "edl";
        String string2 = "xcqja";
        // Expected OutPut : 8
        // Logic : [len(string1) - len(lcs(string1,string2))] + [len(string2) - len(lcs(string1,string2))] 
        int deletions1 = string1.length() - lcs1(string1,string1.length()-1,string2,string2.length()-1);
        int insertions1 = string2.length() - lcs1(string1,string1.length()-1,string2,string2.length()-1);
        int min_opeation1 = deletions1 + insertions1;
        System.out.println("Minimum Operations To Convert string 1 to string2 : " + min_opeation1);

        int[][] dp = new int[string1.length()+1][string2.length()+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        int deletions2 = string1.length() - lcs2(string1,string1.length()-1,string2,string2.length()-1,dp);
        int insertions2 = string2.length() - lcs2(string1,string1.length()-1,string2,string2.length()-1,dp);
        int min_opeation2 = deletions2 + insertions2;
        System.out.println("Minimum Operations To Convert string 1 to string2 : " + min_opeation2);

        int deletions3 = string1.length() - lcs3(string1,string2);
        int insertions3 = string2.length() - lcs3(string1,string2);
        int min_opeation3 = deletions3 + insertions3;
        System.out.println("Minimum Operations To Convert string 1 to string2 : " + min_opeation3);
    }
}
