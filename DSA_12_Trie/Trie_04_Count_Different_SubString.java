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

}

class Trie{
    private static Node root;
    Trie(){

    }

    public void Insert(String word){

    }
}

public class Trie_04_Count_Different_SubString {

    public static int count(String s){
    
        int count = 0 , n = s.length();
        Node root = new Node();
        for(int i=0;i<n;i++){
            Node node = root;
            for(int j=i;j<n;j++){
                if(!node.containsKey(s.charAt(j))){
                    count++;
                    node.put(s.charAt(j),new Node());
                }
                node = node.get(s.charAt(j));
            }
        }
        return count + 1;  // +1 for "" null string 
    }

    public static void main(String[] args) {
        String str = "abab";
        int count_distinct_substring = count(str);
        System.out.println("Total count of distinct substring of str : " + count_distinct_substring);
    }
}
