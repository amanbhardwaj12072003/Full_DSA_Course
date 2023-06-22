import java.util.*;

public class Arrays_03_Min_Of_Array {

    public static int min_of_array(int [] arr){
        int min = arr[0];
        for(int i : arr){
            if(i < min){
                min = i;
            }
        }
        return min;
    }

    public static int array_min(int [] arr){
        Arrays.sort(arr);
        return arr[0];
    }

    public static void main(String[] args) {
        
        int [] demo_array = {1,5,2,7,4,8,1,4,3,2,3};
        
        // Note that this took 0 milli seconds

        long time_i1 = System.currentTimeMillis();
        int result_1 = min_of_array(demo_array);
        long time_f1 = System.currentTimeMillis();
        System.out.println("Time taken without using array.sort : " + (time_f1 - time_i1));
        System.out.println("Minimum of array : " + result_1);


        // Note that this took 75 milli seconds

        long time_i2 = System.currentTimeMillis();
        int result_2 = array_min(demo_array);
        long time_f2 = System.currentTimeMillis();
        System.out.println("Time taken using array.sort : " + (time_f2 - time_i2));
        System.out.println("Minimum of array : " + result_2);


    }
}
