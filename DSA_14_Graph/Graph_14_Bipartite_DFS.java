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
public class Graph_14_Bipartite_DFS {
    public static boolean isBipartite(int V,ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[V];
        for(int u=0;u<V;u++) color[u] = -1;
        for(int u=0;u<V;u++){
            if(color[u]==-1){
                if(dfs(u,0,color,adj)==false) return false;
            }
        }
        return true;
    }

    public static boolean dfs(int startNode,int curColor, int[] color,ArrayList<ArrayList<Integer>> adj){
        color[startNode] = curColor;
        for(int adjNode : adj.get(startNode)){
            if(color[adjNode]==-1){
                if(!dfs(adjNode,1-curColor,color,adj)){
                    return false;
                }
            }
            else if(color[adjNode]==curColor) return false;
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
    }
}
