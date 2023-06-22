public class Arrays_02_Reverse_Array {

    // Algorithm_1 to reverse an array  --> Making new array and storing values in it...
    public static int [] reverse_Array_1(int [] arr){
        int n = arr.length;
        int [] reversed_array = new int[n];
        for(int i=0;i<n;i++){
            reversed_array[i] = arr[n-i-1];
        }
        return reversed_array;
    }
    
    // Algorithm_2 to reverse an array --> Without using any new array
    public static void reverse_Array_2(int [] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
    
        int [] demo_array = {1,5,3,7,9,2,0,6};
        long time_i1 = System.currentTimeMillis();
        int [] result_1 = reverse_Array_1(demo_array);
        long time_f1 = System.currentTimeMillis();
        System.out.println("Time taken by algorithm-1" + (time_f1 - time_i1));

        System.out.println("Reversed array using algorithm - 1 ");
        for(int i : result_1){
            System.out.print(i + " ");
        }
        System.out.println(" ");

        long time_i2 = System.currentTimeMillis();
        reverse_Array_2(demo_array);
        long time_f2 = System.currentTimeMillis();
        System.out.println("The time taken by algorithm-2" + (time_f2 - time_i2));



        System.out.println("Reversed array using algorithm - 2");
        for(int j : demo_array){
            System.out.print(j + " ");
        }
        System.out.println("");

    }
}
