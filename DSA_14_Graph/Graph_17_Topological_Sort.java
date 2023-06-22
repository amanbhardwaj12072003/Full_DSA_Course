
/*
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed 
edge u v, vertex u comes before v in the ordering.

Note: Topological Sorting for a graph is not possible if the graph is not a DAG.

For example, a topological sorting of the following graph is “5 4 2 3 1 0”. There can be more than one topological 
sorting for a graph. Another topological sorting of the following graph is “4 5 2 3 1 0”. The first vertex in topological
 sorting is always a vertex with an in-degree of 0 (a vertex with no incoming edges).      
*/


import java.util.*;
public class Graph_17_Topological_Sort {
    public static void dfs(int startNode,ArrayList<ArrayList<Integer>> adj,int[] visited,Stack<Integer> stack){
        visited[startNode] = 1;
        for(int adjNode : adj.get(startNode)){
            if(visited[adjNode] == 0){
                dfs(adjNode, adj, visited, stack);
            }
        }
        stack.push(startNode);
    }
    public static ArrayList<Integer> topologicalSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int u=0;u<V;u++){
            if(visited[u]==0){
                dfs(u,adj,visited,stack);
            }
        }
        ArrayList<Integer> topologicalSortedArray = new ArrayList<>();
        while(!stack.isEmpty()){
            topologicalSortedArray.add(stack.pop());
        }
        return topologicalSortedArray;
    }

    public static void main(String[] args) {
        
    }   
}
