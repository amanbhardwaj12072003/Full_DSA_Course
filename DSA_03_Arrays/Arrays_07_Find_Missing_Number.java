import java.util.Arrays;

public class Arrays_07_Find_Missing_Number {

    // Algorithm-1

    public static int findMissing(int [] arr,int n){
        int sum_n = (n*(n+1))/2;
        int sum_array = 0;
        for(int i=0;i<n-1;i++){
            sum_array += arr[i];
        }
        int missing_number = sum_n-sum_array;
        return missing_number;
    }

    // Algorithm-2

    public static int findMissing_(int [] arr,int n){
        Arrays.sort(arr);
        int miss = 0;
        for(int i=0;i<n-2;i++){
            if(arr[i+1] != arr[i] + 1){
                miss = arr[i]+1;
            }
        }
        return miss;
    }

    public static void main(String[] args) {
        
        // Let n = 10 , and we want to find the missing number in the array....
        int [] demo = {1,8,2,4,9,6,10,3,5};
        int missed = findMissing(demo, 10);
        System.out.println("The missing number is : " + missed);
        int missed_ = findMissing_(demo, 10);
        System.out.println("The missing number is : " + missed_);

    }
}
