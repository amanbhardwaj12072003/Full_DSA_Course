class NodeValue{
    public int maxNode , minNode , maxSize;
    NodeValue(int minNode,int maxNode,int maxSize){
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Tree_43_Larget_BST {

    public static int largestBSTSubTree(Node root){
        return largestBSTSubTree__Helper(root).maxSize;
    }

    public static NodeValue largestBSTSubTree__Helper(Node root){
        // An Empty Tree Is A BST Of Size 0
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        NodeValue left = largestBSTSubTree__Helper(root.left);
        NodeValue right = largestBSTSubTree__Helper(root.right);

        if(left.maxNode<root.data && root.data<right.minNode){
            return new NodeValue(Math.min(root.data,left.minNode),Math.max(root.data,right.maxNode),left.maxSize+right.maxSize+1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize,right.maxSize));

    }

    public static void main(String[] args) {
        
    }
}
