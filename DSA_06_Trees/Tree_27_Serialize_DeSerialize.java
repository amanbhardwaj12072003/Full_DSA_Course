import java.util.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_27_Serialize_DeSerialize {

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
        Node tenth = new Node(10);
        Node eleventh = new Node(11 );
        Node twelth = new Node(12);
        Node thirteenth = new Node(13);

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
        fifth.left = tenth;
        fifth.right = eleventh;
        eleventh.left = twelth;
        eleventh.right = thirteenth;

        return root;
    }

    public static String Serialize(Node root){
        // Base Case
        if(root == null) return "";

        // General Case
        Queue<Node> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp == null){
                str.append("n ");
                continue;                 // To prevent the case of null pointer exception
            }
            str.append(temp.data + " ");
            // Offering instead of null or not null as this time we want to store the null node too !!
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return str.toString();
    }

    public static Node DeSerialize(String data){
        // Base Case 
        if(data == "") return null;

        // General Case
        Queue<Node> queue = new LinkedList<>();
        String[] values = data.split(" ");
        Node root = new Node(Integer.valueOf(values[0]));
        queue.offer(root);
        for(int i=1;i<values.length;i++){
            Node parent = queue.poll();
            
            if(!values[i].equals("n")){
                Node left = new Node(Integer.valueOf(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            if(!values[++i].equals("n")){
                Node right = new Node(Integer.valueOf(values[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    // Level Order
    public static void print(Node root){
        if(root == null) System.out.println("");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data +  " ");
            if(temp.left != null) queue.offer(temp.left);
            if(temp.right != null)  queue.offer(temp.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = Make_My_Tree(root);
        String serialized_tree = Serialize(root);
        System.out.println("Serialized Binary Tree : " + serialized_tree);
        Node root_ = DeSerialize(serialized_tree);
        print (root_);
    }
}
