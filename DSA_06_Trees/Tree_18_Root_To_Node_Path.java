import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_18_Root_To_Node_Path {

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

    public static List<Integer> givePath(Node root , int value){
        List<Integer> store = new ArrayList<>();
        if((root == null)) return store;
        getPath(root, store, value);
        return store;
    }

    public static boolean getPath(Node root , List<Integer> path , int value){

        // Base Case
        if(root == null) return false;
        path.add(root.data);
        if(root.data == value) return true;
        if(getPath(root.left, path, value) || getPath(root.right, path, value)) return true;
        path.remove(path.size()-1);
        return false;
    }


    public static void main(String[] args) {

        Node root = null;
        root = Make_My_Tree(root);
        List<Integer> myPath = new ArrayList<>();
        myPath = givePath(root, 9);
        System.out.println("Path from root to node 9 : " + myPath);
        myPath = givePath(root, 12);
        System.out.println("Path from root to node 12 : " + myPath);

    }
}
