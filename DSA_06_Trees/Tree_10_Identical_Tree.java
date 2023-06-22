import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_10_Identical_Tree {

    public static Node Make_My_Tree1(Node root){
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

    public static Node Make_My_Tree2(Node root){
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
        second.left = sixth;
        second.right = seventh;
        third.left = eight;
        third.right = ninth;
        eight.left = fourth;
        eight.right = fifth;

        return root;
    }

    // Recursive Approach 
    public static boolean Identical_Trees(Node root1 , Node root2){

        if(root1 == null || root2 == null) return (root1 == root2);

        return (root1.data==root2.data) && (Identical_Trees(root1.left, root2.left)) && (Identical_Trees(root1.left, root2.right));
    }

    // Trivial Approch : Storing Values In 2 Arrays Of Respective Tree And Then Comparing Arrays 

    public static void main(String[] args) {

        Node root1 = null , root2 = null;
        root1 = Make_My_Tree1(root1);
        root2 = Make_My_Tree2(root2);
        System.out.println("Are The Two Given Tress Equal : " + Identical_Trees(root1, root2));
        
    }
}
