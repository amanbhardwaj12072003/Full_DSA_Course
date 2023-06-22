import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_11_Spiral_traversal {

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

    // Level Order Traveral
    public static List<Integer> LevelOrder(Node root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            list.add(temp.data);
            if(temp.left != null) queue.offer(temp.left);
            if(temp.right != null) queue.offer(temp.right);
        }
        return list;
    }

    // Spiral Order Traveral (Zig-Zag Traversal)
    public static List<List<Integer>> Spiral(Node root){

        List<List<Integer>> list = new ArrayList<>();

        // Base Case 
        if(root == null) return list;

        // General Case
        boolean LeftToRight = true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> level = new ArrayList<>(levelNum);
            for(int i=0;i<levelNum;i++){
                Node temp = queue.poll();
                

                if(LeftToRight){
                    level.add(temp.data);
                }
                else{
                    level.add(0 , temp.data);
                }

                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
            list.add(level);
            LeftToRight = !LeftToRight;
        }
        return list;
    }

    public static void main(String[] args) {

        Node root = null;
        root = Make_My_Tree(root);

        // Level Order Traversal
        List<Integer> levelorder = new ArrayList<>();
        levelorder = LevelOrder(root);
        System.out.println("Level Order Traversal : " + levelorder);

        // Spiral Order Traversal 
        List<List<Integer>> spiralorder = new ArrayList<>();
        spiralorder = Spiral(root);
        System.out.println("Spiral Order : " + spiralorder);

    }
}
