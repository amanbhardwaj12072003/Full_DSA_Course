import java.util.Scanner;

public class Bit_04_Set_Bit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int i = sc.nextInt();

        String isIthBitSet = (number & (1 << (i -1))) > 0 ? "YES" : "NO";
        System.out.println("Is The ith Bit from right end of number set or not : " + isIthBitSet);
    }
}
