import java.util.*;
class Pair{
    int node,weight;
    Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class Graph_33_Min_Multiplication_To_Reach_End {

    public static int fun(int V,ArrayList<ArrayList<Integer>> data){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int node=0;node<V;node++) adj.add(new ArrayList<>());
        int N = data.size();
        for(int index=0;index<N;index++){
            int edge1 = data.get(index).get(0);
            int edge2 = data.get(index).get(1);
            int weight = data.get(index).get(2);
            adj.get(edge1).add(new Pair(edge1,weight));
            adj.get(edge2).add(new Pair(edge1,weight));
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        int[] distance = new int[V];
        int[] ways = new int[V];
        for(int node=0;node<V;node++){
            distance[node] = (int)(1e9);
            ways[node] = 0;
        }

        distance[1] = 0;
        ways[0] = 1;
        minHeap.offer(new Pair(0,0));
        int mod = (int)(1e9+7);
        while(!minHeap.isEmpty()){
            Pair curPair = minHeap.poll();
            int curNode = curPair.node;
            int curWeight = curPair.weight;
            for(Pair adjPair : adj.get(curNode)){
                int adjNode = adjPair.node;
                int adjWeight = adjPair.weight;
                if(curWeight+adjWeight<distance[adjNode]){
                    distance[adjNode] = curWeight+adjWeight;
                    minHeap.offer(new Pair(adjNode,curWeight+adjWeight));
                    ways[adjNode] = (ways[curNode] + ways[adjNode])%mod;
                }
            }
        }
        return ways[V-1]%mod;
    }

    public static void main(String[] args) {
        
    }
}
