// import java.util.EmptyStackException;

// import java.util.EmptyStackException;

public class Stack_01_Implementing_Stack_By_LinkedList {

    private ListNode top;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
        }
    }

    public Stack_01_Implementing_Stack_By_LinkedList(){
        top = null;
        length = 0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }


    // public void EmptyStackException(){
    //     System.out.println("EmptyStackException");
    // }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }


    public static void main(String[] args) {

        Stack_01_Implementing_Stack_By_LinkedList stack = new Stack_01_Implementing_Stack_By_LinkedList();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);
        stack.push(30);

        System.out.println("Length before Peek : " + stack.length);
        System.out.println("Peeking stack : " + stack.peek());
        System.out.println("Length after peek : " + stack.length);
        System.out.println("Popping stack : " + stack.pop());
        System.out.println( "Length after Pop : " + stack.length);        
    }
}
