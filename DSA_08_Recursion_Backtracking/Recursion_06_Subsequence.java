import java.util.*;

public class Recursion_06_Subsequence {

    // Algorithm to print all the sub-sequence of a given array

    public static void SubSequences(int index , List<Integer> list , int[] arr , int n){
        if(index==n){
            System.out.println(list);
            if(list.size()==0){
                System.out.println("[]");
            }
            return;
        }
        list.add(arr[index]);           // Pick
        SubSequences(index+1, list, arr , n);
        list.remove(list.indexOf(arr[index]));             // Not Pick 
        SubSequences(index+1, list, arr , n);
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        int[] arr = {3,1,2};
        int n = 3;
        SubSequences(0, list, arr , n);


        
    }
}
