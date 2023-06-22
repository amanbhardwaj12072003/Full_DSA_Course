import java.util.*;
public class Graph_18_Kahns_Algorithm {

    // Kahn's algorithm is nothing but Topological Sort using BFS
    public static ArrayList<Integer> topologicalSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];
        for(int u=0;u<V;u++){
            for(int node : adj.get(u)){
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            topoSort.add(node);
            for(int adjNode : adj.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0){queue.offer(adjNode);}
            }
        }
        return topoSort;
    }

    public static void main(String[] args) {
        
        
    }
}
