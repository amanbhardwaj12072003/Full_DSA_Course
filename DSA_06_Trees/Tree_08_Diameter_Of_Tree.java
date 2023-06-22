/*
Diameter of tree is defined as the longest path between two nodes of 
tree and the path may or may not pass through root of the tree.
 */
import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_08_Diameter_Of_Tree {

    public static Node Make_My_Tree(Node root){
        // Storing Values In Nodes 
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eight = new Node(8);
        Node ninth = new Node(9);

        // Giving Reference To Each Node Of It's Left And Right Nodes 
        root = first;
        root.left = second;
        root.right = third;
        third.left = fourth;
        third.right = fifth;
        fourth.left = sixth;
        sixth.left = seventh;
        fifth.right = eight;
        eight.right = ninth;

        return root;
    }

    // Method To Find Height Of Tree In O(n)
    public static int Height(Node root){
        if(root == null) return 0;

        int left_height = Height(root.left);
        int right_height = Height(root.right);
        
        return 1 + Math.max(left_height , right_height);
    }

    // Method To Find Diameter Of Tree In O(n^2)
    public static void Diameter(Node root , int[] maximum){
        if(root == null) return;

        int left_height = Height(root.left);
        int right_height = Height(root.right);

        maximum[0] = Math.max(maximum[0] , left_height+right_height);
        Diameter(root.left, maximum);
        Diameter(root.right, maximum);
    } 
    
    // Optimized Method To Find Diameter Of Tree In O(n)
    public static int Diameter_(Node root , int[] maximum){
        if(root == null) return 0;

        int left_height = Diameter_(root.left, maximum);
        int right_height = Diameter_(root.right, maximum);
        maximum[0] = Math.max(maximum[0] , left_height + right_height);
        return 1 + Math.max(left_height, right_height);

        // Here Maximum Is Storing Length Of Maximum Path Possible Passing From Each Node 
    }

    public static void main(String[] args) {

        Node root = null;
        root = Make_My_Tree(root);
        int[] maximum = new int[1];
        Diameter(root, maximum);

        int[] maximum_ = new int[1];
        Diameter_(root, maximum_);

        System.out.println("Finding Diameter Of Tree In O(n^2) : " + maximum[0]);
        System.out.println("Finding Diameter Of Tree In O(n) : " + maximum_[0]);

        // We have to make an array to store maximum as in Java variables can not be passed as refrence 
        
    }
}
