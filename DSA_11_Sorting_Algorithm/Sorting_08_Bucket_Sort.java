import java.util.*;

public class Sorting_08_Bucket_Sort {
    private static void Bucket_Sort(float[] arr, int len){

        // Decalre Buckets List (Lets make len buckets, we can make any number of buckets)
        ArrayList<Float>[] buckets = new ArrayList[len];

        // Place Empty Buckets 
        for(int index=0;index<len;index++) buckets[index] = new ArrayList<>();

        // Add elements into the buckets 
        for(int index=0;index<len;index++){
            int bucketIndex = (int)(arr[index]*len);
            buckets[bucketIndex].add(arr[index]);
        }

        // Sort Each Bucket Individually 
        for(ArrayList<Float> bucket : buckets) Collections.sort(bucket);

        // Merge All The Sorted Buckets 
        int put = 0;
        for(ArrayList<Float> bucket : buckets){
            for(float num : bucket) arr[put++] = num;
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.5f,0.4f,0.3f,0.2f,0.1f};
        Bucket_Sort(arr,arr.length);
        for(float num : arr) System.out.print(num + " ");
    }
}
