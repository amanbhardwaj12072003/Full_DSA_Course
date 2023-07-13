import java.util.*;
public class Graph_47_Strongly_Connected_Components_Kosarajus_Algorithm {

    private static void dfs(int node, int[] visited, Stack<Integer> stack, List<List<Integer>> adj){
        visited[node] = 1;
        for(Integer adjNode : adj.get(node)){
            if(visited[adjNode]==0) dfs(adjNode,visited,stack,adj);
        }
        stack.push(node);
    }

    private static void dfs_(int node, int[] visited, List<List<Integer>> revAdj){
        visited[node] = 1;
        for(int adjNode : revAdj.get(node)){
            if(visited[adjNode]==0) dfs_(adjNode,visited,revAdj);
        }
    }

    private static int Kosarajus_Algorithm(int V, List<List<Integer>> adj){
        // Step 1 - Sorting of the graph according to the finish time of the nodes 
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];
        for(int node=0;node<V;node++){
            if(visited[node]==0){
                dfs(node,visited,stack,adj);
            }
        }

        // Step 2 - Reverse all the edges in the graph 
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int node=0;node<V;node++) revAdj.add(new ArrayList<>());
        for(int node=0;node<V;node++){
            visited[node] = 0;
            for(int adjNode : adj.get(node)){
                revAdj.get(adjNode).add(node);
            }
        }

        int countSCC = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited[node]==0){
                countSCC++;
                dfs_(node,visited,revAdj);
            }
        }

        return countSCC;
    }

    public static void main(String[] args) {
        Kosarajus_Algorithm(0, null);
    }
}
