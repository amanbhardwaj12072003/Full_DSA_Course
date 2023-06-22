public class DP_31_Shortest_Common_Supersequence {
    public static String fun(String s1 , String s2){
        // Instantiate DP
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

        // Lets Make Shortest Superstring from the dp
        StringBuilder string = new StringBuilder();
        int pointer1 = n1 , pointer2 = n2;
        while(pointer1>0 && pointer2>0){
            if(s1.charAt(pointer1-1)==s2.charAt(pointer2-1)){
                string.append(s1.charAt(pointer1-1));
                pointer1--;
                pointer2--;
            }
            else if(dp[pointer1-1][pointer2] > dp[pointer1][pointer2-1]){
                string.append(s1.charAt(pointer1-1));
                pointer1--;
            }
            else{
                string.append(s2.charAt(pointer2-1));
                pointer2--;
            }
        }
        while(pointer1>0){
            string.append(s1.charAt(pointer1-1));
            pointer1--;
        }
        while(pointer2>0){
            string.append(s2.charAt(pointer2-1));
            pointer2--;
        }

        // Return the reversed string
        return string.reverse().toString();
    }
    public static void main(String[] args) {
        String string1 = "brute";
        String string2 = "groot";
        System.out.println("The Shortest SuperString : " + fun(string1,string2));
    }
}
