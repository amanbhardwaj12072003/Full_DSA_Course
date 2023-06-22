import java.util.*;
class Graph{
    int V;
    ArrayList<ArrayList<Integer>> adj;
    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int u=0;u<V;u++) adj.add(new ArrayList<>()); 
    }
    void addEdge(int u,int v){
        adj.get(u).add(v);
    }
}

public class Graph_02_DFS {

    // Recursive DFS Algortihm 
    // Time Complexity : O(V) + O(2*V)
    // Space Complexity : O(V) + O(V)
    public static void DFS(int Node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfs){
        dfs.add(Node);
        visited[Node] = true;
        for(Integer node : adj.get(Node)){
            if(!visited[node]){
                visited[node] = true;
                DFS(node,visited,adj,dfs);
            }
        }
    }
    public static ArrayList<Integer> Recursive_DFS(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        visited[0] = true;
        DFS(1,visited,adj,dfs);
        return dfs;
    }
        

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 3);
        graph.addEdge(4, 8);
        graph.addEdge(5, 2);
        graph.addEdge(6, 2);
        graph.addEdge(7, 3);
        graph.addEdge(7, 8);
        graph.addEdge(8, 4);
        graph.addEdge(8, 7);
        System.out.println(Recursive_DFS(graph.V,graph.adj));

    }
}
