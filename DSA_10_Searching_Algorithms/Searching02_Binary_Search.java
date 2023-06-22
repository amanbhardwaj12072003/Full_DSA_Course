public class Searching02_Binary_Search {

    // Binary Search Algorithm : Only Applicable To Sorted Array 

    public static void BinarySearch(int[] arr , int key){
        int low = 0, high = arr.length-1;
        int index = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid]==key){
                index = mid;break;
            }
            else if(arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        if(index==-1) System.out.println("The Provided Key Is Not Found In The Given Array");
        else System.out.println("The Provided Key Is Present In The Given Array At Index : " + index);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,11,15,22,29,33,35,42};
        BinarySearch(arr, 15);
        BinarySearch(arr, 7);

        // Time Complexiy : O(log(n))
    }
}
