import java.util.*;
public class Graph_16_Find_Eventual_Safe_States {
    public static ArrayList<Integer> findSafe(int V,ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        int[] areSafe = new int[V]; 
        for(int u=0;u<V;u++){
            if(visited[u]==0){
                dfs(u,adj,visited,pathVisited,areSafe);
            }
        }
        ArrayList<Integer> safe = new ArrayList<>();
        for(int u=0;u<V;u++){
            if(areSafe[u]==1) safe.add(u);
        }
        return safe;
    }

    public static boolean dfs(int startNode,ArrayList<ArrayList<Integer>> adj,int[] visited,int[] pathVisited,int[] areSafe){
        visited[startNode]=1;
        pathVisited[startNode]=1;
        areSafe[startNode]=0;
        for(int adjNode : adj.get(startNode)){
            if(visited[adjNode]==0){
                if(dfs(adjNode, adj, visited, pathVisited, areSafe)){
                    areSafe[adjNode] = -1;
                    return true;
                }
            }
            else if(pathVisited[adjNode]==1){
                areSafe[adjNode] = -1;
                return true;
            }
        }
        pathVisited[startNode] = 0;
        areSafe[startNode] = 1;
        return false;
    }

    public static void main(String[] args) {
        
    }
}
