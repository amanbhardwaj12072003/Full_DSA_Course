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
            parent.set(ultimateParent_v,ultimateParent_v);
        }else{
            parent.set(ultimateParent_v,ultimateParent_u);
            int rank_u = rank.get(ultimateParent_u);
            rank.set(ultimateParent_u,rank_u);
        }
    }

    public void unionBySize(int u, int v){
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        if(ultimateParent_u==ultimateParent_v) return;

        if(size.get(ultimateParent_u)<rank.get(ultimateParent_v)){
            parent.set(ultimateParent_u,ultimateParent_v);
            size.set(ultimateParent_v,size.get(ultimateParent_u)+size.get(ultimateParent_v));
        }else{
            parent.set(ultimateParent_v,ultimateParent_u);
            size.set(ultimateParent_u,size.get(ultimateParent_u)+size.get(ultimateParent_v));
        }
    }
}

public class Graph_46_Most_Stones_Removed {

    private static int countStones(int[][] stones, int n){
        int Row = 0, Col = 0;
        for(int[] stone : stones){
            Row = Math.max(Row,stone[0]);
            Col = Math.max(Col,stone[1]);
        }

        DisjointSet disjointSet = new DisjointSet(Row + Col + 1);
        HashMap<Integer,Integer> stoneNodes = new HashMap<>();

        for(int[] stone : stones){
            int nodeRow = stone[0], nodeCol = stone[1] + Row + 1;
            disjointSet.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow,1);
            stoneNodes.put(nodeCol,1);
        }

        int countComponents = 0;
        for(Map.Entry<Integer,Integer> e : stoneNodes.entrySet()){
            if(disjointSet.findUltimateParent(e.getKey())==e.getKey()) countComponents++;
        }

        return n - countComponents;
    }

    /*
    
    - What is the reason behind n - countComponents
    - let say after connecting all the rows and corresponding cols to make components we ends up having 
    - Components C1, C2, C3,....Cn having x1, x2, x3,...xn number of nodes respectively.
    - Now we know, 
    - x1 + x2 + x3 + ... + xn = total stones
    - x1 + x2 + x3 + ... + xn = N
    - We also know that for a single components we can remove all the stones except the last 1
    - maxRemovePossible = (x1 - 1) + (x2 - 1) + (x3 - 1) + ... + (xn - 1)
    - maxRemovePossible = (x1 + x2 + x3 + ... + xn) - (1 + 1 + 1 + ... + 1) n-times
    - maxRemovePossible = (x1 + x2 + x3 + ... + xn) - n
    - maxRemovePossible = N - n
    - Where N -> Total Number Of Stones || n -> Total Number Of Connected Components 
    
    */

    public static void main(String[] args) {
        countStones(null, 0);
    }
}
