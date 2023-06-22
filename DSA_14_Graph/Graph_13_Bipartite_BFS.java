import java.util.*;
class Graph{
    int V;
    ArrayList<ArrayList<Integer>>  adj;
    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
    }
    void addEdge(int u,int v){
        adj.get(u).add(v);
    }
}
public class Graph_13_Bipartite_BFS {

    // Function to color one coponent of the graph
    public static boolean bfs(int start,ArrayList<ArrayList<Integer>> adj,int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int adjNode : adj.get(node)){
                if(color[adjNode]==-1){
                    color[adjNode] = 1 - color[node];
                    queue.offer(adjNode);
                }
                else if(color[adjNode]==color[node]) return false;
            }
        }
        return true;
    }

    // Function to get all components of the graph
    public static boolean isBipartite(int V,ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[V];
        for(int u=0;u<V;u++) color[u] = -1;

        for(int u=0;u<V;u++){
            if(color[u]==-1){
                if(!bfs(u,adj,color)) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 2);
        System.out.println("This Graph Is Bipartite : " + isBipartite(graph.V,graph.adj));

        /* some notes about bipartiness of graph
        - A bipartite graph is a graph which can be colored with only 2 colors such that no two adjacent nodes colored same 
        - A graph whose all the components are linear will always be a bipartite graph
        - A graph in which all components only have even membered cycles, will always be a bipartite graph
        - A graph in which any one of its components have an odd membered cylcle will always be a non bipartite graph 
        */
    }
}
