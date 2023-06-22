// We have to print all the distinct subset of an array which may contain duplicates

import java.util.*;
public class Recursion_11_SubSet_II {

    // Solution using bruteforce recursion (Efficient Solution)
    public static void SubSet(int index,int[]arr,Set<List<Integer>> set,List<Integer> ds){
        if(index==arr.length){
            set.add(new ArrayList<>(ds));
            return;
        }
        // Case Of Take
        ds.add(arr[index]);
        SubSet(index+1, arr, set, ds);
        // Case Of Not Take
        ds.remove(ds.size()-1);
        SubSet(index+1, arr, set, ds);
    }

    // Actual recursive solution with logic of avoiding same ds
    public static void SubSet_(int index,int[] arr,List<List<Integer>> list,List<Integer> ds){
        // list.add(ds);  --> This will always add [], an enpty list as we create List as {List<Integer> list = new ArrayList<>();}
        list.add(new ArrayList<>(ds));  // To add the empty subset to our solution list 
        for(int i=index;i<arr.length;i++){
            if(index!=i && (arr[i-1]==arr[i])) continue;
            ds.add(arr[i]); // Take 
            SubSet_(index+1, arr, list, ds);
            ds.remove(ds.size()-1); // Not Take 
        }
    }

    // Solution using Bit manipulation 
    public static List<List<Integer>> SubSet(int[] arr){
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<(1<<n);i++){
            List<Integer> ds = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j))>0){
                    ds.add(arr[j]);
                }
            }
            set.add(ds);
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        SubSet(0, arr, set, new ArrayList<>());
        SubSet_(0, arr, list, new ArrayList<>());
        System.out.println("The resulting list of all sub sets using recursion is : " + new ArrayList<>(set));
        System.out.println("The resulting list of all sub sets using recursion is : " + list);
        System.out.println("The resulting list of all sub sets using Bit Manipulation is : " + SubSet(arr));

    }
}
