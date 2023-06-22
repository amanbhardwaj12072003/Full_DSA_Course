import java.util.*;
class Graph{
    int V;
    ArrayList<ArrayList<Integer>> adj;
    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int u=0;u<V;u++) adj.add(new ArrayList<>());
    }
    void addNode(int u, int v){
        adj.get(u).add(v);
    }
}
public class Graph_08_Detect_Cycle_In_UDG_DFS {

    public static boolean dfs_detect(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[node] = 1;
        for(int adjNode : adj.get(node)){
            if(visited[adjNode]==0){
                if(dfs_detect(adjNode, node, adj, visited)) return true; 
            }
            else if(adjNode != parent) return true;
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(dfs_detect(i, -1, adj, visited)) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int V = 4;
        Graph graph = new Graph(V);
        graph.addNode(1, 2);
        graph.addNode(1, 3);
        graph.addNode(2, 1);
        graph.addNode(2, 3);
        graph.addNode(3, 1);
        graph.addNode(3, 2);
        graph.addNode(3, 4);
        System.out.println("Have Cycle : " +isCycle(V, graph.adj));
    }   
}
