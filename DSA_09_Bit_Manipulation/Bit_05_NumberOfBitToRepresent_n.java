import java.util.Scanner;
import java.lang.Math;
public class Bit_05_NumberOfBitToRepresent_n {
    
    public static int countBits(int n){
        int count = 0;
        while(n > 0){
            count++;
            n = n >> 1;
        }
        return count;
    }
    // Time Complexity : O(log(m)), where m is number of digits in n

    public static int countBits_(int n){
        return (int)Math.floor(Math.log(n) + 1);
    }

    // Time Complexity : O(log(m))

    // By this we can say like left shift operator( << ) and right shift operator ( >> ) re generally used to traverse through the bits of a number  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int numberOfBit = countBits(number);
        System.out.printf("The Number Of Bits in %d is : " + numberOfBit , number);
        System.out.println("");
    }
}
