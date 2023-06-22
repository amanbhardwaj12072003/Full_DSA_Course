public class Searching01_Linear_Search {

    // Linear Search Algorithm

    public static void LinearSearch(int[] arr , int key){
        int index = -1;  // This implies that number is not present in the array 
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == key){
                index = i;
                break;
            } 
        }
        if(index==-1) System.out.println("The Provided Key Is Not Present In The Given Array ");
        else System.out.printf("The Provided Key Is Present At The Index %d In The Given Array",index);
        System.out.println();

    }

    public static void main(String[] args) {

        int[] arr = {1,3,5,6,11,15,22,29,33,35,42};
        LinearSearch(arr, 15);
        LinearSearch(arr, 7);

        // Time Complexiy : O(n)
    }
}
