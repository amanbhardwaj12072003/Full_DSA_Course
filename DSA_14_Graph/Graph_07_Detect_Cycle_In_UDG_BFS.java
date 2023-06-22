import java.util.*;
class Graph{
    int V;
    ArrayList<ArrayList<Integer>> adj;
    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int u=0;u<V;u++) adj.add(new ArrayList<>());
    }
    void addEdge(int u, int v){
        adj.get(u).add(v);
    }
}
class Pair{
    int node, parent;
    Pair(int node,int parent){
        this.node = node;
        this.parent = parent;
    }
}
public class Graph_07_Detect_Cycle_In_UDG_BFS {
    // Detect Algorithm 
    public static boolean bfs_detect(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[source] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(source,-1));
        while(!queue.isEmpty()){
            Pair curPair = queue.poll();
            int node = curPair.node;
            int parent = curPair.parent;
            for(int adjNode : adj.get(node)){
                if(visited[adjNode]==false){
                    visited[adjNode] = true;
                    queue.offer(new Pair(adjNode,node));
                }
                else if(adjNode != parent) {return true;}
            }
        }
        return false;
    }

    // Algo To Traverse On Components Too
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i] == false){
                if(bfs_detect(i, adj, visited)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);

        System.out.println("Have Cycle : " + isCycle(V, graph.adj));
    }
}
