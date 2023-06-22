import java.util.*;
public class DP_43_Longest_Increasing_Subsequence_Binary_Search {
    public static int lower_bound(int[] arr , int key){
        int low = 0 , high = arr.length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(key <= arr[mid]) high = mid;
            else low = mid+1;
        }
        if(low < arr.length && arr[low] < key) low++;
        return low;
    }

    public static int fun(int[] arr){
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int len = 1;
        for(int index=1;index<arr.length;index++){
            if(arr[index] > temp.get(temp.size()-1)){
                temp.add(arr[index]);
                len++;
            }
            else{
                temp.set(lower_bound(arr, arr[index]),arr[index]);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        // Expected Output : 3
        int[] arr = {5, 4, 11, 1, 16, 8};
        System.out.println(fun(arr));
    }
}
