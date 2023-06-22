import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}


public class Tree_19_Lowest_Common_Ancestor {

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

    // Recursive Optimised Algorithm 
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static Node LowestCommonAncestor(Node root , Node node1 , Node node2){
        if(root == null || root == node1 || root == node2) return root;

        Node leftCase = LowestCommonAncestor(root.left, node1, node2);
        Node rightCase = LowestCommonAncestor(root.right, node1, node2);

        if(leftCase == null) return rightCase;
        else if(rightCase == null) return leftCase;
        else return root;
    }


    // Brutforce Algorithm -> We will store the paths from root to both the nodes 
    // Time Complexity : O(n)
    // Space Complexity : 2*O(n)
    public static List<Integer> getPath(Node root , Node node){
        List<Integer> path = new ArrayList<>();
        if(root == null) return path;
        givePath(root , path , node);
        return path;
    }

    public static boolean givePath(Node root , List<Integer> list , Node node){
        if(root == null) return false;
        list.add(root.data);
        if(root.data == node.data) return true;
        if(givePath(root.left, list, node) || givePath(root.right, list, node)) return true;
        list.remove(list.size()-1);
        return false;
    }


    public static int LCA(Node root , Node node1 , Node node2){
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        path1 = getPath(root , node1);
        path2 = getPath(root , node2);
        int result = 0;
        int run = 0;
        while(run < Math.min(path1.size() , path2.size())){
            if(path1.get(run) != path2.get(run)) break;
            result = path1.get(run);
            run++;
        }
        return result;
    }


    public static void main(String[] args) {
        Node root = null;
        root = Make_My_Tree(root);
        Node lca1 = LowestCommonAncestor(root, new Node(8), new Node(5));
        System.out.println("The lowest common ancestor of 5 and 8 is : " + lca1);
        int lca2 = LCA(root, new Node(9), new Node(7));
        System.out.println("The lowest common ancestor of 9 and 7 is : " + lca2);
    }
}
