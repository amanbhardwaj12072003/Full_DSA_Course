import java.util.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_35_Kth_Smallest_In_BST {

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

    // We must note the fact that InOrder Traversal of a BST is always sorted in ascending order...
    // Algorithm to find the Kth smallest element 
    public static Node find(Node root , int k){
        // Edge Case
        if(root == null) return null;

        // General Case
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        int count = 0;
        while(true){
            if(temp != null){
                stack.add(temp);
                temp = temp.left;
            }
            else{
                if(stack.isEmpty()) break;
                count++;
                Node dummy = stack.pop();
                if(count == k) return dummy;
                temp = dummy.right;
            }
        }
        return null;
    }
    
    // Algorithm to find the Kth Largest element 
    public static Node find_(Node root , int k){
        if(root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        int target = (Count(root)-k+1) , count = 0;
        while(true){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else{
                if(stack.isEmpty()) break;
                Node dummy = stack.pop();
                count++;
                if(count == target) return dummy;
                temp = dummy.right;
            }
        }
        return null;
    }


    // Algorithm to count the total nodes in the given BST
    public static int Count(Node root){
        if(root == null) return 0;
        int count = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            count++;
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        return count;
    }

    public static void main(String[] args) {
        Node root = null;
        root = BST(root);
        Node Kth_Smallest = find(root , 4);
        Node Kth_Largest = find_(root , 4);
        System.out.println("4th Smallest Node : " + Kth_Smallest.data);
        System.out.println("4th Largest Node : " + Kth_Largest.data);
    }
}
