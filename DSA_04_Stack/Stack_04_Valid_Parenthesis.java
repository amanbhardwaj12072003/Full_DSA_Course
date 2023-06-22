import java.util.Stack;
import java.util.Scanner;
public class Stack_04_Valid_Parenthesis {

    // Algorithm Using The Stack 

    // Note that this algorithm have logical error and the error is that is gives true for the string 
    // ))()()(()( , but the correct output is false as it is not following the property of valid parenthesis
 
    public static boolean validParenthesis(String query){
        char[] array = query.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : array){
            if(c=='('){
                stack.push(c);
            }
        }
        for(char t : array){
            if(t==')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    // Algorithm WithOut Using The Stack
    // Note that this algorithm have logical error and the error is that is gives true for the string 
    // ))()()(()( , but the correct output is false as it is not following the property of valid parenthesis

    public static boolean IsValid(String input){
        char[] arr = input.toCharArray();
        int n = 0;
        for(char c : arr){
            if(c=='('){
                n++;
            }
        }
        for(char t : arr){
            if(t==')'){
                if(n==0){
                    return false;
                }
                n--;
            }
        }
        return true;
    }

    // This is the perfect algorithm with no logical error 


    public static boolean operation(String query){
        char[] arr = query.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : arr){
            if(c=='('){
                stack.push(c);
            }
            if(c==')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    public static boolean operation_(String quest){
        char[] arr = quest.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c : arr){
            if(c=='('){
                stack.push(c);
                count++;
            }

            if(c==')'){
                if(count==0){
                    return false;
                }
                count--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String demo = sc.nextLine();

        // Using the algorithm-2 

        System.out.println("Do The Input String Satisfies The Condition Of Valid Parenthesis : " + validParenthesis(demo));

        // Using the algorithm-1

        System.out.println("Is Valid Parenthesis System : " + IsValid(demo));

        // Using the algorith-3 

        System.out.println("Is It Having The Property Of Valid Parenthesis : " + operation(demo));

        // Using the algorith-4

        System.out.println("Is It Having The Property Of Valid Parenthesis : " + operation_(demo));
    }
}
