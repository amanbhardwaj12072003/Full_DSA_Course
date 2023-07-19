import java.util.*;

public class Ques1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int len = sc.nextInt();
            int[] arr1 = new int[len], arr2 = new int[len];
            for(int index=0;index<len;index++){
                arr1[index] = sc.nextInt();
            }
            int answer = 0;
            for(int index=1;index<len;index++){
                if(arr1[index]<arr1[index-1] && arr2[index-1]>25){
                    arr2[index] = arr2[index-1]+1;
                    answer++;
                    continue;
                }
                int temp = arr2[index-1], count = 0;
                while(arr1[index]<arr1[index-1]-count){
                    count += Math.pow(2,temp);
                    temp++;
                }
                arr2[index] = temp-1;
            }
            System.out.println(answer);
        }
    }
}