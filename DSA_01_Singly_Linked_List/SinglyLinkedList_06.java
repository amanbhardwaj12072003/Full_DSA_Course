public class SinglyLinkedList_06 {

    // Making a singly linkedlist containing some loop and will write a method to find that weather there is a loop in the given linked list or not....

    private static ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // algorithm to print the singly linked list

    public void display(){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.println("null");
    }

    // Now we will write a method to detect the loop in the given singly linked list

    public boolean detectLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            // Note that fastPtr is moving relatively faster then the slowPtr hence if there is some loop in the singly linkedlist then there will be a time when both will meet else there is not loop can be concluded....

            /*
            if(fastPtr.data = slowPtr.data){
                return true;
            }
            */

            if(fastPtr==slowPtr){
                return true;
            }
        }
        return false;
    }

    // Now we will write a algorithm to find the starting node of the singly linked list....

    // Note that this alogorithm is also known as  : Floyd's Cycle Detection Algorithm

    public ListNode detectLoopForFirstNodeOfLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr==fastPtr){
                return getFirstNodeOfLoop(slowPtr);
            }
        }
        return null;
    }

    public ListNode getFirstNodeOfLoop(ListNode slowPtr){
        ListNode temp = head;
        while(slowPtr != temp){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    // Now we will write algorithm to remove the loop present in the given singly linked list

    public ListNode detectLoopForRemoveLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr==slowPtr){
                return removeLoop(slowPtr);
            }
        }
        return null;
    }

    public ListNode removeLoop(ListNode slowPtr){
        ListNode temp = head;
        while(slowPtr.next != temp.next){
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        slowPtr.next = null;
        return head;
    }



    public static void main(String[] args) {
        
        SinglyLinkedList_06 sll = new SinglyLinkedList_06();
        sll.head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode ninth = new ListNode(9);
        ListNode tenth = new ListNode(10);
        
        // Now we will give references in following way so that it will have a loop..

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eight;
        eight.next = ninth;
        ninth.next = tenth;
        tenth.next = fifth;

        // This singly linkedlist will look like 

        /*

        1 ---> 2 ---> 3 ---> 4 ---> 5 ---> 6 ---> 7
                                    |              |
                                    |              |
                                    10 <---- 9<----8   

        */

        boolean contain_loop = sll.detectLoop();
        if(contain_loop){
            System.out.println("Yes loop is present in the given singly linked list");
        }
        else{
            System.out.println("No the loop is not present in the given singly linked list");
        }

        // Finding the start of the loop in the given singly linked list 

        ListNode first_node_of_loop = sll.detectLoopForFirstNodeOfLoop();
        System.out.println("The starting of the loop of the singly linked list : " + first_node_of_loop.data);

        // Removing the loop from the singly linked list 


        // sll.display(); // Note that printing the singly linkedlist containing the loop is an end less process...


        // This can also be done by void data type....
        ListNode is_loop_remove_loop = sll.detectLoopForRemoveLoop();
        sll.display();
        

    }
}
