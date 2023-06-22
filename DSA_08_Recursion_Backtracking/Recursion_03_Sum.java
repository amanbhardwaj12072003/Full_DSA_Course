import java.util.*;

public class Recursion_03_Sum {

    // Sum of first n natural number using recursion

    // Declaring a global variable 
    static int sum = 0;
    public static int Sum(int n){
        if(n < 1){
            return sum;
        }
        sum += n;
        Sum(n-1);
        return sum;
    }

    // Parameterized Recursive Method 
    public static void Sum_(int n,int sum){
        if(n < 1){
            System.out.println(sum);
            return;
        }
        Sum_(n-1,sum+n);
    }

    // Functional Recursive Method
    public static int _Sum(int n){
        if(n==0){
            return 0;
        }

        return n + _Sum(n-1); 
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        System.out.println("Calling the trivial recursion function ");
        System.out.println(Sum(n));

        System.out.println("Calling the Parameterized recursion function"); 
        Sum_(n,0); // initial value of sum is 0

        System.out.println("Calling the Functional recursion function"); 
        System.out.println(_Sum(n));

    }
}
