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
            parent.set(ultimateParent_v,ultimateParent_u);
        }else{
            parent.set(ultimateParent_v,ultimateParent_u);
            int rank_u = rank.get(ultimateParent_u);
            rank.set(ultimateParent_u,rank_u+1);
        }
    }

    public void unionBySize(int u, int v){
        int ultimateParent_u = findUltimateParent(v);
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

public class Graph_44_Number_Of_Islands {

    private static boolean isValid(int row, int col, int Row, int Col){
        return (row>=0 && row<Row) && (col>=0 && col<Col);
    }

    private static List<Integer> numOfIslands_Online_Queries(int Row, int Col, int[][] operators){
        DisjointSet disjointSet = new DisjointSet(Row*Col);
        int[][] visited = new int[Row][Col];
        int count = 0;
        List<Integer> storeCount = new ArrayList<>();
        for(int[] operation : operators){
            int row = operation[0], col = operation[1];

            if(visited[row][col]==1){
                storeCount.add(count);
                continue;
            }

            visited[row][col] = 1;
            count++; // First lets consider it as a indivisual island 
            int[] moveRow = {-1,0,1,0}, moveCol = {0,1,0,-1};
            for(int move=0;move<4;move++){
                int adjRow = row + moveRow[move], adjCol = col + moveCol[move];
                if(isValid(adjRow, adjCol, Row, Col)){
                    if(visited[adjRow][adjCol]==1){
                        int nodeInDSU = row*Col + col;
                        int adjNodeInDSU = adjRow*Col + col;
                        if(disjointSet.findUltimateParent(nodeInDSU) != disjointSet.findUltimateParent(adjNodeInDSU)){
                            count--; // Le kheech liya 
                            disjointSet.unionBySize(nodeInDSU, adjNodeInDSU);
                        }
                    }
                }
            }
            storeCount.add(count);
        }
        return storeCount;
    }

    public static void main(String[] args) {
        
    }
}
