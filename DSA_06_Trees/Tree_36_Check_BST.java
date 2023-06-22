import java.util.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_36_Check_BST {

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
    
    // Algorithm to validate the given binary search tree
    // We are assigning a range to every node that...ok it's value will range from this to this..
    public static boolean isValidBST(Node root , long Min_Val , long Max_Val){
        if(root == null) return true;
        if(root.data > Max_Val || root.data < Min_Val) return false;
        return isValidBST(root.left, Min_Val, root.data) && isValidBST(root.right, root.data, Max_Val);
    }

    public static void main(String[] args) {
        Node root = null;
        root = BST(root);
        System.out.println("Is The Given Binary Tree A Binary Search Tree : " + isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
