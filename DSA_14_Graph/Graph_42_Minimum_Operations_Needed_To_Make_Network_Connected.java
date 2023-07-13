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
        if(node==parent.get(node)) return node;

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

public class Graph_42_Minimum_Operations_Needed_To_Make_Network_Connected {

    private static int countOperation(int V, int[][] edges){
        DisjointSet disjointSet = new DisjointSet(V);
        int extraEdges = 0;

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            if(disjointSet.findUltimateParent(u)==disjointSet.findUltimateParent(v)) extraEdges++;
            else{
                disjointSet.unionBySize(u, v);
            }
        }

        int countComponents = 0;
        for(int node=0;node<V;node++){
            if(disjointSet.findUltimateParent(node)==node) countComponents++;
        }
        
        int minRequiredEdges = countComponents - 1;
        return (minRequiredEdges <= extraEdges) ? minRequiredEdges : -1;
    }

    public static void main(String[] args) {
        countOperation(0, null);
    }
}
