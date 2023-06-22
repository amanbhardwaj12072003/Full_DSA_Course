public class Bit_11_Find_Missing {
    public static int findMissing(int[]arr){
        int xor1 = 0,xor2 = 0;
        for(int i : arr) xor1 ^= i;
        for(int j=1;j<=arr.length+1;j++) xor2 ^= j;
        return xor1^xor2;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5};
        int missing = findMissing(arr);
        System.out.println("The missing number in the array is : " + missing);
    }
}
