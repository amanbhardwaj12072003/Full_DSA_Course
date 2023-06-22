import java.util.*;
public class Graph_22_Allien_Dictionary {

    // Topological Sorting Algorithm 
    public static ArrayList<Integer> getTopoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] inOrder = new int[V];
        for(int node=0;node<V;node++){
            for(int adjNode : adj.get(node)){inOrder[adjNode]++;}
        }
        Queue<Integer> queue = new LinkedList();
        for(int node=0;node<V;node++){if(inOrder[node]==0){queue.offer(node);};}
        ArrayList<Integer> topoSort = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            topoSort.add(node);
            for(int adjNode : adj.get(node)){
                inOrder[adjNode]--;
                if(inOrder[adjNode]==0) {queue.offer(adjNode);}
            }
        }
        return topoSort;
    }

    public static ArrayList<ArrayList<Integer>> getAdj(String[] alienDict,int K){
        int N = alienDict.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int node=0;node<K;node++){adj.add(new ArrayList<>());}
        for(int i=0;i<N-1;i++){
            String word1 = alienDict[i], word2 = alienDict[i+1];
            int len = Math.min(word1.length(),word2.length());
            for(int j=0;j<len;j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    adj.get(word1.charAt(j)-'a').add(word2.charAt(j)-'a');
                    break;
                }
            }
        }
        return adj;
    }

    public static String getOrder(String[] alienDict,int K){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj = getAdj(alienDict, K);
        ArrayList<Integer> topoSort = new ArrayList<>();
        topoSort = getTopoSort(K, adj);
        // Collections.sort(topoSort); --> Chodu Panti 
        StringBuilder string = new StringBuilder();
        for(int ch=0;ch<K;ch++){string.append(topoSort.get(ch)-'a');}
        return string.toString();
    }

    public static void main(String[] args) {
        
    }
}
