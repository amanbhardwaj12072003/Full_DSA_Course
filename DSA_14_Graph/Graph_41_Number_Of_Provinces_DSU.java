import java.util.*;

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int V){
        for(int index=0;index<=V;index++){
            rank.add(0);
            size.add(1);
            parent.add(index);
        }
    }

    public int findUltimateParent(int node){
        // Base Case 
        if(node == parent.get(node)) return node;

        // Code 
        int ultimateParent = findUltimateParent(node);
        parent.set(node,ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u, int v){
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        if(ultimateParent_u==ultimateParent_v) return;

        if(rank.get(ultimateParent_u)<rank.get(ultimateParent_v)){
            parent.set(ultimateParent_u,ultimateParent_v);
        }else if(rank.get(ultimateParent_u)>rank.get(ultimateParent_v)){
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

public class Graph_41_Number_Of_Provinces_DSU {

    private static int countProvinces(int V, List<List<Integer>> adj){
        DisjointSet disjointSet = new DisjointSet(V);
        for(int node=0;node<V;node++){
            for(int adjNode=0;adjNode<V;adjNode++){
                if(adj.get(node).get(adjNode)==1) disjointSet.unionBySize(node, adjNode);
            }
        }

        int countProvinces = 0;
        for(int node=0;node<V;node++){
            if(disjointSet.findUltimateParent(node)==node) countProvinces++;
        }
        return countProvinces;
    }
    
    public static void main(String[] args) {
        countProvinces(0, null);
    }
}
