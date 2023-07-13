// Bridges in a graph are the edges on whoose removal the graph brakes down in two or more different components.
// insertionTime[] -> Stores the time of insertion of particular node during the dfs 
// lowTime[] -> Stores the minimum of all the adjacent nodes apart from parent 

import java.util.*;
public class Graph_48_Bridges_In_Graph_Tarjans_Algorithm {
    private static int timer = 1;
    
    private static void dfs(int node, int parent, int[] visited, int[] insertionTime, 
    int[] lowTime, List<List<Integer>> adj, List<List<Integer>> bridges){
        visited[node] = 1;
        insertionTime[node] = lowTime[node] = timer;
        timer++;
        for(int adjNode : adj.get(node)){
            // We do not consider parent
            if(adjNode==parent) continue;

            if(visited[adjNode]==0){
                dfs(adjNode,node,visited,insertionTime,lowTime,adj,bridges);
                lowTime[node] = Math.min(lowTime[node],lowTime[adjNode]);
                if(lowTime[adjNode]>insertionTime[node]){
                    List<Integer> connection = new ArrayList<>();
                    connection.add(node);
                    connection.add(adjNode);
                    bridges.add(connection);
                }
            }else{
                lowTime[node] = Math.min(lowTime[node],lowTime[adjNode]);
            }
        }

    }

    private static List<List<Integer>> Tarjans_Algorithm(int V, List<List<Integer>> connections){
        List<List<Integer>> adj = new ArrayList<>();
        for(int node=0;node<V;node++) adj.add(new ArrayList<>());
        for(List<Integer> connection : connections){
            int u = connection.get(0), v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] visited = new int[V];
        int[] insertionTime = new int[V];
        int[] lowTime = new int[V];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,visited,insertionTime,lowTime,adj,bridges);
        return bridges;
    }

    public static void main(String[] args) {
        Tarjans_Algorithm(0, null);
    }
}
