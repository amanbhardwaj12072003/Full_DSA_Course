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
    int value;
    Pair(Node node , int value){
        this.node = node;
        this.value = value;
    }
}

public class Tree_05_Pre_In_Post_Order {

    public static Node Make_My_Tree(Node root){
        // Storing values in nodes of tree
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eight = new Node(8);
        Node ninth = new Node(9);

        // Giving refrence to each node of its left and right node
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

    // Now we will be traversing tree in all orders (PreOrder , InOrder , PostOrder) in one go using one stack 
    public static void Multiple_Traversal(Node root , List<Integer> PreOrder , List<Integer> InOrder , List<Integer> PostOrder){
        if(root == null) return;
        Stack<Pair> stack = new Stack<>(); 
        stack.add(new Pair(root, 1));

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            if(pair.value==1){
                PreOrder.add(pair.node.data);
                int temp = pair.value+1;
                pair = new Pair(pair.node,temp);
                stack.add(pair);

                if(pair.node.left != null){
                    stack.add(new Pair(pair.node.left , 1));
                }
            }
            else if(pair.value==2){
                InOrder.add(pair.node.data);
                int temp = pair.value+1;
                pair = new Pair(pair.node,temp);
                stack.add(pair);

                if(pair.node.right != null){
                    stack.add(new Pair(pair.node.right,1));
                }
            }
            else{
                PostOrder.add(pair.node.data);
            }
        }

    }


    public static void main(String[] args) {

        Node root = null;
        root = Make_My_Tree(root);
        List<Integer> PreOrder = new ArrayList<>();
        List<Integer> InOrder = new ArrayList<>();
        List<Integer> PostOrder = new ArrayList<>();
        Multiple_Traversal(root, PreOrder, InOrder, PostOrder);
        System.out.println("PreOrder : " + PreOrder);
        System.out.println("InOrder : " + InOrder);
        System.out.println("PostOrder : " + PostOrder);
        
    }
}
