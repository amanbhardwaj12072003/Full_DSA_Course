public class Tree_42_Recover_BST {
    public static Node prev;
    public static Node first;
    public static Node middle;
    public static Node last;

    public static void InOrder(Node root){
        if(root == null) return;
        InOrder(root.left);
        if(prev != null && root.data < prev.data){
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        }
        prev = root;
        InOrder(root.right);
    }

    public static void recoverTree(Node root){
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        InOrder(root);
        if(first != null && last != null){
            int t = first.data;
            first.data = last.data;
            last.data  = t;
        }
        else if(first != null && middle != null){
            int t = first.data;
            first.data = middle.data;
            middle.data = t;
        }
    }

    public static void main(String[] args) {

    }
}
