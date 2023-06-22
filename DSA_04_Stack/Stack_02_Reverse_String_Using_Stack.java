import java.util.Stack;
import java.util.Scanner;
public class Stack_02_Reverse_String_Using_Stack {

    public static String reverse_String(String query){
        Stack<Character> stack = new Stack<>();
        char[] arr = query.toCharArray();
        for(char c : arr){
            stack.push(c);
        }
        for(int i=0;i<query.length();i++){
            arr[i] = stack.pop();
        }
        
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String demo = sc.nextLine();
        String result = reverse_String(demo);
        System.out.println("The Original String : " + demo);
        System.out.println("The Reversed String : " + result);

        // Note that is we reverse the String --> "Hello World" then we get the output as dlroW ollH ...and from this it is evident that space is also considered as a character in java 
    }
}
