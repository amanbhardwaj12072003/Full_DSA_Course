import java.util.*;
public class Graph_15_Detect_Cycle_In_DG_Using_DFS {

    // Traversing all the components of the given graph 
    public static boolean checkCycle(int V,ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for(int u=0;u<V;u++){
            if(visited[u]==0){
                if(dfs(u,adj,visited,pathVisited)==true) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int startNode,ArrayList<ArrayList<Integer>> adj,int[] visited, int[] pathVisited){
        visited[startNode] = 1;
        pathVisited[startNode] = 1;

        // Traverse the adjacent nodes 
        for(int adjNode : adj.get(startNode)){
            if(visited[adjNode]==0){
                if(dfs(adjNode, adj, visited, pathVisited)) return true;
            }
            else if(pathVisited[startNode]==1) return true;
        }

        pathVisited[startNode] = 0;
        return false;
    }

    public static void main(String[] args) {
        
    }
}
