import java.util.*;
class Node{
    Node[] links = new Node[2];

    public boolean containsKey(int bit){
        return links[bit] != null;
    }

    public void put(int bit , Node node){
        links[bit] = node;
    }

    public Node get(int bit){
        return links[bit];
    }
}

class Trie{
    private static Node root;
    Trie(){
        root = new Node();
    }

    // Algorithm to insert a number in the trie 
    public void Insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit  = ((num >> i) & 1);
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }

    // Algorithm to get maximum possible xor 
    public int getMax(int num){
        Node node = root;
        int maxXor = 0;
        for(int i=31;i>=0;i--){
            int bit = ((num >> i) & 1);
            if(node.containsKey(1-bit)){
                maxXor |= (1 << i);
                node = node.get(1-bit);
            }
            node = node.get(bit);
        }
        return maxXor;
    }
}

public class Trie_05_Max_XOR_2_Arrays {
    public static int max_xor_2_Arrays(List<Integer> list1 , List<Integer> list2){
        Trie trie = new Trie();
        for(int i : list1) trie.Insert(i);
        int max_xor = 0;
        for(int j : list2){
            max_xor = Math.max(max_xor,trie.getMax(j));
        }
        return max_xor;
    }

    public static void main(String[] args) {
        
    }
}
