import java.util.*;
public class Graph_37_Find_The_City_With_Smallest_No_Of_Neightbours {
    private static int findCity(int V, int[][] edges, int limit){
        int[][] Distance = new int[V][V];
        Arrays.fill(Distance,1_000_000_000);
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], distance = edge[2];
            Distance[u][v] = distance;
            Distance[v][u] = distance;
        }
        for(int index=0;index<V;index++) Distance[index][index] = 0;

        for(int via=0;via<V;via++){
            for(int index=0;index<V;index++){
                for(int index_=0;index_<V;index_++){
                    if(Distance[index][via]==1_000_000_000 || Distance[via][index_]==1_000_000_000) continue;
                    Distance[index][index_] = Math.min(Distance[index][index_],Distance[index][via] + Distance[via][index_]);
                }
            }
        }

        int countCity = 0, cityNo = 1_000_000_000;
        for(int city=0;city<V;city++){
            int count = 0;
            for(int adjCity=0;adjCity<V;adjCity++){
                if(Distance[city][adjCity]<=limit) count++;
            }
            if(count <= countCity){
                countCity = count;
                cityNo = city;
            }
        }
        return cityNo;
    }

    public static void main(String[] args) {
        findCity(0, null, 0);   
    }
}
