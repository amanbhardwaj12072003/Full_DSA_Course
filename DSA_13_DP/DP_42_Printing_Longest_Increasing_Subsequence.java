import java.util.*;
public class DP_42_Printing_Longest_Increasing_Subsequence {
    public static List<Integer> fun(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maximum = 0 , lastIndex = 0;
        List<Integer> hash = new ArrayList<>();
        for(int index=0;index<n;index++){
            hash.set(index, index);
            for(int prev=0;prev<index;prev++){
                if(arr[prev] < arr[index] && 1+ dp[prev] > dp[index]){
                    dp[index] = 1+ dp[prev];
                    hash.set(index,prev);
                }
            }
            if(dp[index] > maximum){
                maximum = dp[index];
                lastIndex = index;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[lastIndex]);
        while(hash.get(lastIndex) != lastIndex){
            lastIndex = hash.get(lastIndex);
            temp.add(arr[lastIndex]);
        }
        Collections.reverse(temp);
        return temp;
    }
    public static void main(String[] args) {
        int[] arr = {5,4,11,1,16,8};
        System.out.println(fun(arr));
    }
}
