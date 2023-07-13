public class Binary_Search_09_Single_Element_In_Sorted_Array {

    private static int find(int[] arr){
        int len = arr.length;
        
        // Handle Edge Cases 
        if(len==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[1];
        if(arr[len-1]!=arr[len-2]) return arr[len-1];

        // Trim Search Space 
        int low = 1, high = len-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1]) return arr[mid];

            if((mid%2==0 && arr[mid]==arr[mid+1]) || (mid%2==1 && arr[mid-1]==arr[mid])){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println("Single Element Is : " + find(arr));
    }
}
