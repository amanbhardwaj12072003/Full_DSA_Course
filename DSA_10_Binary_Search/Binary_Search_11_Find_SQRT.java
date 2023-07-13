public class Binary_Search_11_Find_SQRT {

    private static int find_sqrt(int num){
        int low = 1, high = num;
        while(low<=high){
            int mid = low + (high-low)/2, value = mid*mid;
            if(value<=num) low = mid+1;
            else high = mid-1;
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println("sqrt of 25 : " + find_sqrt(25));
        System.out.println("sqrt of 53 : " + find_sqrt(53));
    }
}
