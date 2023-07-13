public class Binary_Search_03_Floor_Ceil {

    // Floor of target in the given sorted array is the largest number 'num' in the array such that: num <= target
    private static int floor(int[] arr, int target){
        int len = arr.length, low = 0, high = len-1, ans = len;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=target){
                ans = mid;
                low = mid+1;
            }else high = mid-1;
        }
        return ans;
    }

    // Ceil of target in the given sorted array is the smallest number 'num' in the array such that: num >= target
    private static int ceil(int[] arr, int target){
        return lower_bound(arr,target);
    }

    private static int lower_bound(int[] arr, int target){
        int len = arr.length, low = 0, high = len-1, ans = len;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=target){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        floor(null, 0);
        ceil(null, 0);
    }
}
