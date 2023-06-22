import java.util.*;
class Graph{
    int V;
    ArrayList<ArrayList<Integer>> adj;
    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int u=0;u<V;u++) adj.add(new ArrayList<>());
    }
    void addEdge(int u,int v){
        adj.get(u).add(v);
    }
}

public class Graph_01_BFS {
    public static ArrayList<Integer> BFS(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // If given graph in 1 based then is will be queue.offer(1)
        visited[0] = true;
        while(!queue.isEmpty()){
            Integer currentNode = queue.poll();
            bfs.add(currentNode);
            for(Integer connectedNodes : adj.get(currentNode)){
                if(!visited[connectedNodes]){
                    queue.offer(connectedNodes);
                    visited[connectedNodes] = true;
                }
            }
        }
        return bfs;
    } 

    public static void main(String[] args) {
        // Considering a 0 based graph
        Graph graph = new Graph(7);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,0);
        graph.addEdge(1,3);
        graph.addEdge(2,0);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(3,1);
        graph.addEdge(3,6);
        graph.addEdge(4,2);
        graph.addEdge(5,2);
        graph.addEdge(5,6);
        graph.addEdge(6,3);
        graph.addEdge(6,5);

        // Printing BFS
        ArrayList<Integer> bfs = new ArrayList<>();
        bfs = BFS(graph.V,graph.adj);
        System.out.println("The BFS of graph is : " + bfs);
    }
}
