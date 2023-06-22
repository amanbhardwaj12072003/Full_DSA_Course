/*
Balanced Binary Tree Is A Tree Having The Property 
--> Math.abs(left_subtree_height - right_subtree-height) <= 1
*/ 
import java.util.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_06_Maximum_Depth {

    public static Node Make_My_Tree1(Node root){
        // Storing values in node 
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eight = new Node(8);
        Node ninth = new Node(9);

        // Giving reference to nodes of their left and right children node 
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

    public static Node Make_My_Tree2(Node root){
        // Storing values in node 
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eight = new Node(8);
        Node ninth = new Node(9);

        // Giving reference to nodes of their left and right children node 
        root = first;
        root.left = second;
        second.left = third;
        second.right = fourth;
        third.left = fifth;
        third.right = sixth;
        fifth.left = seventh;
        fifth.right = eight;
        seventh.left = ninth;
        return root;
    }

    // Iterative Level Order Algorithm To Find Maximum Depth 

    public static int Depth_Of_Tree_iterative(Node root){
        // Edge Case 
        if(root == null) return 0;

        // General Case 
        int Depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            // This for loop shows the completion of single level of the tree 
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
            Depth++;
        }
        return Depth;
    }

    // Another Iterative Solution For Finding Depth Of Tree
    public static int Depth_Of_Tree_iterative1(Node root){
        // Edge Case
        if(root == null) return 0;

        // General Case
        int Depth1 = 0;
        Queue<Node> queue1 = new LinkedList<>();
        queue1.add(root);
        queue1.add(null);
        while(!queue1.isEmpty()){
            Node temp = queue1.poll();

            if(temp == null) Depth1++;

            if(temp != null){
                if(temp.left != null) queue1.add(temp.left);
                if(temp.right != null) queue1.add(temp.right);
            }

            else if(!queue1.isEmpty()) queue1.add(null);
        }
        return Depth1;
    }

    // Recursive Algorithm To Find The Maximum Depth Of Given Tree
    public static int Depth_Of_Tree_Recursive(Node root){

        if(root == null) return 0;

        int left_depth = Depth_Of_Tree_Recursive(root.left);
        int right_depth = Depth_Of_Tree_Recursive(root.right);

        return 1+Math.max(left_depth , right_depth);
    }

    public static void main(String[] args) {

        Node root = null;
        root = Make_My_Tree1(root);
        int depth = Depth_Of_Tree_iterative(root);
        int depth1 = Depth_Of_Tree_Recursive(root);
        int depth2 = Depth_Of_Tree_iterative1(root);
        Node root_ = null;
        root_ = Make_My_Tree2(root_);
        int depth_ = Depth_Of_Tree_iterative(root_);
        int depth_1 = Depth_Of_Tree_Recursive(root_);
        int depth_2 = Depth_Of_Tree_iterative1(root_);
        System.out.println("The depth of the tree1 using iterative approach is : " + depth);
        System.out.println("The depth of the tree1 using recursive approach is : " + depth1);
        System.out.println("The depth of the tree1 using iterative1 approach is : " + depth2);
        System.out.println("The depth of the tree2 using iterative approach is : " + depth_);
        System.out.println("The depth of the tree2 using recursive approach is : " + depth_1);
        System.out.println("The depth of the tree2 using recursive1 approach is : " + depth_2);
        
    }
}
