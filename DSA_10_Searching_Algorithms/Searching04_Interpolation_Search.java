public class Searching04_Interpolation_Search {

    public static void InterpolationSearch(int[] arr , int key){
        int index = -1;

        int low = 0 , high = arr.length-1;
        while(low <= high && arr[low] <= key && arr[high] >= key){

            int position = low + (key - arr[low])*((low - high)/(arr[high]-arr[low])); // Learn Formula 

            if(arr[position] == key){
                index = position;break;
            }

            else if(arr[position] > key) high = position - 1;
            else low = position + 1;
        }
        if(index==-1) System.out.println("The Provided Key Is Not Present In The Given Array ");
        else System.out.println("The Provided Key Is Present In The Given Array At Index : " + index);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,11,15,22,29,33,35,42};
        InterpolationSearch(arr, 15);
        InterpolationSearch(arr, 7);

        // Time Complexiy : ~ O(log(n))
        // Interpolation Search Is An Advancement In Binary Search 
    }
}
