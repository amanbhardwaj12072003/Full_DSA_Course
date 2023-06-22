public class Sorting_05_Quick_Sort {

    public static void Quick_Sort(int[] arr , int low , int high){

        // Base Case
        
        if(low >= high) return;

        // Fiding The Point Of Partition In The Array 
        int partition = Partition(arr , low , high);

        Quick_Sort(arr, low, partition-1);
        Quick_Sort(arr, partition+1, high);
    }

    // A method for swapping values in array 
    public static void Swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int Partition(int[] arr , int low , int high){
        
        int pivot = arr[low];
        int count = 0;
        for(int i=low+1;i<=high;i++){
            if(arr[i] <= pivot) count++;
        }

        int pivotIndex = low + count;
        Swap(arr , pivotIndex , low);

        int start = low , end = high;
        while(start < pivotIndex && end > pivotIndex){
            while(arr[start] < arr[pivotIndex]) start++;
            while(arr[end] > arr[pivotIndex]) end--;
            if(start < pivotIndex && end > pivotIndex){
                Swap(arr,start++,end--);
            }
        }
        return pivotIndex;
    }

    public static void main(String[] args) {
        int[] un_sorted_array = {5,8,2,1,4,3,9,4,6};  // An Unsorted Array Of Size -> 9
        System.out.print("The UnSorted Array : ");
        for(int auto : un_sorted_array) System.out.print(auto + " ");
        System.out.println("");
        Quick_Sort(un_sorted_array,0,un_sorted_array.length-1);
        System.out.print("The Sorted Array Using Quick Sort : ");
        for(int item : un_sorted_array) System.out.print(item + " ");
    }
}
