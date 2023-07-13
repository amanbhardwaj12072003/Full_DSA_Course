public class Binary_Search_07_Min_In_Rotated_Sorted_Array {

    // For Unique Elements 
    private static int findMin(int[] arr){
        int len = arr.length, low = 0, high = len-1, min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[low]<=arr[high]){
                min = Math.min(min,arr[low]);
                break;
            }

            if(arr[low]<=arr[mid]){
                min = Math.min(min,arr[low]);
                low = mid+1;
            }else{
                min = Math.min(min,arr[mid]);
                high = mid-1;
            }
        }
        return min;
    }

    // For Duplicate Elements 
    private static int findMin_(int[] arr){
        int len = arr.length, low = 0, high = len-1, min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;

            // Edge Case 
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low = low+1;
                high = high-1;
                continue;
            }

            if(arr[low]<=arr[high]){
                min = Math.min(min,arr[low]);
                break;
            }

            if(arr[low]<=arr[mid]){
                min = Math.min(min,arr[low]);
                low = mid+1;
            }
            else{
                min = Math.min(min,arr[mid]);
                high = mid-1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {6,7,8,9,1,2,3,4,5}, arr_ = {5,5,6,1,2,3,4,5};
        int min = findMin(arr), min_ = findMin_(arr_);
        System.out.println("Min Element In The Given Sorted-Rotated Array With All Unique Elements : " + min);
        System.out.println("Min Element In The Given Sorted-Rotated Array With Duplicates : " + min_);
    }
}
