import java.util.*;

// A class to instantiate node of a tree 
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_01_Pre_Order {

    // Method to instantiate a tree.
    public static Node Make_My_Tree(Node root){
                // Storing Values In Respective Nodes
                Node first = new Node(1);
                Node second = new Node(2);
                Node third = new Node(3);
                Node fourth = new Node(4);
                Node fifth = new Node(5);
                Node sixth = new Node(6);
                Node seventh = new Node(7);
                Node eight = new Node(8);
                Node ninth = new Node(9);
        
                // Giving Reference For Respective Nodes 
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
    /*
    Recursive Code For Pre-Order Traversal
    Pre Order --> root  > left > right
    Time Complexity : O(n) --> Each node is being traversed exactly once in the traversal 
    Space Complexity : O(n) --> Space is needed for recursive calls and in worst case(Skewed Tree) the recursion stack will have size n 
     */
    public static void Pre_Order_Recursive(Node root){
        if(root == null) return;
        System.out.print(root.data + "-->");
        Pre_Order_Recursive(root.left);
        Pre_Order_Recursive(root.right);
    }


    /*
    Recursive Code For Pre-Order Traversal
    Pre Order --> root  > left > right
    Time Complexity : O(n)  --> Each node is being traversed exactly once in the traversal 
    Space Complexity : O(n) --> n sized stack will be needed in the worst case of skwed tree
    */
    public static void Pre_Order_Iterative(Node root){
        if(root == null) System.out.println("Empty Tree");
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node topNode = stack.peek();
            System.out.print(topNode.data + "-->");
            stack.pop();
            if(topNode.right != null){
                stack.add(topNode.right);
            }
            if(topNode.left != null){
                stack.add(topNode.left);
            }
        }
    }
    // This is dfs 

    public static void main(String[] args) {
    
        Node root = null;
        Node treeRoot = Make_My_Tree(root);
        System.out.println("PreOrder traversal of the tree using recursion...");
        Pre_Order_Recursive(treeRoot);
        System.out.println("\nPreOrder traversal of the tree using iteration...");
        Pre_Order_Iterative(treeRoot);
        
    }
}
