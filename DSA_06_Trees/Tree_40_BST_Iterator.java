import java.util.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
class BST_Iterator{
    private static Stack<Node> stack = new Stack<>();

    public BST_Iterator(Node root){
        pushAll(root);
    }
    public static void pushAll(Node node){
        for( ; node != null ; stack.push(node) , node = node.left);
    }

    public static boolean hasNext(Node root){
        return !stack.isEmpty();
    }

    public static int next(){
        Node temp = stack.pop();
        pushAll(temp.right);
        return temp.data;
    }
}
public class Tree_40_BST_Iterator {
    public static Node BST(Node root){
        Node first = new Node(10);
        Node second = new Node(5);
        Node third = new Node(13);
        Node fourth = new Node(3);
        Node fifth = new Node(6);
        Node sixth = new Node(11);
        Node seventh = new Node(14);
        Node eight = new Node(2);
        Node ninth = new Node(4);
        Node tenth = new Node(9);
        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        fourth.left = eight;
        fourth.right = ninth;
        fifth.right = tenth;
        
        return root;
    }

    public static void main(String[] args) {
        
    }
}
