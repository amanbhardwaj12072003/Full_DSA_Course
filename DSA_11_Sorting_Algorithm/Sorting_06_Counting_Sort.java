public class Sorting_06_Counting_Sort {

    private static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max,num);
        return max;
    }

    // This is counting sort array which also preserves the reletive order of elements 
    private static void Counting_Sort(int[] arr){
        int len = arr.length;
        int[] sortedArray = new int[len];
        int max = findMax(arr);
        int[] countArray = new int[max+1];
        for(int index=0;index<len;index++){
            countArray[arr[index]]++;
        }
        // Make prefix sum array of the countArray 
        for(int index=1;index<len;index++){
            countArray[index]+=countArray[index-1];
        }

        // Find index of each array in the arr and put it in the sortedArray 
        for(int index=len-1;index>=0;index--){
            int idx = countArray[arr[index]]-1;
            sortedArray[idx] = arr[index];
            countArray[arr[index]]--;
        }

        // Copy sortedArray in the original array 
        for(int index=0;index<len;index++) arr[index] = sortedArray[index];
    }

    public static void main(String[] args) {
        int[] un_sorted_array = {5,8,2,1,4,3,9,4,6,2,5,9,9,8};
        System.out.print("The UnSorted Array : ");
        for(int auto : un_sorted_array) System.out.print(auto + " ");
        System.out.println("");
        Counting_Sort(un_sorted_array);
        System.out.print("The Sorted Array Using Merge Sort : ");
        for(int item : un_sorted_array) System.out.print(item + " ");
    }
}
