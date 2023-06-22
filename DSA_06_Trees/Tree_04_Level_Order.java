import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_04_Level_Order {
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

        // Giving reference of left and right to respective node 
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

    // Level Order traversal of tree 
    public static void Level_Order_Traversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + "-->");
            if(temp.left != null) queue.offer(temp.left);
            if(temp.right != null) queue.offer(temp.right);
        }
    }
    // This is bfs 


    public static void main(String[] args) {

        Node root = null;
        Node treeRoot = Make_My_Tree(root);
        System.out.println("Level Order Traversal Of Tree");
        Level_Order_Traversal(treeRoot);
        
    }
}
