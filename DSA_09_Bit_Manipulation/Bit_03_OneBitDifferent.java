import java.util.Scanner;

public class Bit_03_OneBitDifferent {

    public static int fun(int a){

        // We just have to take or of a with a+1

        return (a | (a + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of number : ");
        int number = sc.nextInt();
        int required_number  = fun(number);
        System.out.println(" The smallest number greater then input number is : " + required_number);
    }
}
