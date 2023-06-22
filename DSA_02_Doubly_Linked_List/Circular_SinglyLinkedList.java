public class Circular_SinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public Circular_SinglyLinkedList(){
        length = 0;
        last = null;
    }

    public int length(){
        ListNode current = last.next;
        length++; // For counting the first node 
        while(current != last){
            length++;
            current = current.next;
        }
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void createCircularSinglyList(){
        
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = first;

        last = fifth;
    }

    // Algorithm to print the elements of circular singly linked list
    
    public void Display(){
        if(last==null){
            return;
        }
        ListNode first = last.next;
        while(first != last){
            System.out.print(first.data + " ---> ");
            first = first.next;
        }
        System.out.println(last.data + " ---> " + last.next.data);
    }

    // Algorithm to insert a node at the beginning of the circular singly linked list

    public void insertFirst(int value){
        ListNode temp = new ListNode(value);

        if(last == null){
            temp = last;
        }
        else{
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    // Algorithm to insert a node at the end of the circular singly linked list

    public void insertLast(int value){
        ListNode temp = new ListNode(value);
        if(last==null){
            temp = last;
            last.next = last;
        }
        else{
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    // Algorithm to remove first node from the doubly linked list 

    public void deleteFirst(){
        ListNode first = last.next;
        ListNode second = first.next;
        last.next = second;
        first.next = null;
        length--;
        System.out.println("We deleted the first node from the circular singly linked list ");
    }

    // Algorithm to delete the last node from the circular singly linked list

    public void deleteLast(){
        ListNode first = last.next;
        ListNode current = first;
        while(current.next != last){
            current = current.next;
        }
        last.next = null;
        current.next = null;
        current.next = first;
        current = last;
        
    }



    public static void main(String[] args) {

        Circular_SinglyLinkedList csll = new Circular_SinglyLinkedList();
        csll.createCircularSinglyList();
        csll.Display();
        System.out.println( "The length of the circular singly linked list : " + csll.length());
        csll.insertFirst(0);
        csll.Display();
        csll.insertLast(6);
        csll.Display();
        csll.deleteFirst();
        csll.Display();
        csll.deleteLast();
        csll.Display();
        
    }
}
