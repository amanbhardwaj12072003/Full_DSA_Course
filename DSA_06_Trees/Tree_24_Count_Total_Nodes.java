import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_24_Count_Total_Nodes {

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
        Node tenth = new Node(9);
        Node eleventh = new Node(10);

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

        return root;
    }   

    // Method 1 (dfs)
    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public static int dfs(Node root){
        int count = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            count++;
            if(temp.left != null) stack.add(temp.left);
            if(temp.right != null) stack.add(temp.right);
        }
        return count;
    }

    // Method 2 (bfs)
    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public static int bfs(Node root){
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int level_size = queue.size();
            for(int i=0;i<level_size;i++){
                Node demo = queue.poll();
                count++;
                if(demo.left != null) queue.offer(demo.left);
                if(demo.right != null) queue.offer(demo.right);
            }
        }
        return count;
    }

    // Method 3 (using property of complete binary tree)
    // Time Complexity : O((log(n))^2)
    // Space Complexity : O(log(n))
    
    public static int count(Node root){

        if(root == null) return 0;
        int left_depth = getLeftDepth(root.left);
        int right_depth = getRightDepth(root.right);

        if(left_depth == right_depth) return ((1<<left_depth+1) - 1);
        else return 1 + count(root.left) + count(root.right);
    }
    
    public static int getLeftDepth(Node root){
        int count = 0;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }

    public static int getRightDepth(Node root){
        int count = 0;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }


    public static void main(String[] args) {
        
        Node root = null;
        root = Make_My_Tree(root);
        int dfs_count = dfs(root);
        System.out.println("Count Nodes Using dfs : " + dfs_count );
        int bfs_count = bfs(root);
        System.out.println("Count Nodes Using bfs : " + bfs_count);
        int count_nodes = count(root);
        System.out.println("Count Nodes Using Property Of Complete Binary Tree : " + count_nodes);

    }
}
