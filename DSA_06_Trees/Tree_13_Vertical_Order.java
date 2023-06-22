import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class Tuple{
    Node node;
    int vertical , level;
    Tuple(Node node , int vertical , int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

public class Tree_13_Vertical_Order {

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

    public static List<List<Integer>> verticalTraversal(Node root){
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        while(!queue.isEmpty()){
            Tuple temp = queue.poll();
            Node node_ = temp.node;
            int vertical_ = temp.vertical;
            int level_ = temp.level;
            if(!map.containsKey(vertical_)){
                map.put(vertical_, new TreeMap<>());
            }

            if(!map.get(vertical_).containsKey(level_)){
                map.get(vertical_).put(level_, new PriorityQueue<>());
            }

            map.get(vertical_).get(level_).offer(node_.data);

            if(node_.left != null) queue.offer(new Tuple(node_.left, vertical_ - 1, level_ + 1));
            if(node_.right != null) queue.offer(new Tuple(node_.right, vertical_ + 1, level_ + 1));
        }
        List<List<Integer>> verticalPath = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> vp : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : vp.values()){
                while(!nodes.isEmpty()) list.add(nodes.poll());
            }
            verticalPath.add(list);
        }

        return verticalPath;
    }


    public static void main(String[] args) {

        Node root = null;
        root = Make_My_Tree(root);
        List<List<Integer>> verticalOrder = new ArrayList<>();
        verticalOrder = verticalTraversal(root);
        System.out.println("Vertical Traversal : " + verticalOrder);
        
    }
}
