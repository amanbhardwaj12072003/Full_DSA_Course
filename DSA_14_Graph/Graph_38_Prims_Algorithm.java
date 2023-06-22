import java.util.*;
class Tuple{
    int weight, node, parent;
    Tuple(int weight, int node, int parent){
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
}
public class Graph_38_Prims_Algorithm {
    // Prim's Algorithm 
    // This algorithm is used to find the minimum spanning tree of a given graph
    // Spanning Tree -> Spanning Tree of a given graph is the graph with V vertices and V-1 edges and every other vertex is connected to each other.
    // Minimum Spanning Tree -> Minimum Spanning Tree of a given graph is the Spanning Trees of the given graph with the min sum of the edge weights 
    private static List<Tuple> Prims_Algorithm(int V, List<List<List<Integer>>> adj){
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((pair,pair_) -> pair.weight - pair_.weight);
        int[] visited = new int[V];
        minHeap.offer(new Tuple(0, 0, -1));
        int MST_Sum = 0;
        List<Tuple> MST_Edges = new ArrayList<>();
        while(!minHeap.isEmpty()){
            Tuple tuple = minHeap.poll();
            int weight = tuple.weight, node = tuple.node, parent = tuple.parent;

            if(visited[node]==1) continue;

            visited[node] = 1;
            MST_Sum += weight;
            if(parent!=-1){ MST_Edges.add(new Tuple(node, parent, weight)); }

            for(int index=0;index<adj.get(node).size();index++){
                int adjNode = adj.get(node).get(index).get(0);
                int edgeWeight = adj.get(node).get(index).get(1);
                if(visited[adjNode]==0){
                    minHeap.offer(new Tuple(edgeWeight, adjNode, node));
                }
            }
        }
        // return MST_Sum -> If just sum of Minimum Spanning Tree Was Asked 
        return MST_Edges;
    }

    public static void main(String[] args) {
        Prims_Algorithm(0, null);
    }
}
