// In this file we will discuss the formation of singly linked list,printing singly linked list,
// finding length of singly linked list,insertion of nodes in a singly linked list.

public class SinglyLinkedList_01 {

    private static ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Now we will write a method to print the elements of the SinglyLinkedList

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("Null");
    }

    // Now we will write a method to find the length of the singly linked list 

    public int length(){
        if(head==null){
            return 0;
        }
        ListNode current = head;
        int count = 0;
        while(current!=null){
            count++;
            current = current.next;
        }
        return count;
    }

    // Now we will write method to insert a node at the beginning of the singly linked list 

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Now we will write method to add a node at the end of the singly linkedlist 

    public void insertLast(int value){
        
        ListNode newNode = new ListNode(value);
        if(head==null){
            head = newNode;
        }
        
        ListNode current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = newNode;
    }

    // Now we will write method to insert node at a custom position in a singly linkedlist

    public void insert(int value,int position){
        
        // 1 --> 4 --> 6 --> 3              // Before insertion of the node
        // insert(5,2)
        // 1 --> 5 --> 4 --> 6 --> 3        // After insertion of the node at the custom position
          
        ListNode node = new ListNode(value);
        
        if(position==1){
            node.next = head;
            head = node;
        }

        else{
            ListNode previous = head;
            int count = 1;
            // Understanding this while loop is very crucial 
            while(count < position-1){
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

     
    public static void main(String[] args) {

        SinglyLinkedList_01 sll = new SinglyLinkedList_01();
        
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        
        // Till now we having nodes storing some int value but for now every node is pointing to null and now we will be joining them together 

        sll.head.next = second;  // 10 --> 1
        second.next = third;     // 10 --> 1 --> 8
        third.next = fourth;     // 10 --> 1 --> 8 --> 11

        // Printing the Singly Lisnked List
        System.out.println("Printing the original linked list");
        sll.display();

        // Printing the length of the Singly Lisnked List
        System.out.println("Printing the length of the singly linked list");
        System.out.println(sll.length());

        // Inserting a node at the beginning of the singly linked list
        System.out.println("Inserting 23 at the start of the singly linked list");
        sll.insertFirst(23);
        sll.display();

        // Inserting a node at the end of the singly linked list
        System.out.println("Inserting 21 at the end of the singly linked list");
        sll.insertLast(21);
        sll.display();

        // Inserting a node at a custom position in the singly linked list
        System.out.println("Interting 33 at 4th position of the singly linked list");
        sll.insert(33, 4);
        sll.display();

    }
}
