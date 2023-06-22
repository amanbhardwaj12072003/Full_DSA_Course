import java.util.Scanner;
public class Bit_06_Count_Set_Bits {

    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) > 0) count++;
            n  >>= 1;
        }
        return count;
    }

    public static int countSetBits_(int n){
        int count = 0;
        while( n > 0){
            count++;
            n = (n) & (n-1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int numberOfSetBits = countSetBits(number);
        System.out.printf("The count of set bits is %d using Method 1 is : " + numberOfSetBits,number);
        System.out.println("");
        int number_ = countSetBits_(number);
        System.out.printf("The count of set bits is %d using Method 2 is : " + numberOfSetBits,number_);
        System.out.println("");
    }
}
