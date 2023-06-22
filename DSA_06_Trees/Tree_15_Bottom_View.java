import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class Pair{
    Node node;
    int vertical;
    Pair(Node node , int vertical){
        this.node = node;
        this.vertical = vertical;
    }
}

public class Tree_15_Bottom_View {

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

    public static List<Integer> BottomView(Node root){
        List<Integer> list = new ArrayList<>();

        // Base Case
        if(root == null) return list;

        // General Case
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            Node node = temp.node;
            int vertical = temp.vertical;

            map.put(vertical, node.data); // Updating value corresponding to a vertical level

            if(node.left != null) queue.offer(new Pair(node.left, vertical-1));

            if(node.right != null) queue.offer(new Pair(node.right, vertical+1));
        }

        // Sorting Of Map With Respect To Vertical Value
        PriorityQueue<Map.Entry<Integer,Integer>> count = new PriorityQueue<>((a,b) -> a.getKey()-b.getKey());
        for(Map.Entry<Integer,Integer> e : map.entrySet()) count.add(e);
        // for(Map.Entry<Integer,Integer> e : map.entrySet()) list.add(e.getValue());
        while(!count.isEmpty()){
            int value = count.poll().getValue();
            list.add(value);
        }
        
        return list;
    }

    public static void main(String[] args) {
        
        Node root = null;
        root = Make_My_Tree(root);
        List<Integer> bottomView = new ArrayList<>();
        bottomView = BottomView(root);
        System.out.println("The Bottom View Of Tree : " + bottomView);
    }
}
