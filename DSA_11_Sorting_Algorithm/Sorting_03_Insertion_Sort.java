public class Sorting_03_Insertion_Sort {

    public static void Insertion_Sort(int[] arr){
        int n = arr.length;
        for(int index=0;index<n;index++){
            int index_ = index;
            while(index_>0 && arr[index_-1]>arr[index_]){
                swap(arr,index_-1,index_);
                index_--;
            }
        }
    }
    // Worst Case Time Complexity : O(n^2)
    // Best Case Time Complexity : O(n)

    public static void swap(int[] arr, int index_, int index){
        int temp = arr[index];
        arr[index] = arr[index_];
        arr[index_] = temp;
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
