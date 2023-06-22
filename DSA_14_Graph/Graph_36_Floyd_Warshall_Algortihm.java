// The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed 
// graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge 
// from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
// Do it in-place.

public class Graph_36_Floyd_Warshall_Algortihm {
    private static void Floyd_Washall_Algorithm(int[][] weightMatrix){
        int len = weightMatrix.length;

        for(int index=0;index<len;index++){
            for(int index_=0;index_<len;index_++){
                if(weightMatrix[index][index_]==-1) weightMatrix[index][index_] = 1_000_000_000;
                if(index==index_) weightMatrix[index][index_] = 0;
            }
        }

        // Update 
        for(int via=0;via<len;via++){
            for(int index=0;index<len;index++){
                for(int index_=0;index_<len;index_++){
                    weightMatrix[index][index_] = Math.min(weightMatrix[index][index_], 
                    weightMatrix[index][via] + weightMatrix[via][index_]);
                }
            }
        }

        // Check for -ve cycle 
        for(int index=0;index<len;index++){
            if(weightMatrix[index][index]<0){
                System.out.println("Negetive Weight Cycle");
                return;
            } 
        }

        for(int index=0;index<len;index++){
            for(int index_=0;index_<len;index_++){
                if(weightMatrix[index][index_]==1_000_000_000) weightMatrix[index][index_] = -1;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Floyd_Washall_Algorithm(null);
    }
}
