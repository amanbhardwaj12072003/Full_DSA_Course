public class Binary_Search_06_Rotated_Sorted_II {
    // In case of arr with duplicate values, finding exact indeices using binary
    // search is not possoble, we have to use linear search for the same 
    private static boolean Search_In_Rotated_Sorted_Array_II(int[] arr, int target){
        int len = arr.length, low = 0, high = len-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            // Found Element 
            if(arr[mid]==target) return true;

            // Edge Case 
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }

            // Left Half Sorted 
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }

            // Right Half Sorted 
            else{
                if(arr[mid]<=target && target<=arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }

    // Worst Case Time Compexity : ~ O(len/2) : arr = [3,3,3,3,3,1,3,3,3,3,3,3], target = 1
    // Avgerage Case Time Complexity : O(log2(len))

    public static void main(String[] args) {
        // Indexes : 0,1,2,3,4,5,6,7,8
        int[] arr = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println("1 is present in the given sorted array : " + Search_In_Rotated_Sorted_Array_II(arr, 13));
    }
}
