import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_21_Children_Sum {


    public static Node Make_My_Tree(Node root){
        // Storing values in nodes
        Node first = new Node(40);
        Node second = new Node(10);
        Node third = new Node(20);
        Node fourth = new Node(2);
        Node fifth = new Node(5);
        Node sixth = new Node(30);
        Node seventh = new Node(40);

        // Giving reference to left and right nodes 
        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;

        return root;
    }

    public static void BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+"->");
            if(temp.left != null) queue.offer(temp.left);
            if(temp.right != null) queue.offer(temp.right);
        }
        System.out.println("null");
    }

    public static void Child_Sum_Property(Node root){
        if(root == null) return;

        // While Going Down The Tree
        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child += root.right.data;

        if(child >= root.data) root.data = child;
        else{
            if(root.left != null) root.left.data = root.data;
            if(root.right != null) root.right.data = root.data;
        }

        Child_Sum_Property(root.left);
        Child_Sum_Property(root.right);

        // While Going Up The Tree

        int child_sum = 0;
        if(root.left != null) child_sum += root.left.data;
        if(root.right != null) child_sum += root.right.data;
        if(root.left != null || root.right != null) root.data = child_sum; // That What Our Motive Was

    }
    

    public static void main(String[] args) {
        
        Node root = null;
        root = Make_My_Tree(root);
        System.out.println("Initial Tree");
        BFS(root);
        Child_Sum_Property(root);
        System.out.println("Final Tree");
        BFS(root);


    }
}
