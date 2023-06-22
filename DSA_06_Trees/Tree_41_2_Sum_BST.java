import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class BST_Iterator{
    private static Stack<Node> stack = new Stack<>();
    private static boolean reverse = true;

    public BST_Iterator(Node root , boolean isReverse){
        reverse = isReverse;
        PushAll(root);
    }

    public boolean hasNext(Node root){
        return !stack.isEmpty();
    }

    public int next(){
        Node temp = stack.pop();
        if(reverse) PushAll(temp.left);
        else PushAll(temp.right);
        return temp.data;
    } 

    public void PushAll(Node node){
        while(node != null){
            stack.push(node);
            if(reverse) node = node.right;
            else node = node.left;
        }
    }

}

public class Tree_41_2_Sum_BST {
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

    public static boolean Two_Sum(Node root , int target){
        if(root == null) return false;
        BST_Iterator left = new BST_Iterator(root, false);
        BST_Iterator right = new BST_Iterator(root, true);


        int i = left.next() , j = right.next();
        while(i < j){
            if((i+j) == target) return true;
            else if((i+j) < target) i = left.next();
            else j = right.next();
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
