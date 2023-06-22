public class Arrays_04_Second_Max {
    
    public static int Second_Max(int [] arr){
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                second_max = max;
                max = arr[i];
            }

            else if(arr[i] > second_max && arr[i] != max){
                second_max = arr[i];
            }
        }
        return second_max;
    }

    public static void main(String[] args) {
        
        int [] demo_array = {1,8,4,5,0,2,4,7,5,4};
        int second_max_element = Second_Max(demo_array);
        System.out.println("The second maximum element of the array is : " + second_max_element);
    }
}
