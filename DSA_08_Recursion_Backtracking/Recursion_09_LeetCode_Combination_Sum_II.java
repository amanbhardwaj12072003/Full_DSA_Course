import java.util.*;
public class Recursion_09_LeetCode_Combination_Sum_II {
    // Method - 1 ---> BrutForce (By sorting ds before adding it to set)
    public static void findCombination(int index,int[] arr,int target,Set<List<Integer>> ans,List<Integer> ds){
        if(index==arr.length){
            if(target==0){
                Collections.sort(ds); // Sorting ds and adding to a set for avoiding the repeatation 
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[index]<=target){
            ds.add(arr[index]);
            findCombination(index+1, arr, target-arr[index], ans, ds); // Case of picking element at index in arr
            ds.remove(ds.size()-1); // Removing element after we added it for the case in which we will not be using that element 
        }
        findCombination(index+1, arr, target, ans, ds); // Case of not picking element at index in arr
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        Set<List<Integer>> ans = new HashSet<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        List<List<Integer>> result = new ArrayList<>(ans);
        return result;

    }

    // Method - 2 ---> The proper recursive solution 
    public static void findCombination_(int index,int[] arr,int target,List<List<Integer>> list,List<Integer> ds){
        if(target==0){
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i-1]==arr[i]) continue;  // for avoiding the repeatation...avoiding the occurence of same element at same position 
            if(arr[i]>target) break;  // Breaking the recursion if element of array get greater then the target

            ds.add(arr[i]);
            findCombination_(i+1, arr, target-arr[i], list, ds);
            ds.remove(ds.size()-1); // Removing the element as the recursion call is over to return to the original state 
        }
    }

    public static List<List<Integer>> combinationSum_(int[] candidates,int target){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates); // Sorting the given array 'candidates' as we wrote the algorithm assuming that the given array is sorted.
        findCombination_(0, candidates, target, list, new ArrayList<>());
        return list;
    }


    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        // Using the Method - 1
        System.out.println("The resulting List using Method - 1 : " + combinationSum(candidates, target));
        // Using the Method - 2 
        System.out.println("The resulting List Method - 2 : " + combinationSum_(candidates, target));
    }
}
