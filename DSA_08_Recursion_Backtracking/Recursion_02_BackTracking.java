import java.util.*;

// Back Tracking 

public class Recursion_02_BackTracking {

    // Printing 1 to n using backtracking 
    public static void backtracking(int i,int n){
        if(i < 1){
            return;
        }
        backtracking(i-1, n);
        System.out.println(i);
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n)

    // Printing n to 1 using backtracking 
    public static void backtracking_(int i,int n){
        if(i > n){
            return;
        }
        backtracking_(i+1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter the value of n : ");
        int n = sc.nextInt();
        System.out.println("Calling backtracking ");
        backtracking(n, n);
        System.out.println("Calling backtracking_ ");
        backtracking_(1, n);
    }
}
