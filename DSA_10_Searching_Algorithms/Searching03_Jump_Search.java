public class Searching03_Jump_Search {
    
    // Jump Search Algorithm : Only Applies To Sorted Arrays 

    public static void JumpSearch(int[] arr , int key){
        int n = arr.length , previous = 0 , index = -1;
        int step = (int)(Math.floor(Math.sqrt(n))) , temp = step; // Width Of One Interval
        while(arr[Math.min(step,n)-1] < key){
            previous = step;
            step += temp;
            if(step >= n) index = -1;break;
        }
        while(arr[previous] < key){
            previous++;
            if(previous == Math.min(step,n)) index = -1;
        }
        if(arr[previous]==key) index = previous;

        if(index == -1) System.out.println("Provided Key Is Not Present In The Given Array ");
        else System.out.println("Provided Key Is Present In The Given Array At Index : " + index);

    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,11,15,22,29,33,35,42};
        JumpSearch(arr, 15);
        JumpSearch(arr, 7);

        // Time Complexiy : O(sqrt(n))
    }
}
