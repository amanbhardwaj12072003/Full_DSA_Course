import java.util.*;;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_03_Post_Order {

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

        // Giving reference to each node of its respective left and right node 
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

    // Recursive approach for post order traversal 
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static void Post_Order_Recursive(Node root){
        if(root == null) return;
        Post_Order_Recursive(root.left);
        Post_Order_Recursive(root.right);
        System.out.print(root.data + "-->");
    }

    // Iterative approach for post order traversal 
    // Time Complexity : O(n)
    // Space Complexity : O(2n) -> As we used 2 stacks 
    public static void Post_Order_Iterative1(Node root){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if(root == null) return;
        stack1.add(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.add(root);
            if(root.left != null) stack1.add(root.left);
            if(root.right != null) stack1.add(root.right);
        }

        // Now we will print the elements of the stack2 which stores the elements in the order same as post order traversal 
        while(!stack2.isEmpty()){
            Node temp = stack2.pop();
            System.out.print(temp.data + "-->");
        }
        System.out.println("");

    }

    public static void Post_Order_Iterative2(Node root){
            Node current = root;
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || current != null){
                if(current != null){
                    stack.add(current);
                    current = current.left;
                }
                else{
                    Node temp = stack.peek().right;
                    if(temp == null){
                        temp = stack.pop();
                        System.out.print(temp.data + "-->");
                        while(!stack.isEmpty() && temp == stack.peek().right){
                            temp = stack.pop();
                            System.out.print(temp.data + "-->");
                        }
                    }
                    else{
                        current = temp;
                    }
                }
            }
    }

    public static void main(String[] args) {

        Node root = null;
        Node treeRoot = Make_My_Tree(root);
        System.out.println("Traversing tree using recursive approach ");
        Post_Order_Recursive(treeRoot);
        System.out.println("");
        System.out.println("Traversing tree using iterative approach using 2 stacks ");
        Post_Order_Iterative1(treeRoot);
        
    }
}
