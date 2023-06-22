import java.util.NoSuchElementException;

public class Queue_01_Implementing_Queue{

    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode{
        private ListNode next;
        private int data;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public Queue_01_Implementing_Queue(){
        front = null;
        rear = null;
        length = 0;
    }

    // This Is The Algorithm To Insert Element Into The Queue....That Is At Rear End Of The Queue

    public void EnQueue(int data){
        ListNode temp = new ListNode(data);
        if(isEmpty()){
            front = temp;
        }
        else{
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    // This is the algorithm to DeQueue element from the Queue...That Is To Remove The Element From The Queue....That Is From The Front End...But Remember That Queue Follows First In First Out Ideology...

    public int DeQueue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if(front==null){
            rear = null;
        }
        length--;
        return result;
    }

    // Algorithm To Print The Element Of The Queue 

    public void Display(){
        ListNode current = front;
        while(current != null){
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.println("null");
    }



    public static void main(String[] args) {

        // Instantiating an Queue

        Queue_01_Implementing_Queue queue = new Queue_01_Implementing_Queue();

        // Enqueuing elements into the queue

        queue.EnQueue(10);
        queue.EnQueue(20);
        queue.EnQueue(30);
        queue.EnQueue(40);
        queue.EnQueue(50);
        queue.EnQueue(60);
        queue.EnQueue(70);

        // Printing the length of the queue before any dequeue operation

        System.out.println("The Length Of The Queue Before Dequeue Operation Is : " + queue.length);

        // Printing the queue before dequeue operation

        queue.Display();

        // Dequeuing elements from the queue

        System.out.println( " The First Dequeued Element From The Queue : " + queue.DeQueue());
        System.out.println( " The Second Dequeued Element From The Queue : " + queue.DeQueue());

        // Printing the length of the queue after any dequeue operation

        System.out.println("The Length Of The Queue After Dequeue Operation Is : " + queue.length);

        // Printing the queue before dequeue operation

        queue.Display();


        
    }
}
