public class DP_27_Longest_Common_SubString {

    public static int fun(String s1 , String s2){
        // Instantiate DP
        int n1 = s1.length() , n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        // Base Tabulations 
        for(int i1=0;i1<=n1;i1++) dp[i1][0] = 0;
        for(int i2=0;i2<=n2;i2++) dp[0][i2] = 0;

        // Tabulations 
        int maxLen = 0;
        for(int i1=1;i1<=n1;i1++){
            for(int i2=1;i2<=n2;i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                    maxLen = Math.max(maxLen,dp[i1][i2]);
                }
                else dp[i1][i2] = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // Expected OutPut : 3
        String s1 = "wasdijkl";
        String s2 = "wsdjkl";
        System.out.println("Length Of Longest Common SubString : " + fun(s1,s2));
    }
}
