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
        int left = low, right = high;
        while(left<right){
            while(arr[left]<=pivot && left<=high-1){
                left++;
            }

            while(arr[right]>pivot && right>=low+1){
                right--;
            }

            if(left < right) Swap(arr,left,right);
        }
        Swap(arr,low,right); // Put pivot to its correct place 
        return right;
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
