public class Sorting_04_Merge_Sort {

    public static void Merge_Sort(int[] arr , int low , int high){

        // Base Case
        if(low >= high) return;

        int mid = low + (high - low)/2;

        // Keep On Dividing The Left And Right Part
        Merge_Sort(arr, low, mid);
        Merge_Sort(arr, mid+1, high);

        // Finally Merging The Two Sorted Arrays 
        Merge(arr, low, high);
    }

    public static void Merge(int[] arr , int low, int high){

        int mid = low + (high - low)/2;

        int left_len = mid - low + 1;
        int right_len = high - mid;

        // Storing Left And Right Part 
        int[] left = new int[left_len];
        int[] right = new int[right_len];
        int MainArrayIndex = low;
        for(int i=0;i<left_len;i++){
            left[i] = arr[MainArrayIndex++];
        }
        // MainArrayIndex = mid+1;
        for(int j=0;j<right_len;j++){
            right[j] = arr[MainArrayIndex++];
        }

        // Merging Two Sorted Arrays 

        int index1 = 0 , index2 = 0;
        MainArrayIndex = low;

        while(index1 < left_len && index2 < right_len){
            if(left[index1] < right[index2]) arr[MainArrayIndex++] = left[index1++];
            else arr[MainArrayIndex++] = right[index2++];
        }
        while(index1 < left_len) arr[MainArrayIndex++] = left[index1++];
        while(index2 < right_len) arr[MainArrayIndex++] = right[index2++];

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
