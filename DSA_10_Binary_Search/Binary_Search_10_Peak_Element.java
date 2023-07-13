public class Binary_Search_10_Peak_Element {

    // Array with single peak 
    private static int find(int[] arr, int len){
        // Edge Cases 
        if(len==1) return arr[0];
        if(arr[0]>arr[1]) return arr[0];
        if(arr[len-1]>arr[len-2]) return arr[len-1];

        // Code 
        int low = 1, high = len-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid-1]<arr[mid]) low = mid+1;
            else if(arr[mid]>arr[mid+1]) high = mid-1;
        }
        return -1;
    }

    // Array with multiple peak and we have to return any one 
    private static int find_(int[] arr, int len){
        // Edge Cases 
        if(len==1) return arr[0];
        if(arr[0]>arr[1]) return arr[0];
        if(arr[len-1]>arr[len-2]) return arr[len-1];

        // Code 
        int low = 1, high = len-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid-1]<arr[mid]) low = mid+1;
            else if(arr[mid]>arr[mid+1]) high = mid-1;
            else low = mid+1; // To prevent infinite loop at mid==golbal minima index 
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,10,13,7,6,5,4,2,1,0}, arr_ = {1,10,13,7,6,5,4,9,6,3,2};
        System.out.println("Peak Element Index In The Array Is : " + find(arr,arr.length));
        System.out.println("Peak Element Index In The Array Is : " + find_(arr_,arr_.length));
    }
}
