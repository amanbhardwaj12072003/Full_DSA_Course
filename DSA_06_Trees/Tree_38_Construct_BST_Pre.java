class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Tree_38_Construct_BST_Pre {

    public static Node BST_From_PreOrder(int[] Arr){
        return BST_From_PreOrder(Arr , Integer.MAX_VALUE , new int[]{0});
    }

    public static Node BST_From_PreOrder(int[] Arr , int bound , int[] pointer){
        // Base Case
        if(pointer[0] == Arr.length || Arr[pointer[0]] > bound) return null;

        // General Case
        Node root = new Node(Arr[pointer[0]++]);
        root.left = BST_From_PreOrder(Arr, root.data, pointer);
        root.right = BST_From_PreOrder(Arr, bound, pointer);
        return root;
    }

    public static boolean check(Node root , int min_bound , int max_bound){
        if(root == null) return true;
        if(root.data > max_bound || root.data < min_bound) return false;
        return check(root.left , min_bound , root.data) && check(root.right , root.data , max_bound);
    }


    public static void main(String[] args) {
        
        int[] preOrder = new int[]{8,5,1,7,10,12};
        Node root = BST_From_PreOrder(preOrder);
        System.out.println("Is The Tree A BST : " + check(root , Integer.MIN_VALUE , Integer.MAX_VALUE));
        
    }
}
                                                        