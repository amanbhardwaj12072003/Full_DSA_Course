import java.util.*;

class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    
    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public void put(char ch , Node node){
        links[ch - 'a'] = node;
    }

    public Node get(char ch){
        return links[ch - 'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
    
}

class Trie{
    private static Node root;

    Trie(){
        root = new Node();
    }

    public void Insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean checkIfAllPrefixExist(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                if(node.isEnd() == false){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
public class Trie_03_Longest_Word {

    public static String findLongest(List<String> list){
        Trie trie = new Trie();
        for(String s : list){
            trie.Insert(s);
        }
        String longest = "";
        for(String query : list){
            if(trie.checkIfAllPrefixExist(query)){
                if(query.length() > longest.length()){
                    longest = query;
                }else if(query.length() == longest.length() && query.compareTo(longest) < 0){
                    longest = query;
                }
            }
        }

        if(longest.equals("")) return "None";
        return longest;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("n");
        list.add("ninj");
        list.add("ni");
        list.add("ninja");
        list.add("ninga");
        list.add("nin");

        String longest_prefix_string = findLongest(list);
        System.out.println("The Longest String Whose All Prefixes Are Present Is : " + longest_prefix_string);
        
    }
}
