import java.util.*;
public class Graph_20_Course_Schedule_I_And_II {

    // Solution To Course Schedule I
    public static boolean isPossible(int V,ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for(int u=0;u<V;u++){
            if(visited[u]==0){
                if(dfs_I(u,adj,visited,pathVisited)) return true;
            }
        }
        return false;
    }
    public static boolean dfs_I(int startNode,ArrayList<ArrayList<Integer>> adj,int[] visited,int[] pathVisited){
        visited[startNode] = 1;
        pathVisited[startNode] = 1;

        for(int adjNode : adj.get(startNode)){
            if(visited[adjNode]==0){
                if(dfs_I(adjNode, adj, visited, pathVisited)) return true;
            }
            else if(pathVisited[adjNode]==1) return true;
        }

        pathVisited[startNode] = 0;
        return false;
    }

    // Solution To Course Schedule II
    public static ArrayList<Integer> topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];
        for(int u=0;u<V;u++){
            for(int node : adj.get(u)) {inDegree[u]++;}
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int u=0;u<V;u++){
            if(inDegree[u]==0) {queue.offer(u);}
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            topoSort.add(node);
            for(int adjNode : adj.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0) {queue.offer(adjNode);}
            }
        }

        if(topoSort.size()==V) return topoSort;
        else return new ArrayList<>();
    }

    public static void main(String[] args) {
        
    }
}
