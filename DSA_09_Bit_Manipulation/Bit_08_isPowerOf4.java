import java.util.Scanner;

public class Bit_08_isPowerOf4 {
    public static int positionOf1(int n){
        int pos = 0;
        while(n > 0){
            pos++;
            n >>= 1;
        }
        return pos;
    }

    public static void isPowerOf4(int m){
        int countBit = positionOf1(m);
        int count = 0;
        while(m > 0){
            count++;
            m = (m) & (m-1);
        }
        if(count == 1) {
            if((countBit & 1) == 1){
            System.out.println("Yes");
            } 
            else System.out.println("No");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        isPowerOf4(number);
    }
}
