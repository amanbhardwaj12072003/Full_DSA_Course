import java.util.*;

// DisjointSet Class
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    // Constructor 
    DisjointSet(int V){
        for(int index=0;index<=V;index++){
            rank.add(0);
            parent.add(index);
            size.add(1);
        }
    }

    // Method to find ultimate parents
    public int findUltimateParent(int node){
        // Base Case 
        if(node == parent.get(node)) return node;

        int ultimateParent = findUltimateParent(parent.get(node));
        // Compression O(log(N)) -> O(1)
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    // Method to union node by rank
    public void unionByRank(int u, int v){
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        // Belongs to same component 
        if(ultimateParent_u==ultimateParent_v) return;

        // Otherwise 
        if(ultimateParent_u<ultimateParent_v){
            parent.set(ultimateParent_u,ultimateParent_v);
        }else if(ultimateParent_u>ultimateParent_v){
            parent.set(ultimateParent_v,ultimateParent_u);
        }else{
            parent.set(ultimateParent_v, ultimateParent_u);
            int rank_u = rank.get(ultimateParent_u);
            rank.set(ultimateParent_u,rank_u+1);
        }
    }

    // Method to union node by size 
    public void unionBySize(int u, int v){
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        // Belongs to same component 
        if(ultimateParent_u==ultimateParent_v) return;

        // Otherwise 
        if(size.get(ultimateParent_u)<size.get(ultimateParent_v)){
            parent.set(ultimateParent_u,ultimateParent_v);
            size.set(ultimateParent_v, size.get(ultimateParent_v)+size.get(ultimateParent_u));
        }else{
            parent.set(ultimateParent_v,ultimateParent_u);
            size.set(ultimateParent_u,size.get(ultimateParent_u) + size.get(ultimateParent_v));
        }
    }
}

public class Graph_39_Disjoint_Set_Implementation {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // Are 3 and 7 from the same component 
        if(ds.findUltimateParent(3)==ds.findUltimateParent(7)) { System.out.println("Same"); }
        else System.out.println("Not Same");

        // Adding more edges (Dynamic Graph)
        ds.unionBySize(3, 7);
        if(ds.findUltimateParent(3)==ds.findUltimateParent(7)) { System.out.println("Same"); }
        else System.out.println("Not Same");
    }   
}
