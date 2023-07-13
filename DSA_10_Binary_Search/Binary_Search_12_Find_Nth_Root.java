public class Binary_Search_12_Find_Nth_Root {

    private static int multipyNTimes(int num, int N){
        // Edge Case 
        if(num==0) return 0;
        
        // Code 
        int prod = 1;
        for(int mul=1;mul<=N;mul++) prod*=num;
        return prod;
    }

    private static int findNthRoot(int num, int N){
        int low = 1, high = num;
        while(low<=high){
            int mid = low + (high-low)/2;
            int value = multipyNTimes(mid, N);
            if(value==num) return mid;
            else if(value<num) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("3rd Root Of 27 : " + findNthRoot(27, 3));
        System.out.println("4th Root Of 69 : " + findNthRoot(69, 4));
    }
}
