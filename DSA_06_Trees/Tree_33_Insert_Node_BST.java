import java.util.Currency;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_33_Insert_Node_BST {
    public static Node BST(Node root){
        Node first = new Node(4);
        Node second = new Node(2);
        Node third = new Node(7);
        Node fourth = new Node(1);
        Node fifth = new Node(3);
        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;

        return root;
    }

    public static Node Insert(Node root , int key){
        if(root == null) return new Node(key);
        Node current = root;
        while(true){
            if(current.data <= key){
                if(current.right != null) current = current.right;
                else{
                    current.right = new Node(key);
                    break;
                }
            }
            else{
                if(current.left != null) current = current.left;
                else{
                    current.left = new Node(key);
                    break;
                }
            }
        }
        return root;
    }

    // Recursive Solution 
    public static Node Insert_(Node root , int key){
        // Base Case
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.data) root.left = Insert_(root.left,key);
        if(key > root.data) root.right = Insert_(root.right,key);
        return root;
    }

    public static void main(String[] args) {
        
    }
}
