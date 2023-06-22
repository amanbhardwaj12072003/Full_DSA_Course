import java.util.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_37_LCA_In_BST {

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
    public static Node LCA(Node root , Node node1 , Node node2){
        // Base Case
        if(root == null) return null;

        // General Cases
        if(root.data < node1.data && root.data < node2.data) return LCA(root.right,node1,node2);
        if(root.data > node1.data && root.data > node2.data) return LCA(root.left,node1,node2);

        // Else return the root as this is LCA 
        return root;

    }

    public static void main(String[] args) {
        Node root = null;
        root = BST(root);
        Node node1 = new Node(2);
        Node node2 = new Node(9);
        Node lca = LCA(root , node1 , node2);
        System.out.println("Lowest Common Ancestor Of 2 And 9 : " + lca.data);
    }
}
