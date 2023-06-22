class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_07_Check_For_Balanced_Binary_tree {

    public static Node Make_My_Tree1(Node root){
        // Storing Values In Nodes 
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        // Giving Reference To Each Node Of It's Respective Left And Right Node 
        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        fourth.left = sixth;
        fourth.right = seventh;
        return root;
    }

    public static Node Make_My_Tree2(Node root){
        // Storing Values In Nodes 
        Node first = new Node(3);
        Node second = new Node(9);
        Node third = new Node(20);
        Node fourth = new Node(15);
        Node fifth = new Node(7);

        // Giving Reference To Each Node Of It's left And Right Nodes 
        root = first;
        root.left = second;
        root.right = third;
        third.left = fourth;
        third.right = fifth;

        return root;
    }

    // Method To Find Height Of Tree
    public static int Height(Node root){
        if(root == null) return 0;

        int left_height = Height(root.left);
        int right_height = Height(root.right);

        return 1 + Math.max(left_height, right_height);
    }

    // Method To Check For Balanced Tree 
    public static boolean Check(Node root){
        if(root == null) return true;

        int left_height = Height(root.left);
        int right_height = Height(root.right);

        if(Math.abs(right_height-left_height) > 1) return false;

        boolean check_left = Check(root.left);
        boolean check_right = Check(root.right);

        if(!(check_left || check_right)) return false;

        return true;
    }

    // Time Complexity : o(n^2)

    // Optimized Method To Check For Balanced Tree --> This method return -1 if the tree is not balanced
    //  and if it is a balanced binary tree then it will return height of the tree 
    public static int Height_(Node root){
        if(root == null) return 0;

        int left_height = Height(root.left);
        int right_height = Height(root.right);

        // Condition To Identify Abnormal Behaviour 
        if(left_height == -1 || right_height == -1) return -1;

        // Condition For Balanced Binary Tree
        if(Math.abs(left_height-right_height)>1) return -1;

        return 1 + Math.max(left_height, right_height);
    }
    // Time Complexity : O(n)

    public static void main(String[] args) {

        Node root = null;
        Node root_ = null;
        root = Make_My_Tree1(root);
        root_ = Make_My_Tree2(root_);
        boolean tree1_is_balanced = Check(root);
        boolean tree2_is_balanced = Check(root_);
        boolean tree1_is_balanced_ = (Height_(root) == -1) ? false : true;
        boolean tree2_is_balanced_ = (Height(root_) == -1) ? false : true;

        System.out.println("Checking Tree 1 In O(n^2) : " + tree1_is_balanced);
        System.out.println("Checking Tree 2 In O(n^2) : " + tree2_is_balanced);
        System.out.println("Checking Tree 1 In O(n) : " + tree1_is_balanced_);
        System.out.println("Checking Tree 2 In O(n) : " + tree2_is_balanced_);

    }
}
