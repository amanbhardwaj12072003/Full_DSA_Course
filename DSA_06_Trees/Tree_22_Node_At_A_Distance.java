import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_22_Node_At_A_Distance {

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

    // Funtion to store the parent of every node in the tree
    public static void mark_parent(Node root , Map<Node , Node> track_parent , Node target){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.left != null){
                track_parent.put(current.left , current);
                queue.offer(current.left);
            }
            if(current.right != null){
                track_parent.put(current.right , current);
                queue.offer(current.right);
            }
        }
    }

    public static List<Integer> fun(Node root , Node target , int k){

        Map<Node,Node> track_parent = new HashMap<>();
        mark_parent(root , track_parent , target);

        Map<Node,Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target,true);
        int current_distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(current_distance == k) break;
            current_distance++;
            for(int i=0;i<size;i++){
                Node current = queue.poll();

                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left,true);
                }

                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right,true);
                }

                if(track_parent.get(current) != null && visited.get(track_parent.get(current)) == null){
                    queue.offer(track_parent.get(current));
                    visited.put(track_parent.get(current),true);
                }
            }
        }

        List<Integer> nodes_at_distance_k = new ArrayList<>();
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            nodes_at_distance_k.add(temp.data);
        }
        return nodes_at_distance_k;
    }


    public static void main(String[] args) {
        Node root = null;
        root = Make_My_Tree(root);
        List<Integer> ans = new ArrayList<>();
        ans = fun(root , new Node(5) , 2);
        System.out.println("The Nodes At A Distance Of 2 From The Node target Is : " + ans);
    }
}
