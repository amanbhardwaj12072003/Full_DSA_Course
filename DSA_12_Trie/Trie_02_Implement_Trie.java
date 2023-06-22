class Node{
    Node[] links =  new Node[26];
    int countEndsWith = 0;
    int countPrefix = 0;

    public Node(){

    }

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

    void put(char ch , Node node){
        links[ch] = node;
    }
    
    void increaseEnd(){
        countEndsWith++;
    }

    void increasePrefix(){
        countPrefix++;
    }

    void deleteEnd(){
        countEndsWith--;
    }

    void reducePrefix(){
        countPrefix--;
    }

    int getEnd(){
        return countEndsWith;
    }
    
    int getPrefix(){
        return countPrefix;
    }
}

public class Trie_02_Implement_Trie {

    private static Node root;

    Trie_02_Implement_Trie(){
        root = new Node();
    }

    public void Insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartsWith(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void Erase(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }else{
                return;
            }
        }
        node.deleteEnd();;
    }


    public static void main(String[] args) {
        
    }
}
