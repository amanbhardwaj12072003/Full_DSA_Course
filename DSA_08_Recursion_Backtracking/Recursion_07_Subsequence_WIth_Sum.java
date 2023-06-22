import java.util.*;

public class Recursion_07_Subsequence_WIth_Sum {

    // This is the method to print all the sub-sequences of an array with a given sum.

    public static void Sum_k(int index,List<Integer> list,int[] arr,int k , int sum){
        if(index==arr.length){
            if(sum==k)
                System.out.println(list);
            return;
        }
        // Case 1 : index vale element ko sath leke caage bade 
        list.add(arr[index]);
        sum += arr[index];
        Sum_k(index+1, list, arr, k, sum);
        
        // Case 2 : iondex vale element ko chod kr aage bade 
        list.remove(list.indexOf(arr[index]));
        sum -= arr[index];
        Sum_k(index+1, list, arr, k, sum);
    }

    // This is a method to print any one subsequence of an array with the givren sum (Method - 1)
    static boolean flag = false;
    public static void Sum_k_1(int index,List<Integer> list,int[] arr,int k , int sum){
        if(index==arr.length){
            if(sum==k && flag==false){
                flag = true;
                System.out.println(list);
            }
            return;
        }
        // Case 1 : index vale element ko sath leke caage bade 
        list.add(arr[index]);
        sum += arr[index];
        Sum_k_1(index+1, list, arr, k, sum);
        
        // Case 2 : iondex vale element ko chod kr aage bade 
        list.remove(list.indexOf(arr[index]));
        sum -= arr[index];
        Sum_k_1(index+1, list, arr, k, sum);
    }

    // This is a method to print any one subsequence of an array with the given sum (Method - 2)
    // Technique to print only one answer 

    public static boolean Sum_k_2(int index,List<Integer> list,int[] arr, int k , int sum){
        if(index==arr.length){
            if(sum==k){
                System.out.println(list);
                return true;
            }
            else return false;
        }
        list.add(arr[index]);
        sum += arr[index];
        if(Sum_k_2(index+1, list, arr, k, sum)==true) return true;
        list.remove(list.indexOf(arr[index]));
        sum -= arr[index];
        if(Sum_k_2(index+1, list, arr, k, sum)==true) return true;
        return false;
    }

    // Writing a method to count the number of sub-sequences 
    public static int Count_(int index, int[] arr,int k ,int sum){
        if(index==arr.length){
            if(sum==k){
                return 1;
            }
            return 0;
        }
        sum += arr[index];
        int left = Count_(index+1, arr, k, sum);

        sum -= arr[index];
        int right = Count_(index+1, arr, k, sum);
        return left + right;
    }



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] arr = {1,2,1};
        Sum_k(0, list, arr, 2, 0);
        Sum_k_1(0, list, arr, 2, 0);
        Sum_k_2(0, list, arr, 2, 0);
        int ans = Count_(0, arr, 2, 0);
        System.out.println(ans);
    }
}
