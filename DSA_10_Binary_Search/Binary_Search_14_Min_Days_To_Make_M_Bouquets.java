public class Binary_Search_14_Min_Days_To_Make_M_Bouquets {

    private static boolean isPossible(int[] arr, int day, int bouquetCount, int flowerNeed, int[] storeMinMax){
        int countFlower = 0, countBouquet = 0, max = -1, min = Integer.MAX_VALUE;
        for(int num : arr){
            min = Math.min(min,num);
            max = Math.max(max,num);
            if(num<=day){ countFlower++; }
            else{
                countBouquet += countFlower/flowerNeed;
                countFlower = 0;
            }
        }
        countBouquet += countFlower/flowerNeed;
        storeMinMax[0] = min;
        storeMinMax[1] = max;
        return countBouquet>=bouquetCount;
    }

    private static int find(int[] arr, int bouquetCount, int flowerNeed){
        int[] storeMinMax = new int[2];
        isPossible(arr, 0, bouquetCount, flowerNeed, storeMinMax);

        // Edge Case
        if(arr.length<bouquetCount*flowerNeed) return -1;

        // Code 
        int low = storeMinMax[0], high = storeMinMax[1], minDay = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(arr, mid, bouquetCount, flowerNeed, storeMinMax)){
                minDay = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return minDay;
    }

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,13,11,12,7};
        int bouquetCount = 2, flowerNeed = 3;
        System.out.println("Latest day on which its possible : " + find(arr,bouquetCount,flowerNeed));
    }
}
 