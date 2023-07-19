public class Ques2 {

    public static int _rand(String str1, String str2){
        int len1 = str1.length(), len2 = str2.length();
        return len1 + len2;
    }

    public static int rand(int x, int y, int z){
        int a = x*y, b = y*z, c = z*x;
        return a + b + c;
    }

    public static void rand_(int[] arr){
        int temp = 3;
        for(int index=0;index<arr.length;index++){
            arr[index] += temp;
        }
    }

    public static boolean solve(int[] nums){
        // Random Variables 
        String str1 = "Aman", str2 = "Bhardwaj";
        int[] arr = {1,2,3,4,5,6};

        // _rand()
        _rand(str1,str2);

        // Solve Question
        int avgValue = 0, len = nums.length;
        for(int num : nums) avgValue+=num;
        int findAns=0;
        findAns = avgValue/len;

        // rand()
        rand(3,6,8);

        avgValue%=len;
        float temp = (float)avgValue/len;
        if(temp>=0.5){
            findAns += 1;
        }else{
            findAns += 0;
        }
        for(int num : nums){
            if(num==findAns) return true;
        }

        // rand_()
        rand_(arr);


        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,4};
        int[] arr2 = {1,2,5};
        int[] arr3 = {8,6,6,8,9,8};
        System.out.println(solve(arr1));
        System.out.println(solve(arr2));
        System.out.println(solve(arr3));
    }
}
