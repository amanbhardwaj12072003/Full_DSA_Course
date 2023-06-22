class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_34_Delete_Node_In_BST {

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

    // Algorithm to delete node from the tree
    public static Node deleteNode(Node root , int key){
        if(root == null) return null;
        if(root.data == key) return helper(root);

        Node dummy = root;
        while(root != null){
            if(root.data > key){
                if(root.left != null && root.left.data == key){
                    root.left = helper(root.left);
                    break;
                }
                else root = root.left;
            }
            else{
                if(root.right != null && root.right.data == key){
                    root.right = helper(root.right);
                    break;
                }
                else root = root.right;
            }
        }
        return dummy;
    }

    // Algorithm to adjust the structure after deletion of the node 
    public static Node helper(Node root){
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        else{
            Node right_child = root.right;
            Node right_last_of_left = findLastRight(root.left);
            right_last_of_left.right = right_child;
            return root.left;
        }
    }

    // Algorithm to find right most node of the left subtree
    public static Node findLastRight(Node root){
        if(root.right == null) return root;
        return findLastRight(root.right);
    }

    public static 

    public static void main(String[] args) {
        
    }
}
