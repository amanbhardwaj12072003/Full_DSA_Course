// In this file we will be writing the algorithm to merge two sorted singly linked list 

public class SinglyLinkedList_07 {

    private static ListNode head_a;
    private static ListNode head_b;

    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Algorithm to print the singly linked list 

    public void display(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Now we will write algorithm to merge these two sorted singly linked list.

    public ListNode merge(ListNode a , ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(a != null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }
            else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if(a==null){
            tail.next = b;
        }
        else{
            tail.next = a;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        
        SinglyLinkedList_07 sll = new SinglyLinkedList_07();
        sll.head_a = new ListNode(1);
        ListNode second_a = new ListNode(2);
        ListNode third_a = new ListNode(5);
        ListNode fourth_a = new ListNode(6);
        ListNode fifth_a = new ListNode(9);
        ListNode sixth_a = new ListNode(10);
        ListNode seventh_a = new ListNode(13);

        sll.head_a.next = second_a;
        second_a.next = third_a;
        third_a.next = fourth_a;
        fourth_a.next = fifth_a;
        fifth_a.next = sixth_a;
        sixth_a.next = seventh_a;

        sll.head_b = new ListNode(4);
        ListNode second_b = new ListNode(8);
        ListNode third_b = new ListNode(11);
        ListNode fourth_b = new ListNode(12);

        sll.head_b.next = second_b;
        second_b.next = third_b;
        third_b.next = fourth_b;

        System.out.println("Singly Linked List a ");
        sll.display(head_a);
        System.out.println("Singly Linked List b ");
        sll.display(head_b);

        ListNode merged_List = sll.merge(head_a, head_b);
        sll.display(merged_List);


    }
}
