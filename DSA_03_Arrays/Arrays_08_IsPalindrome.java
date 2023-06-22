public class Arrays_08_IsPalindrome {

    public static boolean isPalindrome(String query){
        char [] characters = query.toCharArray();
        int start = 0;
        int end = query.length() - 1;
        while(start<end){
            if(characters[start] != characters[end]){
                return false;
            }
            start++;
            end--;
        } 
        return true;
    }

    public static void main(String[] args) {
        String demo1 = "asdfghjhgfdsa";
        String demo2 = "zxcvbnmbvcxz";
        boolean b1 = isPalindrome(demo1);
        boolean b2 = isPalindrome(demo2);
        System.out.println("The given string demo1 is a palindrome : " + b1 );
        System.out.println("The given string demo2 is a palindrome : " + b2);
    }
}
