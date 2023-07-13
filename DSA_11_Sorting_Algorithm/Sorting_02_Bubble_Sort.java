public class Sorting_02_Bubble_Sort {

    public static void Bubble_Sort(int[] arr){

        int rounds = arr.length-1; // In ith round we set ith largest element at its correct postion 
        while(rounds >= 0){
            for(int j=0; j < rounds; j++){
                if(arr[j] > arr[j+1]) Swap(arr,j,j+1);
            }
            rounds--;
        }
    }
    // Worst Case Time Complexity : O(n^2)
    // Best Case Time Complexity : O(n)
    // Space Complexity : O(1)


    public static void Optimised_Bubble_Sort(int[] arr){

        int rounds = arr.length-1; // In ith round we set ith largest element at its correct postion 
        while(rounds >= 0){
            boolean swapped = false;
            for(int j=0; j < rounds; j++){
                if(arr[j] > arr[j+1]) Swap(arr,j,j+1); swapped = true;
            }
            if(!swapped) break;
            rounds--;
        }
    }
    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    
    public static void Swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] un_sorted_array = {5,8,2,1,4,3,9,4,6};  // An Unsorted Array Of Size -> 9
        int[] copy = un_sorted_array;
        System.out.print("The UnSorted Array : ");
        for(int auto : un_sorted_array) System.out.print(auto + " ");
        System.out.println("");
        Bubble_Sort(un_sorted_array);
        System.out.print("The Sorted Array Using Bubble Sort : ");
        for(int item : un_sorted_array) System.out.print(item + " ");
        System.out.println("");
        Optimised_Bubble_Sort(copy);
        System.out.print("The Sorted Array Using Bubble Sort With Optimisation : ");
        for(int item : un_sorted_array) System.out.print(item + " ");
    }
}
