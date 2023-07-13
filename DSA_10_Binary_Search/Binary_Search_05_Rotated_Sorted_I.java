public class Binary_Search_05_Rotated_Sorted_I {

    private static int Search_In_Rotated_Sorted_Array_I(int[] arr, int target){
        int len = arr.length, low = 0, high = len-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            // Element Found 
            if(arr[mid]==target) return mid;
            
            // Left Half Sorted 
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[high]){
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
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int find_1 = Search_In_Rotated_Sorted_Array_I(arr, 1);
        System.out.println(find_1);
    }
}
