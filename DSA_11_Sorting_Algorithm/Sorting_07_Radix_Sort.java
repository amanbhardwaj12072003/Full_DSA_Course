public class Sorting_07_Radix_Sort {

    private static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max,num);
        return max;
    }

    private static void Radix_Count_Sort(int[] arr, int place){
        int len = arr.length;
        int[] sorted = new int[len];
        int[] countArray = new int[10];

        for(int index=0;index<len;index++){
            countArray[(arr[index]/place)%10]++;
        }

        for(int index=1;index<10;index++){
            countArray[index] += countArray[index-1];
        }

        for(int index=len-1;index>=0;index--){
            int idx = countArray[(arr[index]/place)%10]-1;
            sorted[idx] = arr[index];
            countArray[(arr[index]/place)%10]--;
        }

        for(int index=0;index<len;index++) arr[index] = sorted[index];
    }

    private static void Radix_Sort(int[] arr){
        int max = findMax(arr);
        for(int place=1; max/place>0; place *= 10){
            Radix_Count_Sort(arr,place);
        }
    }

    public static void main(String[] args) {
        int[] un_sorted_array = {5,89,288,101,490,31,92,432,603};  // An Unsorted Array Of Size -> 9
        System.out.print("The UnSorted Array : ");
        for(int auto : un_sorted_array) System.out.print(auto + " ");
        System.out.println("");
        Radix_Sort(un_sorted_array);
        System.out.print("The Sorted Array Using Merge Sort : ");
        for(int item : un_sorted_array) System.out.print(item + " ");
    }
}
