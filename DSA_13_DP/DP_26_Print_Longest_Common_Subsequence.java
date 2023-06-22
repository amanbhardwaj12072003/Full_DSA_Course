public class DP_26_Print_Longest_Common_Subsequence {

    // Using Iterative DP
    public static String fun(String s1 , String s2){
        // Instantiate DP
        int n1 = s1.length() , n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        // Base Tabulations 
        for(int i1=0;i1<=n1;i1++) dp[i1][0] = 0;
        for(int i2=0;i2<=n2;i2++) dp[0][i2] = 0;

        // Tabulations 
        for(int i1=1;i1<=n1;i1++){
            for(int i2=1;i2<=n2;i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }
                else dp[i1][i2] = Math.max(dp[i1-1][i2],dp[i1][i2-1]);
            }
        }
        StringBuilder lcs = new StringBuilder();
        int pointer1 = n1 , pointer2 = n2;
        while(pointer1>0 && pointer2>0){
            if(s1.charAt(pointer1-1)==s2.charAt(pointer2-1)){
                lcs.append(s1.charAt(pointer1-1));
                pointer1--;
                pointer2--;
            }
            else if(dp[pointer1][pointer2-1] > dp[pointer1-1][pointer2]) pointer2--;
            else pointer1--;
        }
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        // Expected Output : "adb"
        String s1 = "adebc";
        String s2 = "dcadb";
        System.out.println("Longest Common Subsequence : " + fun(s1,s2));
    }
}
