import java.util.*;
public class Bit_01_Decimal_To_Binary {

    // Using Arithematic Operators 

    public static void decimalToBinary(int n){
        int[] store = new int[32];  // Considering 32 bit number
        int run = 0;
        while(n > 0){
            store[run++] = (n % 2);
            n /= 2;
        }
        System.out.println("Converting Decimal To Binary : ");
        for(int j=31;j>= 0;j--) System.out.print(store[j]);
    }

    // Using Arithematic Operatiors But Avoiding The Leading Zeros 

    public static void decimalToBinary_(int n){
        List<Integer> store = new ArrayList<>();
        while(n > 0){
            store.add((n % 2));
            n /= 2;
        }
        for(int j=store.size()-1;j>=0;j--) System.out.print(store.get(j));

    }

    // Using BitWise Operators 

    public static void decimalToBinary__(int n){
        while(n > 0){
            if((n & 1) == 1) System.out.print('1');
            else System.out.print('0');

            n >>= 1;  // Right Shift Of n By 1 
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        
        int m = 91;
        decimalToBinary(m);
        System.out.println();
        decimalToBinary_(m);
        System.out.println();
        decimalToBinary__(m);
    }
}
