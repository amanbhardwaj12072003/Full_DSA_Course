public class Sorting_01_Selection_Sort {

    public static void Selection_Sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int MinIndex = i;
            for(int j = i; j < n; j++){
                if(arr[j] < arr[MinIndex]) MinIndex = j;
            }
            Swap(arr , i , MinIndex);
        }
    }

    // Time Complexity : O(n^2)
    // Space Complexity : O(1) ....As we are just using variables 

    public static void Swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        
        int[] un_sorted_array = {5,8,2,1,4,3,9,4,6};  // An Unsorted Array Of Size -> 9
        System.out.print("The UnSorted Array : ");
        for(int auto : un_sorted_array) System.out.print(auto + " ");
        System.out.println("");
        Selection_Sort(un_sorted_array);
        System.out.print("The Sorted Array Using Selection Sort : ");
        for(int item : un_sorted_array) System.out.print(item + " ");
    }
}
