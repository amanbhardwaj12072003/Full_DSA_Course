public class SinglyLinkedList_08 {

    private static ListNode head_1;
    private static ListNode head_2;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = next;
        }
    }

    public void display(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Now we will write method to add the two numbers formed by singly linked list 
    
    public ListNode sum(ListNode a, ListNode b){
        ListNode demo = new ListNode(0);
        ListNode tail = demo;
        int carry = 0;
        while(a!=null || b!=null){
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;

            int sum = x + y + carry;
            carry = sum/10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }

        if(carry>0){
            tail.next = new ListNode(carry);
        }

        return demo.next;
    }


    public static void main(String[] args) {
        
        SinglyLinkedList_08 sll = new SinglyLinkedList_08();
        sll.head_1 = new ListNode(4);
        ListNode second_1 = new ListNode(7);
        ListNode third_1 = new ListNode(2);
        ListNode fourth_1 = new ListNode(9);

        sll.head_1.next = second_1;
        second_1.next = third_1;
        third_1.next = fourth_1;

        sll.head_2 = new ListNode(8);
        ListNode second_2 = new ListNode(5);
        ListNode third_2 = new ListNode(1);

        sll.head_2.next = second_2;
        second_2.next = third_2;

        sll.display(head_1);
        sll.display(head_2);

        ListNode head_of_sum = sll.sum(head_1, head_2);
        sll.display(head_of_sum);


    }
}
