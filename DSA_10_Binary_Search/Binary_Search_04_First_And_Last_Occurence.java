public class Binary_Search_04_First_And_Last_Occurence {

    // Must take care of edge cases
    private static int[] findOccurences(int[] arr, int target){
        int lowerBound = lower_bound(arr,target);
        if(lowerBound==arr.length || arr[lowerBound]!=target) return new int[]{-1,-1};
        return new int[]{lowerBound,upper_bound(arr,target)-1};
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

    private static int upper_bound(int[] arr, int target){
        int len = arr.length, low = 0, high = len-1, ans = len;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Indexes :  0,1,2,3,4,5,6,7
        int[] arr = {2,4,6,8,8,8,11,13};
        int[] occurences = findOccurences(arr, 8);
        System.out.println("Firse Occurence : " + occurences[0]);
        System.out.println("Last Occurence : " + occurences[1]);
    }
}
