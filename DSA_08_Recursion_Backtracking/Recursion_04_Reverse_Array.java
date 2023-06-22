import java.util.*;
public class Recursion_04_Reverse_Array {

    public static void swap(int[] arr,int l, int r){
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }

    // Using for loop
    public static int[] Reverse1(int[] arr){
        int n = arr.length;
        for(int i=0;i<n/2;i++){
            swap(arr,i,n-1-i);
        }
        return arr;
    } 

    // Using Recursion with 2 pointers 
    public static int[] Reverse2(int[] arr,int l,int r){
        if(l>=r){
            return arr;
        }
        swap(arr,l,r);
        Reverse2(arr, l+1, r-1);
        return arr;
    }

    // Using Recursion with 1 pointer 

    public static int[] Reverse3(int[] arr,int i){
        if(i >= arr.length/2){
            return arr;
        }
        swap(arr,i,arr.length-i-1);
        return arr;
    }

    // Method to identify a string to be palindrome or not 
    public static boolean isPalindrome(String s,  int i){
        if(s.charAt(i) != s.charAt(s.length()-i-1)){
            return false;
        }
        if(i > s.length()/2){
            return true;
        }
        return isPalindrome(s, i+1);  // BackTracking 
    }

    public static void main(String[] args) {
        int[] arr_1 = {1,2,3,4,5};
        System.out.println(" Actual Array : " + Arrays.toString(arr_1) );

        System.out.println("Reversing array using Reverse1");
        int[] arr1 = Reverse1(arr_1);
        System.out.println(" Reversed Array : " + Arrays.toString(arr1));

        int[] arr_2 = {3,4,5,6,7};

        System.out.println("Reversing array using Reverse2");
        int[] arr2 = Reverse2(arr_2,0,arr_2.length-1);
        System.out.println("Reversed Array : " + Arrays.toString(arr2));

        int[] arr_3 = {5,6,7,8,9};

        System.out.println("Reversing array using Reverse3");
        int[] arr3 = Reverse3(arr_3,0);
        System.out.println("Reversed Array :" + Arrays.toString(arr3));

        String s = "asdfgfdsa";
        System.out.println("The given string is a palindrome : " + isPalindrome(s, 0));

    }
}
