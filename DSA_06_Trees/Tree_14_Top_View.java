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

public class Tree_14_Top_View {

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

    // My Algorithm To Top View Of A Binary Tree

    public static List<Integer> TopView(Node root){
        List<Integer> list = new ArrayList<>();

        // Base Case
        if(root == null) return list;

        // General Case
        // Step 1 : store left boundary nodes of the tree
        // Step 2 : add node to the list 
        // Step 3 : store right boundary nodes of the tree 

        Node left = root.left , right = root.right;

        // Storing left boundary nodes
        List<Integer> leftlist = new ArrayList<>();
        Stack<Node> leftstack = new Stack<>();
        leftstack.push(left);
        while(!leftstack.isEmpty()){
            Node lefttemp = leftstack.pop();
            leftlist.add(lefttemp.data);

            if(lefttemp.left != null) leftstack.push(lefttemp.left);
        }

        // Storing right boundary nodes
        List<Integer> rightlist = new ArrayList<>();
        Stack<Node> rightstack = new Stack<>();
        rightstack.push(right);
        while(!rightstack.isEmpty()){
            Node righttemp = rightstack.pop();
            rightlist.add(righttemp.data);
            
            if(righttemp.right != null) rightstack.push(righttemp.right);
        }

        for(int i=leftlist.size()-1;i>=0;i--) list.add(leftlist.get(i));
        list.add(root.data);
        for(int j=0;j<rightlist.size();j++) list.add(rightlist.get(j));

        return list;

    }

    // Stiver's Algorithm
    public static List<Integer> topView(Node root){
        List<Integer> list = new ArrayList<>();
        
        // Base Case 
        if(root == null) return list;

        // General Case
        Map<Integer,Integer> map = new HashMap<>(); // Map<Vertical , Node value>
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            Node node = temp.node;
            int vertical = temp.vertical;

            if(map.get(vertical) == null) map.put(vertical , node.data);
            
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
        List<Integer> TopView = new ArrayList<>();
        TopView = TopView(root);
        System.out.println("Top View Of The Binary Tree (Aman Algorithm) : " + TopView);
        List<Integer> topView = new ArrayList<>();
        topView = topView(root);
        System.out.println("Top View Of Binary Tree (Striver's Algorithm) : " + topView);
    }
}
