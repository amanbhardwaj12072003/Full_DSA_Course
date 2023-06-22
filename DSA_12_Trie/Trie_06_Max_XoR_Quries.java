 import java.util.*;
 class Node{
    Node[] links = new Node[2];

    Node(){

    }

    public boolean containsKey(int bit){
        return links[bit] != null;
    }

    public Node get(int bit){
        return links[bit];
    }

    public void put(int bit , Node node){
        links[bit] = node;
    }

}

class Trie{
    private static Node root;

    Trie(){
        root = new Node();
    }

    public void Insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = ((num >> i) & 1);
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num){
        Node node = root;
        int max_xor = 0;
        for(int i=31;i>=0;i--){
            int bit = ((num >> i)&1);
            if(node.containsKey(1-bit)){
                max_xor |= (1 << i);
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        return max_xor;
    }
}

public class Trie_06_Max_XoR_Quries {

    public static List<Integer> getMaxQuery(List<Integer> arr , List<List<Integer>> query){

        // Sorting the array storing the values 
        Collections.sort(arr);

        // Creating new list which stores ai on index 0 and index in queries at 2
        List<List<Integer>> offlineQueries = new ArrayList<>();
        int m = query.size();
        for(int i=0;i<m;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(query.get(i).get(1));
            temp.add(query.get(i).get(0));
            temp.add(i);
            offlineQueries.add(temp);
        }
        // Sorting offlineQueries
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>> () {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });

        int ind = 0;
        int n = arr.size(); 
        Trie trie = new Trie(); 
        ArrayList<Integer> ans = new ArrayList<Integer>(m); 
        for(int i = 0;i<m;i++) ans.add(-1); 
        for(int i = 0;i<m;i++) {
            while(ind<n && arr.get(ind) <= offlineQueries.get(i).get(0)) {
                trie.Insert(arr.get(ind)); 
                ind++; 
            }
            int queryInd = offlineQueries.get(i).get(2); 
            if(ind!=0) ans.set(queryInd, trie.getMax(offlineQueries.get(i).get(1)));
            else ans.set(queryInd, -1); 
        }
        return ans; 
        
    }

    public static void main(String[] args) {
        
    }
}
