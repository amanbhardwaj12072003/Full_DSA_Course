import java.util.Scanner;
public class Bit_02_a_To_b_By_OR {

    // Trivial Method using for loop 
    // In this we only go upto b as any number when or(|) with b will give a number larger then b
    public static int count(int a, int b){
        int count = 0;
        for(int i=1;i<=b;i++) if((a | i) == b) count++;
        return count;
    }

    // Using Bit-Manipulation 
    public static int count_(int a, int b){
        int count = 1;
        while((a & b) > 0){

            if((a & 1) == 1){
                if((b & 1) == 1) count *= 2;
                else return 0;
            }

            a = a >> 1; b = b >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a : ");
        int a = sc.nextInt();
        System.out.println("Enter the value of b : ");
        int b = sc.nextInt();
        int res1 = count(a,b);
        System.out.println("Using For Loop Brute Force : " + res1);
        int res2 = count_(a,b);
        System.out.println("Using Bit Manipulation : " + res2);

    }
}
