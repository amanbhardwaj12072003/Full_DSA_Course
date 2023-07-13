import java.util.*;

public class Sorting_04_Merge_Sort {

    public static void Merge_Sort(int[] arr , int low , int high){

        // Base Case
        if(low >= high) return;

        int mid = low + (high - low)/2;

        // Keep On Dividing The Left And Right Part
        Merge_Sort(arr, low, mid);
        Merge_Sort(arr, mid+1, high);

        // Finally Merging The Two Sorted Arrays 
        Merge(arr, low, mid, high);
    }

    public static void Merge(int[] arr , int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int left = low,  right = mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left++]);
            }
            else{
                temp.add(arr[right++]);
            }
        }

        while(left<=mid){
            temp.add(arr[left++]);
        }

        while(right<=high){
            temp.add(arr[right++]);
        }

        for(int index=low;index<=high;index++){
            arr[index] = temp.get(index-low);
        }

    }

    public static void main(String[] args) {
        
        int[] un_sorted_array = {5,8,2,1,4,3,9,4,6};  // An Unsorted Array Of Size -> 9
        System.out.print("The UnSorted Array : ");
        for(int auto : un_sorted_array) System.out.print(auto + " ");
        System.out.println("");
        Merge_Sort(un_sorted_array,0,un_sorted_array.length-1);
        System.out.print("The Sorted Array Using Merge Sort : ");
        for(int item : un_sorted_array) System.out.print(item + " ");

    }
}
