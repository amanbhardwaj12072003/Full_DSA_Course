// In this file we learnt reversing the givien linkedlist and finding that weather some element is present in the given singly likedlist.

public class SinglyLinkedList_03 {

    private static ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Writing method to print the singly linekd list

    public void Display(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.print("null");
    }

    // Now we will make method to find wether some data is present in linkedlist or not

    public boolean find(ListNode head,int searchKey){
        if(head==null){
            return false;
        }
        ListNode current = head;
        while(current!=null){
            if(current.data==searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Now we will write a method to reverse a singly linked list

    // We must note one thing that as we are learning algorithms so we should also keep them learning as we have to apply the algorithm as and when needed rather then creating our own algorithm....This will increase our speed of solving question...
    // Important 
    public ListNode reverse(ListNode head){

        if(head == null){
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;   // This method return output of the data type ListNode 
    }
    

    public static void main(String[] args) {
        
        SinglyLinkedList_03 sll = new SinglyLinkedList_03();
        sll.head = new ListNode(5);
        ListNode second = new ListNode(9);
        ListNode third = new ListNode(7);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(2);
        ListNode sixth = new ListNode(11);
        ListNode seventh = new ListNode(12);
        ListNode eigth = new ListNode(10);

        // Now we will be linking the nodes
        
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eigth;

        // Now we will try to find some data in the singly linked list

        if(sll.find(head, 12)){
            System.out.println("This data is found in the singly linked list");
        }
        else{
            System.out.println("This data is not found in the singly linked list");
        }

        if(sll.find(head,3)){
            System.out.println("This data is found in the singly linked list ");
        }
        else{
            System.out.println("This data is not found in the singly linked list");
        }

        // We applied the method find() on sll as we apply method on the object of the class in which the method in written .
  
        sll.Display(head);
        System.out.println("");

        ListNode reversed_list_head = sll.reverse(head);
        sll.Display(reversed_list_head);
        System.out.println("");

    }
}
