import java.util.*;

public class Recursion_05_Fibonacci {

    // Fibonacci Series using for loop
    public static int Fib1(int n){   // We have to fins the nth fibonacci number 
        if(n<1) return n;
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2;i<n+1;i++){
            fib[i] = fib[i-2] + fib[i-1];
        }
        return fib[n];
    }

    // Fibonacci series using recursion
    public static int Fib2(int n){
        if(n <= 1){
            return n;
        }
        return Fib2(n-1) + Fib2(n-2);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        System.out.println(Fib1(n));
        System.out.println(Fib2(n));


        
    }
}
