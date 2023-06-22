import java.util.*;
public class Recursion_08_LeetCode_Combination_Sum {

    public static void findCombination(int index,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if(index==arr.length){
            if(target==0)
                ans.add(new ArrayList<>(ds));
            return;
        }

        if(arr[index] <= target){
            ds.add(arr[index]);
            findCombination(index, arr, target-arr[index], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombination(index+1, arr, target, ans, ds);
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("The resulting List : " + result);

    }
}
