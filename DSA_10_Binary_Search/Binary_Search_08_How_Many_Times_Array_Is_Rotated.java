public class Binary_Search_08_How_Many_Times_Array_Is_Rotated {

    private static int find(int[] arr){
        int len = arr.length, low = 0, high = len-1, min = Integer.MAX_VALUE, indexOfMin = -1;
        while(low<=high){
            int mid= low + (high-low)/2;

            if(arr[low]<=arr[high]){
                if(arr[low]<min){
                    min = arr[low];
                    indexOfMin = low;
                    continue;
                }
            }
            
            if(arr[low]<=arr[mid]){
                if(arr[low]<min){
                    min = arr[low];
                    indexOfMin= low;
                }
                low = mid+1;
            }else{
                if(arr[mid]<min){
                    min = arr[mid];
                    indexOfMin = mid;
                }
                high = mid-1;
            }
        }
        return indexOfMin;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,1,2,3,4}; // Expected Answer : 4
        System.out.println("Number of times the array is rotated : " + find(arr));
    }
}
