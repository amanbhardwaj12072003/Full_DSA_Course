class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_31_Ceil_In_BST {
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
        // Node tenth = new Node(9);

        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        fourth.left = eight;
        fourth.right = ninth;
        // fifth.right = tenth;
        
        return root;
    }

    public static int Ceil(Node root , int key){
        int ceil = -1;
        while(root != null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            if(key > root.data){
                root = root.right;
            }
            else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        Node root = null;
        root = BST(root);
        int ceil = Ceil(root , 8);
        System.out.println("Ceil Value Of 8 : " + ceil);
    }
}
