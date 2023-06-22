import java.util.Arrays;

public class Searching05_Exponential_Search {

    public static void ExponentialSearch(int[] arr , int key){

        int index = -1;
        if(arr[0] == key) index = 0;

        int run = 1;
        while(run < arr.length && arr[run] <= key) run *= 2;
        index =  Arrays.binarySearch(arr, run/2, run, key);

        if(index < 0) System.out.println("The Provided Key Is Not Present In The Given Array ");
        else System.out.println("The Provided Key Is Present In The Given Array At Index : " + index);

    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,11,15,22,29,33,35,42};
        ExponentialSearch(arr, 15);
        ExponentialSearch(arr, 7);

        // Time Complexity : O(log(n))
    }
}
