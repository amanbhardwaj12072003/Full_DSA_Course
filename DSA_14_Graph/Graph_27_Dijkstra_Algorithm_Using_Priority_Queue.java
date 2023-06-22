import java.util.*;
class Pair{
    int distance,node;
    Pair(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}
public class Graph_27_Dijkstra_Algorithm_Using_Priority_Queue {

    // Dijkstra's Algorithm Is Not Applicable To Gr aphs With Negetive Weight as This Will Lie In Infinite Loop Cycle
    public static int[] Dijkstra(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int Source){
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((node1,node2) -> node1.distance-node2.distance);
        int[] shortestDistance = new int[V];
        for(int i=0;i<V;i++) shortestDistance[i] = (int)(1e9);
        shortestDistance[Source] = 0;
        minHeap.add(new Pair(0, Source));
        while(!minHeap.isEmpty()){
            Pair curPair = minHeap.poll();
            int curDistance = curPair.distance;
            int curNode = curPair.node;
            for(int node=0;node<adj.get(curNode).size();node++){
                int adjNode = adj.get(curNode).get(node).get(0);
                int edgeWeight = adj.get(curNode).get(node).get(1);
                if(curDistance+edgeWeight<shortestDistance[adjNode]){
                    shortestDistance[adjNode] = curDistance+edgeWeight;
                    minHeap.add(new Pair(shortestDistance[adjNode],adjNode));
                }
            }
        }
        return shortestDistance;
    }

    public static void main(String[] args) {
        
    }   
}
