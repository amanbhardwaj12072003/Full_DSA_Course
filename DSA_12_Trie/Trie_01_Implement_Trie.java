class Node{

    Node links[] = new Node[26];
    boolean flag = false;

    public Node(){

    }

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

    void put(char ch , Node node){
        links[ch - 'a'] = node;
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }

}

public class Trie_01_Implement_Trie {

    private static Node root;

    // Initiating a root for the Trie 
    Trie_01_Implement_Trie(){
        root = new Node();
    }

    // Algorithm to insert the data to the Trie 
    public static void Insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            // Moves to the reference trie
            node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public static boolean Search(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    public static boolean startsWith(String prefix){
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node  = node.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
