import java.util.*;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_12_Boundary_Traversal {

    public static Node MakeMyTree(Node root){
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

        // Giving reference
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

    // My Algorithm

    public static List<Integer> DFS(Node root){
        List<Integer> list = new ArrayList<>();
        
        // Base Cases
        if(root == null) return list;
        if(root.left == null && root.right == null){
            list.add(root.data);
            return list;
        }

        Node left = root.left;
        Node right = root.right;
        list.add(root.data);

        // Storing left nodes 
        Stack<Node> leftstack = new Stack<>();
        leftstack.push(left);
        while(!leftstack.isEmpty()){
            Node lefttemp = leftstack.pop();
            if(lefttemp.left == null && lefttemp.right == null) continue;
            list.add(lefttemp.data);
            if(lefttemp.right != null) leftstack.push(lefttemp.right);
            if(lefttemp.left != null) leftstack.push(lefttemp.left);

        }

        // Storing Leaf Nodes 
        Stack<Node> leafstack = new Stack<>();
        leafstack.add(root);
        while(!leafstack.isEmpty()){
            Node leaftemp = leafstack.pop();
            if(leaftemp.left == null && leaftemp.right == null) list.add(leaftemp.data);
            if(leaftemp.right != null) leafstack.push(leaftemp.right);
            if(leaftemp.left != null) leafstack.push(leaftemp.left); 
        }

        // Storing right nodes (bottom to top)
        List<Integer> temp = new ArrayList<>();
        Stack<Node> rightstack = new Stack<>();
        rightstack.push(right);
        while(!rightstack.isEmpty()){
            Node righttemp = rightstack.pop();
            if(righttemp.left == null && righttemp.right == null) continue;
            temp.add(righttemp.data);
            if(righttemp.right != null) rightstack.push(righttemp.right);
            if(righttemp.left != null) rightstack.push(righttemp.left);
        }
        for(int i=temp.size()-1;i>=0;i++) list.add(temp.get(i));

        return list;
    }


    // Striver's Algorithm

    // Anticlock Wise Traversal
    // Step 1 : Store Left Nodes Except Leafs (Top To Bottom)
    // Step 2 : Store Leaf Nodes (Left To Right)
    // Step 3 : Store (Bottom To Top)

    public static void AddLeftNode(Node root , List<Integer> list){

        Node leftTemp = root.left;
        while(leftTemp != null){
            if(!(leftTemp.left == null && leftTemp.right == null)) list.add(leftTemp.data);
            if(leftTemp.left != null) leftTemp = leftTemp.left;
            else leftTemp = leftTemp.right;
        }

    }

    public static void AddLeafNode(Node root , List<Integer> list){

        if(root.left == null && root.right == null){
            list.add(root.data);
            return;
        }
        if(root.left != null) AddLeafNode(root.left, list);
        if(root.right != null) AddLeafNode(root.right, list);
 
    }

    public static void AddRightNode(Node root , List<Integer> list){

        List<Integer> temp = new ArrayList<>();
        Node rightTemp = root.right;
        while(rightTemp != null){
            if(!(rightTemp.left == null && rightTemp.right == null)) temp.add(rightTemp.data);
            if(rightTemp.right != null) rightTemp = rightTemp.right;
            else rightTemp = rightTemp.left;
        }
        for(int i=temp.size()-1;i>=0;i--) list.add(temp.get(i));
    }

    public static void main(String[] args) {
        
        Node root = null;
        root = MakeMyTree(root);

        // Striver's Algorithm

        List<Integer> boundary = new ArrayList<>();
        if(!(root.left == null && root.right == null)) boundary.add(root.data);
        AddLeftNode(root , boundary);
        AddLeafNode(root , boundary);
        AddRightNode(root , boundary);
        System.out.println("Boundary Order Traversal (Striver's Algorithm) : " + boundary);

        // My Algorithm
        List<Integer> boundary_ = new ArrayList<>();
        boundary_ = DFS(root);
        System.out.println("Boundary Order Traversal (My Algorithm) : " + boundary_);
    }
}
