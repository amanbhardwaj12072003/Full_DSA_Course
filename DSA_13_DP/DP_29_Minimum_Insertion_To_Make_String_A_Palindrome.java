public class DP_29_Minimum_Insertion_To_Make_String_A_Palindrome {

    public static int lcs(String s1 , String s2){
        int n1 = s1.length() , n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        // Base Tabulations 
        for(int i=0;i<=n1;i++) dp[i][0] = 0;
        for(int j=0;j<=n2;j++) dp[0][j] = 0;

        // Tabulations 
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];   
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int len = 0 , pointer1 = n1 , pointer2 = n2;
        while(pointer1>0 && pointer2>0){
            if(s1.charAt(pointer1-1)==s2.charAt(pointer2-1)){
                len++;
                pointer1--;
                pointer2--;
            }
            else if(dp[pointer1][pointer2-1] > dp[pointer1-1][pointer2]) pointer2--;
            else pointer1--;
        }
        return len;
    }

    public static void main(String[] args) {
        // Expected Output : 2
        // Logic -> Keep the existing palindrome intact...and pair up the remaining one
        String string = "abcda";
        StringBuilder reverse = new StringBuilder(string);
        String reverse_string = reverse.reverse().toString();
        int minimum_required_insertion = string.length() - lcs(string,reverse_string);
        System.out.println("Minimum Operations Needed : " + minimum_required_insertion);
    }
}
