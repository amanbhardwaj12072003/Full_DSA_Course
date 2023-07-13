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
        if(node == rank.get(node)) return node;

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

public class Graph_45_Making_A_Large_Island {

    private static int makeIsland(int[][] grid){
        int N = grid.length;
        DisjointSet disjoinSet = new DisjointSet(N*N);

        // Step 1 
        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
                if(grid[row][col]==0) continue;

                int[] moveRow = {-1,0,1,0}, moveCol = {0,1,0,-1};
                for(int move=0;move<4;move++){
                    int newRow = row + moveRow[move], newCol = col + moveCol[move];
                    if(isValid(newRow,newCol,N,N) && grid[newRow][newCol]==1){
                        int nodeInDSU = row*N + col;
                        int adjNodeInDSU = newRow*N + col;
                        disjoinSet.unionBySize(nodeInDSU, adjNodeInDSU);
                    }
                }
            }
        }

        // Step 2
        int maxConnected = 0;
        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
                if(grid[row][col]==1) continue;

                int[] moveRow = {-1,0,1,0}, moveCol = {0,1,0,-1};
                Set<Integer> components = new HashSet<>();
                for(int move=0;move<4;move++){
                    int newRow = row + moveRow[move], newCol = col + moveCol[move];
                    if(isValid(newRow,newCol,N,N)){
                        if(grid[newRow][newCol]==1){
                            int nodeInDSU = newRow*N + newCol;
                            components.add(disjoinSet.findUltimateParent(nodeInDSU));
                        }
                    }
                }
                int totalSize = 0;
                for(int parent : components){ totalSize += disjoinSet.size.get(parent); }
                maxConnected = Math.max(maxConnected, totalSize);
            }
        }

        // To check if any single connection is larger then sum of many.
        for(int nodeInDSU=0;nodeInDSU<N*N;nodeInDSU++){
            maxConnected = Math.max(maxConnected,disjoinSet.size.get(nodeInDSU));
        }

        return maxConnected;
    }

    private static boolean isValid(int row, int col, int Row, int Col){
        return (row>=0 && row<Row) && (col>=0 && col<Col);
    }

    public static void main(String[] args) {
        makeIsland(null);
    }
}
