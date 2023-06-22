class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_30_Intro_To_BST {

    public static Node BST(Node root){
        Node first = new Node(8);
        Node second = new Node(5);
        Node third = new Node(12);
        Node fourth = new Node(4);
        Node fifth = new Node(7);
        Node sixth = new Node(10);
        Node seventh = new Node(14);
        Node eight = new Node(6);
        Node ninth = new Node(13);

        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        fifth.left = eight;
        seventh.left = ninth;

        return root;
    }

    public static Node Search_BST(Node root , int query){
        while(root != null && query != root.data){
            root = (root.data < query) ? root.right : root.left;
        }
        return root;
    }
    // Time Complexity : O(log(n))
    // Space Complexity : O(log(n)) --> Recursion Stack Height

    public static void main(String[] args) {
        Node root = null;
        root = BST(root);
        System.out.println(Search_BST(root, 15).data);
    }
}
