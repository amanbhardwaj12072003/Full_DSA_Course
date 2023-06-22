import java.util.*;
public class Graph_24_Shortest_Path_In_UDG {
    public static int[] getDistance(int[][] edges,int V,int N,int Source){

        // Make Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj = makeAdj(V,N,edges);

        // Calculate Distance
        int[] distance = new int[V];
        for(int node=0;node<V;node++) distance[node] = (int)(1e9);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(Source);
        distance[Source] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int adjNode : adj.get(node)){
                if(distance[node]+1<distance[adjNode]){
                    distance[adjNode]=1+distance[node];
                    queue.offer(adjNode);
                }
            }
        }

        // Check for unreachable nodes, if any 
        for(int node=0;node<V;node++){
            if(distance[node]==(int)(1e9)) distance[node]=-1;
        }
        return distance;
    }

    public static ArrayList<ArrayList<Integer>> makeAdj(int V,int N,int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int edge=0;edge<V;edge++) adj.add(new ArrayList<>());
        for(int i=0;i<N;i++){
            int node1=edges[i][0];
            int node2 = edges[i][1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        return adj;
    }

    public static void main(String[] args) {
        
    }
}
