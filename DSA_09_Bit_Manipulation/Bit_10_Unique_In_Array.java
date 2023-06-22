public class Bit_10_Unique_In_Array {
    public static int findUnique(int[] arr){
        int ans = 0;
        for(int i : arr) ans ^= i;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,1,3,2};
        int unique = findUnique(arr);
        System.out.println("The unique element in the array is : " + unique);
    }
}
