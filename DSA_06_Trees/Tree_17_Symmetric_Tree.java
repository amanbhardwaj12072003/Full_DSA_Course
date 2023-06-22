import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_17_Symmetric_Tree {

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

        return root;
    }

    // Algorithm to identify symmetric tree 

    public static boolean Check(Node root){
        if(root == null) return true;
        return Helper(root.left , root.right);
    }

    public static boolean Helper(Node left , Node right){
        if(left== null || right == null) return left == right;
        if(left.data != right.data) return false;
        return Helper(left.left, right.right) && Helper(left.right, right.left);
    }

    // Algorithm to find weather leftsubtree and rightsubtree identical or not 

    public static boolean Check_(Node root){
        if(root == null) return true;
        return Helper_(root.left , root.right);
    }

    public static boolean Helper_(Node left , Node right){
        if(left == null || right == null) return left == right;
        if(left.data != right.data) return false;
        return Helper_(left.left, right.left) && Helper_(left.right, right.right);
    }


    public static void main(String[] args) {
        
        Node root = null;
        root = Make_My_Tree(root);
        boolean isSymmetric = Check(root);
        System.out.println("The Given Binary Tree Is Symmetric : " + isSymmetric);

        boolean haveIdenticalSubtrees = Check_(root);
        System.out.println("Left And Right SubTrees Of The Binary Tree Are Identical : " + haveIdenticalSubtrees);

    }
}
