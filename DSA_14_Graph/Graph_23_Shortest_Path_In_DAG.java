import java.util.*;
class Pair{
    int node,weight;
    Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class Graph_23_Shortest_Path_In_DAG {
    public static int[] findPath(int source,int V,int E,int[][] edges){

        // Make AdjList of weighed graph 
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        adj = getAdj(V, E, edges);

        // Get topological sort 
        int[] visited = new int[V];
        Stack<Integer> topological_stack = new Stack<>();
        for(int node=0;node<V;node++){
            if(visited[node]==0){
                dfs(node,adj,visited,topological_stack);
            }
        }

        // Store the minimum distance for all the nodes 
        int[] distance = new int[V];
        for(int node=0;node<V;node++) distance[node] = (int)(1e9);
        distance[source] = 0;
        while(!topological_stack.isEmpty()){
            int node = topological_stack.pop();
            for(Pair adjPair : adj.get(node)){
                int adjNode = adjPair.node;
                int weight = adjPair.weight;
                if(distance[node] + weight < distance[adjNode]){distance[adjNode] = distance[node] + weight;}
            }
        }
        return distance;
    }

    public static ArrayList<ArrayList<Pair>> getAdj(int V,int E,int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int node=0;node<V;node++) adj.add(new ArrayList<>());
        for(int edge=0;edge<E;edge++){
            int u = edges[edge][0];
            int v = edges[edge][1];
            int weight = edges[edge][2];
            adj.get(u).add(new Pair(v,weight));
        }
        return adj; 
    }

    public static void dfs(int node,ArrayList<ArrayList<Pair>> adj,int[] visited,Stack<Integer> stack){
        visited[node] = 1;
        for(Pair adjPair : adj.get(node)){
            int adjNode = adjPair.node;
            if(visited[adjNode]==0){dfs(adjNode,adj,visited,stack);}
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        
    }
}
