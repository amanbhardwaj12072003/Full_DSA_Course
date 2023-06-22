import java.util.Stack;
public class Stack_03_Next_Greater_Element {

    public static int[] nextGreater(int[] array){
        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=array.length-1;i>=0;i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= array[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                // stack.push(array[i]);
                result[i] = -1;
            }
            else{
                result[i] = stack.peek();
            }
            stack.push(array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        
        int[] demo = {4,7,3,4,8,1};
        System.out.println("The original array is : ");
        for(int t : demo){
            System.out.print(t + " ");
        }
        System.out.println();
        int[] ans = nextGreater(demo);
        System.out.println("The array storing the next greater element of the original element is :");
        for(int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
