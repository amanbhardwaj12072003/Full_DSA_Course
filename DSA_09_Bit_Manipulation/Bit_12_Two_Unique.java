import java.lang.Math;
public class Bit_12_Two_Unique {

    public static int[] findUnique(int[] arr){

        // Taking xor of all elements of array 
        int xor1 = 0;
        for(int i : arr) xor1 ^= i;
        
        // Going by leftmost set bit 
        int leftmostsetbit = (int)Math.floor((Math.log10(xor1)/Math.log10(2)) +1);

        // Let num1 and num be the two required numbers 
        int num1 = 0, num2 = 0;

        for(int i : arr){
            if((i & (1<<(leftmostsetbit-1)))>0) num1 ^= i;
            else num2 ^= i;
        }
        // By doing this we seperated the two numbers with pairs of numbers and solved as the previous one 
    
        int[] result = new int[2];
        if(num1 <= num2){
            result[0] = num1;
            result[1] = num2;
        }
        else{
            result[0] = num2;
            result[1] = num1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5,3,4};
        int[] ans = findUnique(nums);
        System.out.printf("The two numbers are : %d and %d ", ans[0],ans[1]);
        System.out.println("");
    }
}
