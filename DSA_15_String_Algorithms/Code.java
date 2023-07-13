import java.util.*;

public class Code {

    public static int fun(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int max = -1, min = 31;
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if ((min * max) % ((i==j) ? 1 : j-i+1) == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,3};
        System.out.println(fun(arr,3));
    }
}
