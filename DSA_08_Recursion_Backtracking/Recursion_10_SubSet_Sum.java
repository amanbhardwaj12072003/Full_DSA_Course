// SubSet Sum --> We have to print the distinct sum of all possible subsets o/f a given array

import java.util.*;
public class Recursion_10_SubSet_Sum {

    // Solution using the recursion

    public static void SubSet_Sum(int index,int[] arr,List<Integer> list,int sum){
        if(index==arr.length){
            list.add(sum);
            return;
        }
        // Pick The Element
        SubSet_Sum(index+1, arr, list, sum+arr[index]);
        // Do Not Pick The Element
        SubSet_Sum(index+1, arr, list, sum);

    }

    public static List<Integer> Sum(int[] arr){
        List<Integer> list = new ArrayList<>();
        SubSet_Sum(0, arr,list, 0);
        Collections.sort(list);
        return list;
    }

    // Solution using "Power Set Theorem" ---> Bit Manipulation
    public static List<Integer> SubSet_Sum_(int[] arr){
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<(1<<n);i++){   // For getting every sub set 
            int sum = 0;
            for(int j=0;j<n;j++){
                if((i & (1<<j))>0){
                    sum += arr[j];
                }
            }
            list.add(sum);
        }
        return list;

        // Note : x>>n --> x/(2^n)
        // Note : x<<n --> x*(2^n)

    }

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        System.out.println("The sum of all the possible sub sets of the given array is using Recursion : " + Sum(arr));
        System.out.println("The sum of all the possible sub sets of the given array is using Power Set Algorithm : " + SubSet_Sum_(arr));
    }
}
