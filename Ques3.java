import java.util.*;
class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class Ques3 {
    public static int calculateShortestPath(int numStops, int[] credits, int numRoads, int[][] roads, int source, int destination){
        List<List<Pair>> adjList = new ArrayList<>();
        for(int index=0;index<numRoads;index++) adjList.add(new ArrayList<>());
        for(int index=0;index<numRoads;index++){
            int u = roads[index][0], v = roads[index][1], weight = roads[index][2];
            adjList.get(u).add(new Pair(v,weight));
            adjList.get(v).add(new Pair(u,weight));
        }

        int[] distances = new int[(int)(1e6)+5];
        Arrays.fill(distances,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair pair1, Pair pair2)-> pair1.first-pair2.first);
        int initialNode = credits[source] * numStops + source;
        pq.offer(new Pair(0,initialNode));
        distances[initialNode] = 0;
        while(!pq.isEmpty()){
            Pair currentPair = pq.poll();
            int currentDistance = currentPair.first;
            int currentNode = currentPair.second;
            int currentCredit = currentNode / numStops;
            int currentVertex = currentNode % numStops;
            if (currentVertex == destination) {
                return -currentDistance;
            }
            for (Pair neighbor : adjList.get(currentVertex)){
                int neighborVertex = neighbor.first;
                int weight = neighbor.second;
                if (weight > currentCredit) continue;
                int newCredit = currentCredit - weight + credits[neighborVertex];
                int newScore = newCredit * numStops + neighborVertex;
                if (newCredit > 1e4) continue;
                if (distances[newScore] > distances[currentNode] + weight) {
                    distances[newScore] = distances[currentNode] + weight;
                    pq.offer(new Pair(-(distances[currentNode]+weight),newScore));
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int numStops = 5;
        int[] credits = {2,10,5,100,3};
        int numRoads = 8;
        int[][] roads = {
            {0,1,2},
            {0,3,5},
            {0,2,1},
            {1,3,10},
            {1,4,15},
            {2,3,7},
            {2,4,90},
            {3,4,80}
        };
        int source = 0, destination = 4;
        System.out.println(calculateShortestPath(numStops, credits, numRoads, roads, source, destination));
    }
}
