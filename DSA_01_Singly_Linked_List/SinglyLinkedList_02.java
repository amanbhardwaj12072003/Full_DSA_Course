// In this file we will see deletion of nodes in a singly linked list

public class SinglyLinkedList_02 {

    private static ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Now we will write a method to delete the first node of the singly linked list
    // My Method
    public void deleteFirst(){
        ListNode current = head;
        head = current.next;
        current.next = null;
    }

    // This code can also be written as 
    // Video Method
    /*
    public ListNode deleteFirst(){
        ListNode current = head;
        head = current.next;
        current.next = null;
    }
    */

    // Method to print the singly linked list 
    public void display(){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Now we will write the method to delete the last node of the singly linked list
    // My Method
    /*
    public void deleteLast(){
        ListNode current = head;
        while(current.next.next!=null){   // The best thing to feel here is next.next
            current = current.next;
        }
        current.next = null;
    }                                                                                                    
    */

    // Video Method for this

    public ListNode deleteLast(){
        if(head==null || head.next==null){
            return head;   // If head.next==null , then basically we do not have to delete any thing 
        }
        
        ListNode current = head;
        ListNode previous = null;

        while(current.next!=null){
            previous = current;
            current = current.next;
            // By above 2 lines we made previous and current to move together
        }
        previous.next = null;
        return current;
    }


    // Now we will write method to delete node at a custom position

    public void delete(int position){
        if(position==1){
            head = head.next; // This will automatically delete the first node 
        }
        ListNode previous = head;
        int count = 1;
        while(count < position-1){
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = current.next; // This will break the linkage of the node current which is to be deleted.
    }

    public static void main(String[] args) {
      
        // Forming nodes 

        SinglyLinkedList_02 sll = new SinglyLinkedList_02();
        sll.head = new ListNode(12);
        ListNode second = new ListNode(14);
        ListNode third = new ListNode(16);
        ListNode fourth = new ListNode(18);
        ListNode fifth = new ListNode(20);
        ListNode sixth = new ListNode(24);
        ListNode seventh = new ListNode(28);

        // Now connecting the nodes using the reference

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        System.out.println("singly linked list before deletion of first node");
        sll.display();

        sll.deleteFirst();
        System.out.println("singly linked list after deletion of first node");
        sll.display();

        sll.deleteLast();
        System.out.println("singly linked list after deletion of last node");
        sll.display();

        sll.delete(2);
        System.out.println("singly linked list after deletion of node at custom position here 2");
        sll.display();

    }
}
