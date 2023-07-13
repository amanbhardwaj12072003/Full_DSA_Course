import java.util.*;
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int V){
        for(int index=0;index<=V;index++){
            rank.add(0);
            size.add(1);
            parent.add(index);
        }
    }

    public int findUltimateParent(int node){
        // Base Case 
        if(node==parent.get(node)) return node;

        // Code 
        int ultimateParent = parent.get(node);
        parent.set(node,ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u, int v){
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        if(ultimateParent_u==ultimateParent_v) return;

        if(ultimateParent_u<ultimateParent_v){
            parent.set(ultimateParent_u,ultimateParent_v);
        }else if(ultimateParent_u>ultimateParent_v){
            parent.set(ultimateParent_v,ultimateParent_u);
        }else{
            parent.set(ultimateParent_v,ultimateParent_u);
            int rank_u = rank.get(ultimateParent_u);
            rank.set(ultimateParent_u,rank_u+1);
        }
    }

    public void unionBySize(int u, int v){
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        if(ultimateParent_u==ultimateParent_v) return;

        if(size.get(ultimateParent_u)<size.get(ultimateParent_v)){
            parent.set(ultimateParent_u,ultimateParent_v);
            size.set(ultimateParent_v,size.get(ultimateParent_u)+size.get(ultimateParent_v));
        }else{
            parent.set(ultimateParent_v,ultimateParent_u);
            size.set(ultimateParent_u,size.get(ultimateParent_u)+size.get(ultimateParent_v));
        }
    }
}

/*

Java Comparable interface
Java Comparable interface is used to order the objects of the user-defined class. This interface is found in 
java.lang package and contains only one method named compareTo(Object). 
It provides a single sorting sequence only,  i.e., you can sort the elements on the basis of single data member only. 
For example, it may be rollno, name, age or anything else.

compareTo(Object obj) method
public int compareTo(Object obj): It is used to compare the current object with the specified object. It returns

positive integer, if the current object is greater than the specified object.
negative integer, if the current object is less than the specified object.
zero, if the current object is equal to the specified object.

*/

// This is to sort the edges on the basis of weight :(
class Edge implements Comparable<Edge>{
    int source, destination, weight;
    Edge(int source, int destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

public class Graph_40_Kruskals_Algorithm {
    
    // Kruskal's Algorithm 
    private static int Kruskal_Algorithm(int V, List<List<List<Integer>>> adj){

        // Getting Edges From The Given Adj List 
        List<Edge> edges = new ArrayList<>();
        for(int index=0;index<V;index++){
            for(int index_=0;index_<adj.get(index).size();index_++){
                int node = index;
                int adjNode = adj.get(index).get(index_).get(0);
                int weight = adj.get(index).get(index_).get(1);
                Edge edge = new Edge(node,adjNode,weight);
                edges.add(edge);
            }
        }

        DisjointSet disjoinSet = new DisjointSet(V);
        int MST_Sum = 0;

        for(int index=0;index<edges.size();index++){
            int u = edges.get(index).source;
            int v = edges.get(index).destination;
            int weight = edges.get(index).weight;
            if(disjoinSet.findUltimateParent(u)!=disjoinSet.findUltimateParent(v)){
                MST_Sum += weight;
                disjoinSet.unionBySize(u, v);
            }
        }
        return MST_Sum;
    }

    public static void main(String[] args) {
        Kruskal_Algorithm(0, null);
    }
}


class UnionFind{
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    UnionFind(int V){
        for(int index=0;index<V;index++){
            rank.add(0);
            size.add(1);
            parent.add(index);
        }
    }

    int find(int node){
        if(node==parent.get(node)) return node;
        int ultimateParent = find(parent.get(node));
        parent.set(node,ultimateParent);
        return ultimateParent;
    }

    // Union By Rank 
    void union(int u, int v){
        int ultimateParent_u = find(u);
        int ultimateParent_v = find(v);
        if(ultimateParent_u==ultimateParent_v) return;

        if(rank.get(ultimateParent_u)<rank.get(ultimateParent_v)){
            parent.set(ultimateParent_u,ultimateParent_v);
        }else if(rank.get(ultimateParent_u)>rank.get(ultimateParent_v)){
            parent.set(ultimateParent_v,ultimateParent_u);
        }else{
            parent.set(ultimateParent_v,ultimateParent_u);
            int rank_u = rank.get(ultimateParent_u);
            rank.set(ultimateParent_u,rank_u);
        }
    }

    // Union By Size 
    void union_(int u, int v){
        int ultimateParent_u = find(u);
        int ultimateParent_v = find(v);

        if(ultimateParent_u==ultimateParent_v) return;

        if(size.get(ultimateParent_u)<size.get(ultimateParent_v)){
            parent.set(ultimateParent_u,ultimateParent_v);
            size.set(ultimateParent_v,size.get(ultimateParent_u)+size.get(ultimateParent_v));
        }else{
            parent.set(ultimateParent_v,ultimateParent_u);
            size.set(ultimateParent_u,size.get(ultimateParent_u)+size.get(ultimateParent_v));
        }
    }
}
