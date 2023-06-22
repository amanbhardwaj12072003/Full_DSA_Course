public class SinglyLinkedList_05 {

    // This is the head of the singly linked list which is input for many methods...
    private static ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Writing the method to print the singly linked list 

    public void display(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.println("null");
    }

    //Now we will write method to remove the duplicate node data from the given sorted singly linked list

    public ListNode removeDuplicates(ListNode head){
        if(head==null){
            return head;
        }
        ListNode current = head;
        while(current!=null && current.next!=null){
            if(current.data==current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
        return head;
    }

    // Now we will write a method to insert a node in a sorted singly linked list such that after insertion 
    // of the node too it will be sorted...

    public ListNode insertSorted(ListNode head , ListNode newNode){ 
        if(head==null){
            return head;
        }
        
        ListNode current = head;
        ListNode temp = null;

        while(current!=null && current.data<newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = current;

        // Reason behind returning head is that for a singly linked list the head is sufficient to give a singly linkedlist as every node has reference to next node 

        return head;
    }

    // Now we will be writing a method to deleted the node storing the given data....

    public ListNode deleteNode(ListNode head, int key){

        if(head==null){
            return head;
        }
        ListNode current = head;
        ListNode temp = null;

        while(current!=null && current.data!=key){
            temp = current;
            current = current.next;
        }

        if(current==null){
            return null;
        }

        temp.next = current.next;

        return head;

    }
    

    public static void main(String[] args) {

        SinglyLinkedList_05 sll = new SinglyLinkedList_05();

        // Intentionally making a sorted singly linked list

        sll.head = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(2);
        ListNode fifth = new ListNode(3);
        ListNode sixth = new ListNode(4);
        ListNode seventh = new ListNode(5);
        ListNode eight = new ListNode(5);
        ListNode ninth = new ListNode(5);
        ListNode tenth = new ListNode(5);
        ListNode eleventh = new ListNode(7);
        ListNode twelth = new ListNode(9);
        ListNode thirteenth = new ListNode(11);

        // Providing every node with the reference for next node 

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eight;
        eight.next = ninth;
        ninth.next = tenth;
        tenth.next = eleventh;
        eleventh.next = twelth;
        twelth.next = thirteenth;

        sll.display(head);

        // Note that as the output of the method is nothing but of the type ListNode hence we will store the output in ListNode data type only.... 
        ListNode removed_duplicates = sll.removeDuplicates(head);
        sll.display(removed_duplicates);

        ListNode newNode = new ListNode(8);
        ListNode new_node = sll.insertSorted(head, newNode);
        // Note that as this method return haed hence new_node is the head of the resulting singly linked list....
        sll.display(new_node);

        ListNode node_after_remove = sll.deleteNode(head, 7);
        sll.display(node_after_remove);

    }
}
