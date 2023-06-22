// Very Very very Important ALgorithm, Having Many Use Cases 
import java.util.*;
class Pair{
    int edge,distance;
    Pair(int edge,int distance){
        this.edge = edge;
        this.distance = distance;
    }
}

class Tuple{
    int stops,edge,distance;
    Tuple(int stops,int edge,int distance){
        this.stops = stops;
        this.edge = edge;
        this.distance = distance;
    }
}
public class Graph_32_Cheapest_Flight_Within_K_Stops {

    public static int fun(int V,int[][] flights,int start,int end,int k){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int node=0;node<V;node++) adj.add(new ArrayList<>());
        int N = flights.length;
        for(int index=0;index<N;index++){
            int edge1 = flights[index][0], edge2 = flights[index][1], distance = flights[index][2];
            adj.get(edge1).add(new Pair(edge2,distance));
        }
        Queue<Tuple> queue = new LinkedList<>();
        int[] distance = new int[V];
        for(int node=0;node<V;node++) distance[node] = (int)(1e9);
        queue.offer(new Tuple(0, start, 0));
        distance[start] = 0;
        while(!queue.isEmpty()){
            Tuple curTuple = queue.poll();
            int curStops = curTuple.stops;
            int curEdge = curTuple.edge;
            int curDistance = curTuple.distance;

            // Check 
            if(curStops>k) continue;

            // Code 
            for(Pair curPair : adj.get(curEdge)){
                int adjNode = curPair.edge;
                int adjDistance = curPair.distance;
                if(curDistance+adjDistance<distance[adjNode] && curStops<=k){
                    distance[adjNode] = curDistance+adjDistance;
                    queue.offer(new Tuple(curStops+1,adjNode,curDistance+adjDistance));
                }
            }
        }

        // Check 
        if(distance[end]==(int)(1e9)) return -1;
        return distance[end];
    }

    public static void main(String[] args) {
        
    }
}
