public class Arrays_06_Resize_Array {

    public static void _resizeArray(int [] arr,int required_capacity){
        int n = arr.length;
        int [] result = new int[required_capacity];
        for(int i=0;i<n;i++){
            result[i] = arr[i];
        }
        arr = result;
    }

    public static int [] resizeArray(int [] arr,int required_capacity){
        int n = arr.length;
        int [] result = new int[required_capacity];
        for(int i=0;i<n;i++){
            result[i] = arr[i];
        }
        arr = result;
        return arr;
    }

    public static void main(String[] args) {
        
        int [] demo = new int[5];
        demo[0] = 0;
        demo[1] = 1;
        demo[2] = 2;
        demo[3] = 3;
        demo[4] = 4;
        // This will throw error...java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
        // demo[5] = 5;
        // demo[6] = 6;

        _resizeArray(demo,9);

        // demo[5] = 5;

        // Still it threw the same error that java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

        int [] resized_array = resizeArray(demo , 9); 
        resized_array[5] = 5;
        resized_array[6] = 6;
        resized_array[7] = 7;

        // This happened due to the fact that if we make the return type as void then the array arr is also garbage collected 


    }
}
