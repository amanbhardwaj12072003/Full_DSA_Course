public class Sorting_03_Insertion_Sort {

    public static void Insertion_Sort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int temp = arr[i];
            int j = i-1;
            for(;j>=0; j--){
                if(arr[j] > temp){
                    arr[j+1] = arr[j];
                } else{
                    break;
                }
            }
            arr[j+1] = temp;
        }

        // Time Complexity : O(n^2)...Worst Case Complexity
    }

    public static void main(String[] args) {
        
        int[] un_sorted_array = {5,8,2,1,4,3,9,4,6};  // An Unsorted Array Of Size -> 9
        System.out.print("The UnSorted Array : ");
        for(int auto : un_sorted_array) System.out.print(auto + " ");
        System.out.println("");
        Insertion_Sort(un_sorted_array);
        System.out.print("The Sorted Array Using Insertion Sort : ");
        for(int item : un_sorted_array) System.out.print(item + " ");
    }
}
