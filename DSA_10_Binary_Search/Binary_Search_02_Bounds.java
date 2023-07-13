public class Binary_Search_02_Bounds {

    // Lower bound of number target in a sorted array is the smallest index such that, arr[index] >= target
    private static int lower_bound(int[] arr, int target){
        int len = arr.length, low = 0, high = len-1, ans = len;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    // Upper bound of number target in a sorted array is the smallest index such that, arr[index] > target
    private static int upper_bound(int[] arr, int target){
        int len = arr.length, low = 0, high = arr.length-1, ans = len;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Indexes : 0,1,2,3,4,5,6,7,8,9,10
        int[] arr = {1,2,3,3,5,8,8,10,10,11};
        int lower_bound_1 = lower_bound(arr, 1), lower_bound_9 = lower_bound(arr,9);
        int upper_bound_1 = upper_bound(arr, 1), upper_bound_9 = upper_bound(arr,9);
        System.out.println("Lower Bound Of 1 : " + lower_bound_1);
        System.out.println("Lower Bound Of 9 : " + lower_bound_9);
        System.out.println("Upper Bound Of 1 : " + upper_bound_1);
        System.out.println("Upper Bound Of 9 : " + upper_bound_9);
    }
}
