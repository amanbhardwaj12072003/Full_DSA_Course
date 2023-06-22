import java.util.*;
public class Recursion_01_Basic_Problem {

    // Printing the name n times...
    public static void Name(int i,int n){
        // Deciding the base case as per the need 
        if(i > n){
            return;
        }
        // Printing the name 
        System.out.println("Name");
        // Recursively calling the function 
        Name(i+1, n);
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n) , For the stack space 


    // Printing from 1 to n
    public static void Print(int i,int n){
        if(i > n){
            return;
        }
        System.out.println(i);
        Print(i+1,n);
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n) , For the stack space 


    // Printing from n to 1
    public static void Print_(int n){
        if(n<1){
            return;
        }
        System.out.println(n);
        Print_(n-1);
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        Name(1,n);  // Calling the function with the initial i == 1 ....

        Print(1,n);

        Print_(n);
    }
}
