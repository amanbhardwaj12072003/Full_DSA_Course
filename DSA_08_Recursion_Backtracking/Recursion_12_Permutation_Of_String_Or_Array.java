// We have to print all the possible permutations of a given array nums
// For example : nums[1,2,3]
// Possible permutations are : [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

import java.util.*;
public class Recursion_12_Permutation_Of_String_Or_Array {

    // Method - 1 (Time Complexity : O(n*n!) || Space Complexity : O(n)+O(n)) // More space for using extra data structures ds and available
    public static void Permutation(int[] nums,List<Integer> ds,List<List<Integer>> list, boolean[] available){
        // Base case when size of ds equals nums that is all the elements are permuted once
        if(ds.size()==nums.length){
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            // Checking if element is available to be picked or not (true : Not Available , flase : Available )
            if(!available[i]){
                available[i] = true;
                ds.add(nums[i]);
                Permutation(nums, ds, list, available);
                // After the recursive call we will remove the added element and make its correspoding postion false in the available array to return to the base case onto which the recursive call is made 
                ds.remove(ds.size()-1);
                available[i] = false;
            }
        }
    }

    // Method - 2 (Time Complexity : O(n*n!) || Space Complexity : O(n)) // Without using any extra space infact using swap function
    public static void Permutation(int index,int[] nums,List<List<Integer>> list){
        if(index==nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i : nums)
                ds.add(i);
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            Swap(nums,i,index);
            Permutation(index+1, nums, list);
            Swap(nums, i, index);
        }
    }

    public static void Swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        boolean[] available = new boolean[nums.length];
        Permutation(nums, new ArrayList<>(), list, available);
        System.out.println("All the possible permutations are : " + list);
    }
}
