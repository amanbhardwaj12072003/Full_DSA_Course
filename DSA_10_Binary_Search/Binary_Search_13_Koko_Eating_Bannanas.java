public class Binary_Search_13_Koko_Eating_Bannanas {

    private static int getTotalHours(int[] arr, int rate){
        int totalHours = 0;
        for(int num : arr) totalHours+=Math.ceil((double)num/(double)rate);
        return totalHours;
    }

    private static int getMax(int[] arr){
        int max = -1;
        for(int num : arr) max = Math.max(max,num);
        return max;
    }

    private static int findMinRate(int[] arr, int maxHours){
        int low = 1, high = getMax(arr), ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2; // Hourly Rate 
            int totalHours = getTotalHours(arr, mid);
            if(totalHours<=maxHours){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        int maxHours = 8;
        System.out.println("Min Possible Hourly Rate : " + findMinRate(arr, maxHours));
    }
}
