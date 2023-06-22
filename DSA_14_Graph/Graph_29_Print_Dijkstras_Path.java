import java.util.*;
class Pair{
    int val1,val2;
    Pair(int val1,int val2){
        this.val1 = val1;
        this.val2 = val2;
    }
}
public class Graph_29_Print_Dijkstras_Path {

    public static ArrayList<Integer> printDijkstra(int V,int N,int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int node=0;node<V;node++) adj.add(new ArrayList<>());
        for(int index=0;index<N;index++){
            int edge1 = edges[index][0], edge2 = edges[index][1], distance = edges[index][2];
            adj.get(edge1).add(new Pair(edge2,distance));
            adj.get(edge2).add(new Pair(edge1,distance));
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((edge1,edge2) -> edge1.val1 - edge2.val2);
        int[] Distance = new int[V+1];
        int[] parent = new int[V+1];
        for(int node=1;node<=V;node++){
            Distance[node] = (int)(1e9);
            parent[node] = node;
        }

        Distance[1] = 0; // As we want to go from 1 -> N
        minHeap.add(new Pair(0,1));
        while(!minHeap.isEmpty()){
            Pair curPair = minHeap.poll();
            int node = curPair.val2;
            int distance = curPair.val1;
            for(Pair adjPair : adj.get(node)){
                int adjNode = adjPair.val1;
                int adjDistance = adjPair.val2;
                if(distance+adjDistance < Distance[adjNode]){
                    Distance[adjNode] = distance + adjDistance;
                    minHeap.add(new Pair(distance+adjDistance,adjNode));
                    parent[adjNode] = node;

                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        // If reaching V(ie target is not possible)
        if(Distance[V] == (int)(1e9)){
            path.add(-1);
            return path;
        }

        int node = V;
        while(parent[node]!=node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        
    }
}
