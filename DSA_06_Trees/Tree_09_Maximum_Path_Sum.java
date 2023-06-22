import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_09_Maximum_Path_Sum {

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

        // Giving Reference Of Left And Right Node 
        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        fourth.left = eight;
        fourth.right = ninth;

        return root;
    }

    public static int Maximum_Path_Sum(Node root , int[] maximum){
        if(root == null) return 0;

        int left_sum = Math.max(0,Maximum_Path_Sum(root.left, maximum));
        int right_sum = Math.max(0,Maximum_Path_Sum(root.right, maximum));
        maximum[0] = Math.max(maximum[0],root.data+right_sum+left_sum);
        return root.data+ Math.max(left_sum,right_sum);
    }

    public static void main(String[] args) {

        Node root = null;
        root = Make_My_Tree(root);
        int[] maximum = new int[1];
        Maximum_Path_Sum(root, maximum);
        System.out.println("Maximum Path Sum : " + maximum[0]);
        
    }
}
