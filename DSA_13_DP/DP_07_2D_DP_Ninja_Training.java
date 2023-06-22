import java.util.*;

public class DP_07_2D_DP_Ninja_Training {

    // Recursive Code 
    public static int fun1(int day , int last , int[][] points){
        // Base Case 
        if(day == 0){
            int maximum = 0;
            for(int task=0;task<3;task++){
                if(task != last) maximum = Math.max(maximum,points[day][task]);
            }
            return maximum;
        }

        // Code 
        int globalMax = 0;
        for(int task=0;task<3;task++){
            if(task != last){
                int point = points[day][task] + fun1(day-1,task,points);
                globalMax = Math.max(globalMax,point);
            }
        }
        return globalMax;
    }
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)


    // Memoization 
    public static int fun2(int day,int last,int[][] points,int[][]dp){
        // Base Case 
        if(day == 0){
            int maximum = 0;
            for(int task=0;task<3;task++){
                maximum = Math.max(maximum,points[day][task]);
            }
            return maximum;
        }

        // Code 
        if(dp[day][last] != -1) return dp[day][last];
        int globalMax = 0;
        for(int task=0;task<3;task++){
            if(task != last){
                int point = points[day][task] + fun2(day-1, task, points, dp);
                globalMax = Math.max(globalMax,point);
            }
        }
        return dp[day][last] = globalMax;
    }
    // Time Complexity : 3 x O(n x 4)
    // Space Complexity : O(n) + O(n x 4)

    // Tabulation 
    public static int fun3(int[][] points){
        // Instantiate DP
        int n = points.length;
        int[][] dp = new int[n][4];

        // Base Tabulations 
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);;
        dp[0][2] = Math.max(points[0][0],points[0][1]);;
        dp[0][3] = Math.max(points[0][0] , Math.max(points[0][1],points[0][2]));

        // Tabulations 
        for(int day=1;day<n;day++){
            for(int last=0;last<4;last++){
                dp[day][last] = 0;
                for(int task=0;task<3;task++){
                    int point = points[day][task] + dp[day-1][task];
                    dp[day][last] = Math.max(dp[day][last],point);
                }
            }
        }
        return dp[n-1][3];
    }
    // Time Complexity : 3 x O(n x 4)
    // Space Complexity : O(n x 4)

    // Space Optimization In Tabulation 
    public static int fun4(int[][] points){
        // Instantiate DP of constant space 
        int n = points.length;
        int[] prev = new int[4];

        // Base Tabulation 
        prev[0] = Math.max(points[0][1],points[0][2]);
        prev[1] = Math.max(points[0][0],points[0][2]);
        prev[2] = Math.max(points[0][0],points[0][1]);
        prev[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        // Code 
        for(int day=1;day<n;day++){
            int[] temp = new int[4];
            for(int last=0;last<4;last++){
                temp[last] = 0;
                for(int task=0;task<3;task++){
                    int point = points[day][task] + prev[last];
                    temp[last] = Math.max(temp[last],point);
                }
            }
            // prev = Arrays.copyOfRange(temp, 0, 4);
            prev = temp;
        }
        return prev[3];
    }

    public static void main(String[] args) {
        int[][] points = {{10, 40, 70},
                          {20, 50, 80},
                          {30, 60, 90}}; 
        // Expected OutPut : 210
        int n = points.length;
        int[][] dp = new int[n][4];
        // Arrays.fill(dp,-1); 
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        System.out.println("Using Recursion : " + fun1(n-1,3,points));
        System.out.println("Using Memoization : " + fun2(n-1,3,points,dp));
        System.out.println("Using Tabulation : " + fun3(points));
        System.out.println("Using Tabulation With Space Optimization : " + fun4(points));

    }
}

