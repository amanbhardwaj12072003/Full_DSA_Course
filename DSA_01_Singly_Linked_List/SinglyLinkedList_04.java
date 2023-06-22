// In this file we learnt reversing the givien linkedlist and finding that weather some element is present in the given singly likedlist.

public class SinglyLinkedList_04 {

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
        System.out.println("");
    }

    // Now we will write method to find the middle node in the given singly liked list

    public ListNode findMid(ListNode head){
        
        if(head==null){
            return head;
        }

        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    // Now we will write a method to find nth node from the last in a singly linked list...
    // Good Observation 
    public ListNode nFromLast(ListNode head , int n){
        
        if(head==null){
            return head;
        }

        if(n<=0){
            throw new IllegalArgumentException("Invalid Value Input n : " + n);
        }

        ListNode mainNode = head;
        ListNode refNode = head;
        int count = 0;
        // Doing this will create a difference of n nodes between the refNode and the mainNode
        while(count<n){
            refNode = refNode.next;
            count++;
        }
        while(refNode!=null){
            refNode = refNode.next;
            mainNode = mainNode.next;
        }
        return mainNode;
    }


    public static void main(String[] args) {
        
        SinglyLinkedList_04 sll = new SinglyLinkedList_04();
        sll.head = new ListNode(5);
        ListNode second = new ListNode(9);
        ListNode third = new ListNode(7);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(2);
        ListNode sixth = new ListNode(11);
        ListNode seventh = new ListNode(12);
        ListNode eigth = new ListNode(10);
        ListNode ninth = new ListNode(0);    
        ListNode tenth = new ListNode(13);

        // Now we will be linking the nodes
        
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eigth;
        eigth.next = ninth;
        ninth.next = tenth;

        sll.Display(head);
        ListNode midNode = sll.findMid(head);
        System.out.println(midNode.data);

        ListNode n_from_last = sll.nFromLast(head, 4);
        System.out.println(n_from_last.data);


    }
}
