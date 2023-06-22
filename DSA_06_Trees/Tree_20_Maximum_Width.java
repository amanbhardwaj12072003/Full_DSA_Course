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
    int num;
    Pair(Node node , int num){
        this.node = node;
        this.num = num;
    }
}


public class Tree_20_Maximum_Width {

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

    // Algorithm To Find Maximum Width Of Tree

    public static int Width(Node root){

        // Base Case
        if(root == null) return 0;

        // General Case
        int width = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            Pair temp = queue.peek();
            int level_min = temp.num;
            int first = 0 , last = 0;
            for(int i=0;i<size;i++){
                int level_current = queue.peek().num - level_min;
                Node node = queue.peek().node;
                queue.poll();
                if(i == 0) first = level_current;
                if(i == size-1) last = level_current;
                if(node.left != null) queue.offer(new Pair(node.left, 2*level_current+1));
                if(node.right != null) queue.offer(new Pair(node.right, 2*level_current+2)); 
            }
            width = Math.max(width,(last-first+1));
        }
        return width;
    }
    public static void main(String[] args) {

        Node root = null;
        root = Make_My_Tree(root);
        int width_of_tree = Width(root);
        System.out.println("Width Of The Given Tree Is : " + width_of_tree);

    }
}
