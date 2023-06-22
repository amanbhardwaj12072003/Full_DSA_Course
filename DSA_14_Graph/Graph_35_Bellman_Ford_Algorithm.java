import java.util.*;
public class Graph_35_Bellman_Ford_Algorithm {
    // Note that Bellman Ford Algorithm is only applicable to Directed Graph
    // If we wish to apply Bellman Ford to undirected graphs, then we should convert the given undirected graph edges 
    // between two nodes to antiparellel edges.
    // Note that Dijksra's algorithm is not applicable to graphs with negetive edge weights, but Bellman Ford Algorithm
    //  is applicable to Directed graphs with negetive weights as well
    // Note that Bellman Ford is not applicable to graphs with negetive weight cycles 
    private static int[] Bellman_Ford_Algorithm(int V, ArrayList<ArrayList<Integer>> edges, int source){
        int[] Distance = new int[V];
        Arrays.fill(Distance,1_0000_0000);
        Distance[source] = 0;

        // V-1 Iterations
        for(int interation=1;interation<=V-1;interation++){
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0), v = edge.get(1), distance = edge.get(1);
                if(Distance[u]!=1_0000_0000 && Distance[u] + distance < Distance[v]){
                    Distance[v] = Distance[u] + distance;
                }
            }
        }

        // Vth Iteration
        // If any update occur in Vth Iteration, then we can conclude that there is a negetive cycle in the given graph as the Distance array is supposed to complete all it's updations in V-1 Iterations.
        for(ArrayList<Integer> edge : edges){
            int u = edge.get(0), v = edge.get(1), distance = edge.get(1);
            if(Distance[u]!=1_0000_0000 && Distance[u] + distance < Distance[v]){
                return new int[]{-1};
            }
        }
        return Distance;
    }


    public static void main(String[] args) {
        int [] ans = Bellman_Ford_Algorithm(0, null, 0)
    }
}
