import java.util.Scanner;
public class Bit_09_1_to_x_XOR {
    // We have to find xor from 1 to x (1^2^3^4^....^x)

    // Method-1
    public static int findXOR(int n){
        int result = 0; // XOR of any number with 0 is the number itself 
        for(int i=1;i<=n;i++) result ^= i;
        return result;
    }
    // Time Complexity : O(n) 

    // Method-2
    public static int findXOR_(int n){
        // observing the pattern 

        if(n % 4 == 0) return n;
        else if(n % 4 == 1) return (1);
        else if(n % 4 ==2) return (n+1);
        else return 0;
    }
    // Time Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int XOR_value = findXOR(number);
        int XOR_value_ = findXOR_(number);
        System.out.println("The Value found in O(n) : " + XOR_value);
        System.out.println("The value found in O(1) : " + XOR_value_);
    }
}
