import java.util.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
 
public class Tree_29_Tree_To_LinkedList {

    public static Node Make_My_Tree(Node root){
        // Storing values in nodes 
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eight = new Node(8);
        Node ninth = new Node(9);
        Node tenth = new Node(10);
        Node eleventh = new Node(11 );
        Node twelth = new Node(12);
        Node thirteenth = new Node(13);

        // Giving reference of left and right nodes to each node 
        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        fourth.left = eight;
        fourth.right = ninth;
        fifth.left = tenth;
        fifth.right = eleventh;
        eleventh.left = twelth;
        eleventh.right = thirteenth;

        return root;
    }

    public static void main(String[] args) {
         
    }
}
