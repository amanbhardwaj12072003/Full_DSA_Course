import java.util.NoSuchElementException;

public class DoublyLinkedList_01 {

    // How to initiate the doubly linked list

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{

        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
        }
    }

    // Constructor 
    public DoublyLinkedList_01(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    // public int length_dll(){
    //     ListNode current = head;
    //     while(current != null){
    //         // length++; 
    //         current = current.next;
    //         length++; 
    //     }
    //     return length;
    // }

    // Now we will write the algorithm to insert the elements in the doubly linked list.

    public void insertLast(int value){
        // Forming a node with the given data storage.
        ListNode newNode = new ListNode(value); 
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;  //
        }

        // Why we are doing this is the fact that now we are dealing with doubly linked list 
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    //This is the algorithm to insert the node at the bigenning of the doubly linked list 

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        }
        else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    // This is the algorithm the print the elements of the doubly linkedlist from forward direction

    public void dispayForward(){
        if(head==null){
            System.out.println("null doubly linkedlist ");
            return;
        }

        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ---> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    // This is the algorithm to print the elements of the doubly linkedlist from the backward direction

    public void displayBackward(){
        if(tail==null){
            System.out.println("null doubly linkedlist ");
        }
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + "--->");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // This is the algorithm to delete the first node of the doubly linked list...

    public ListNode deleteFirst(){

        ListNode temp = head;
        
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if(head==tail){
            tail = null;
        }
        else{
            head.next.previous = null;
        }

        head = head.next;
        temp.next = null;

        return temp;
    }

    // This is the algorithm to delete the last node of the doubly linked list 

    public void deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(head==tail){
            head = null;
        }
        else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        tail.next = null;
    }



    public static void main(String[] args) {
        
        DoublyLinkedList_01 dll = new DoublyLinkedList_01();
        dll.insertLast(12);
        dll.insertLast(32);
        dll.insertLast(4);
        dll.insertLast(11);
        dll.insertLast(10);
        dll.insertLast(19);

        // Printing the doubly linkedlist in forward direction
        dll.dispayForward();

        // Printing the doubly linkedlist in backward direction
        dll.displayBackward(); 

        System.out.println("The length of the doubly linked list : "+dll.length);

        System.out.println("The length of the doubly linked list is : " + dll.length);

        dll.insertFirst(11);
        dll.dispayForward();
        System.out.println("The length of the doubly linked list is : " + dll.length);


        dll.insertLast(13);
        dll.dispayForward();
        System.out.println("The length of the doubly linked list is : " + dll.length);

        dll.deleteFirst();
        dll.dispayForward();

        dll.deleteLast();
        dll.dispayForward();


    }
}
