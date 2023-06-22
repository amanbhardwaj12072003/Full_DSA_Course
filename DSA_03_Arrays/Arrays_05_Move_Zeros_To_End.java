public class Arrays_05_Move_Zeros_To_End {

    // This is the algorithm to move the zeros in an array at the end 

    public static void Move_Zeros(int [] arr){
        int len = arr.length;
        int j = 0; // This will store the arrays with value 0...
        for(int i=0;i<len;i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            if(arr[j] != 0){
                j++;
            }
        }
    }

    public static void main(String[] args) {
        
        int [] demo = {1,5,3,0,8,6,0,4,2,7,0,3,2};
        Move_Zeros(demo);
        for(int p : demo){
            System.out.print(p + " ");
        }
        System.out.println();
    }
}
