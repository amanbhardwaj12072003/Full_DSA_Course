import java.util.Arrays;

public class DP_06_House_Robber {

    // Recursive Approach 
    public static int fun1(int index , int[] houses){
        // Base Case 
        if(index == 0) return houses[0];
        if(index < 0) return 0;

        // Code 
        int pick = houses[index] + fun1(index-2,houses);
        int notPick = 0 + fun1(index-1 , houses);

        // Return the best 
        return Math.max(pick,notPick);
    }
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)

    // Memoization 
    public static int fun2(int index , int[] houses , int[] dp){
        // Base Case 
        if(index == 0) return houses[0];
        if(index < 0) return 0;

        // Code 
        if(dp[index] != -1) return dp[index]; 
        int pick = houses[index] + fun2(index-2,houses,dp);
        int notPick = 0 + fun2(index-1,houses,dp);

        // Return the max along with storing in dp
        return dp[index] = Math.max(pick,notPick);
    }
    // Time Complexityu : O(n)
    // Space Complexity : O(n) + O(n)

    // Tabulation 
    public static int fun3(int[] houses){
        // Instantiate the dp
        int n = houses.length;
        int[] dp = new int[n];

        // Base Case 
        dp[0] = houses[0];
        for(int i=1;i<n;i++){
            int pick = (i > 1) ? houses[i] + dp[i-2] : houses[i] + 0;
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[n-1];
    }
    // Time Complexity : O(n)
    // Space complexit : O(n)

    // Space Optimization in Tabulation 
    public static int fun4(int[] houses){
        // Base Cases
        int n = houses.length;
        int prev = houses[0] , prevPrev = -1 , current = -1;

        // Tabulation in variables 
        for(int i=1;i<n;i++){
            int pick = (i > 1) ? houses[i] + prevPrev : houses[i] + 0;
            int notPick = 0 + prev;
            current = Math.max(pick,notPick);
            prevPrev = prev;
            prev = current;
        }
        return prev;
    } 



    public static void main(String[] args) {
        int[] circularArray = {1,5,1,2,6};
        int n = circularArray.length;
        int[] leaveFirst = Arrays.copyOfRange(circularArray, 1, n);
        int[] leaveLast = Arrays.copyOfRange(circularArray, 0, n-1);
        n = leaveFirst.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println("The Maximum Amount That Robber Can Rob : " + 
        Math.max(fun1(n-1,leaveFirst) , fun1(n-1,leaveLast)));
        System.out.println("The Maximum Amount That Robber Can Rob : " + 
        Math.max(fun2(n-1,leaveFirst,dp) , fun2(n-1,leaveLast,dp)));
        System.out.println("The Maximum Amount That Robber Can Rob : " + 
        Math.max(fun3(leaveFirst) , fun3(leaveLast)));
        System.out.println("The Maximum Amount That Robber Can Rob : " + 
        Math.max(fun4(leaveFirst) , fun4(leaveLast)));
        // System.out.println(leaveFirst[0] + " " + leaveFirst[n-1]);
        // System.out.println(leaveLast[0] + " " + leaveLast[n-1]);
    }
}
