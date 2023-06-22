import java.util.Scanner;
public class Bit_07_isPowerOf2 {

    // If any number is a power of 2 then it has only one set bit 
    // Hence we will count the number of set bits in the number 
    public static void isPowerOf2(int n){
        if(n<0){
            System.out.printf("No %d is not a power of 2 \n ",n);
            return;
        }
        int count = 0;
        while(n > 0){
            count++;
            n = (n) & (n-1);
        }

        if(count==1) System.out.printf("Yes %d is a power of 2 \n ", n);
        else System.out.printf("No %d is not a power of 2 \n ",n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        isPowerOf2(number);
    }
}
