public class Binary_Search_01_Algorithm {

    // Iterative Binary Search 
    private static int iterative_binary_search(int[] arr, int target){
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return -1; // Element not found 
    }

    // Recursive Binary Search 
    private static int recursive_binary_search(int[] arr, int low, int high, int target){
        // Base Case 
        if(low > high) return -1;

        // Code 
        int mid = low + (high-low)/2;
        if(arr[mid]==target) return mid;
        else if(arr[mid]>target) return recursive_binary_search(arr, low, mid-1, target);
        else return recursive_binary_search(arr, mid+1, high, target);
    }

    public static void main(String[] args) {
        iterative_binary_search(null, 0);
        recursive_binary_search(null, 0, 0, 0);
    }
}
