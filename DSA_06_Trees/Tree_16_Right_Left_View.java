import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}


public class Tree_16_Right_Left_View {

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

    // Right View Algorithm 
    // Recursive Code 
    // In this the traversal order we following is Right -> Root -> Left

    public static void RightView(Node root , int level , List<Integer> store){
        
        // Base Case
        if(root == null) return;

        // General Case
        if(level == store.size()) store.add(root.data);
        RightView(root.right, level + 1, store);
        RightView(root.left, level + 1, store);
    }

    public static void LeftView(Node root , int level , List<Integer> store){
        
        // Base Case
        if(root == null) return;

        // General Case
        if(level == store.size()) store.add(root.data);

        LeftView(root.left, level+1, store);
        LeftView(root.right, level+1, store);
    }
    

    public static void main(String[] args) {
        
        Node root = null;
        root = Make_My_Tree(root);
        List<Integer> rightview = new ArrayList<>();
        RightView(root, 0, rightview);
        List<Integer> leftview = new ArrayList<>();
        LeftView(root , 0 , leftview);

        System.out.println("Right View : " + rightview);
        System.out.println("Left View : " + leftview);
        
    }
}
