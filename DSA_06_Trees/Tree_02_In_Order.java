import java.util.*;

// Class to declare node of tree which stores data (value of the node) and has 2 pointers , left and right. 
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        this.data = data;
    }
}

public class Tree_02_In_Order {
    public static Node MakeMyTree(Node root){

        // Storing Values In Each Node 
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eight = new Node(8);
        Node ninth = new Node(9);
        
        // Giving Reference To Each Node Of It's Left and Right Node 
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
    // InOrder traversal of tree using recursive approach 
    public static void In_Order_Recursive(Node root){
        if(root == null) return;
        In_Order_Recursive(root.left); // Visiting the left subtree of the main tree
        System.out.print(root.data + "-->"); // Start printing from the left most part 
        In_Order_Recursive(root.right); // Visiting the right subtree after visiting the left subtree and root node 
    }
    // InOrder traversal of tree using iteration 
    public static void In_Order_Iterative(Node root){
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(true){
            if(node != null){
                stack.add(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                System.out.print(node.data + "-->");
                node = node.right;
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Node root = null;;
        Node treeRoot = MakeMyTree(root);
        System.out.println("Traversing tree using recursion ");
        In_Order_Recursive(treeRoot);
        System.out.println("");
        System.out.println("Traversing tree using iteration ");
        In_Order_Iterative(treeRoot);
        
    }
}
