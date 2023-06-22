public class Arrays_01_Remove_Even_Integers {

    public static int count_odd(int [] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] % 2 != 0){
                count++;
            }
        }
        return count;
    }

    public static int [] Modified_Array(int [] arr  , int count_of_odd){
        int [] arr_after_removing = new int[count_of_odd];

        int index = 0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]%2 != 0){
                arr_after_removing[index] = arr[j];
                index++;
            }
        }

        return arr_after_removing;
    }

    public static void main(String[] args) {

        int [] demo_array = {5,8,2,4,7,3,76,23,65,2,1,3,43,6};
        int count_of_odd = count_odd(demo_array);
        int [] result = Modified_Array(demo_array, count_of_odd);

        System.out.println("The original array");
        for(int i : demo_array){
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println("The array after removing even integers");
        for(int j : result){
            System.out.print(j + " ");
        }
        
        System.out.println();
        
    }
}
