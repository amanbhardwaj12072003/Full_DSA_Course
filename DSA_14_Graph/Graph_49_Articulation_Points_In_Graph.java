// "Articulation Points" in a graph are the nodes on whoose removal the graph brakes down into two or more components.
// insertionTime[] -> Stores the time of insertion of particular node during the dfs 
// lowTime[] -> Stores the minimum of all the adjacent nodes apart from parent and visited nodes 

import java.util.*;
public class Graph_49_Articulation_Points_In_Graph {
    private static int timer = 1;

    private static void dfs(int node,int parent,int[] visited,int[] insertionTime, 
    int[] lowTime,int[] mark,List<List<Integer>> adj){
        visited[node] = 1;
        insertionTime[node] = lowTime[node] = timer;
        timer++;
        int countChild = 0;
        for(int adjNode : adj.get(node)){
            if(adjNode==parent) continue;

            if(visited[adjNode]==0){
                dfs(adjNode,node,visited,insertionTime,lowTime,mark,adj);
                lowTime[node] = Math.min(lowTime[node],lowTime[adjNode]);

                if(lowTime[adjNode]>=insertionTime[node] && parent!=-1){
                    mark[node] = 1;
                }
                countChild++;
            }else{
                lowTime[node] = Math.min(lowTime[node],insertionTime[adjNode]); // not lowTime[adjNode]
            }
        }
        if(countChild>1 && parent==-1){ mark[node] = 1; } 
    } 

    private static List<Integer> articulationPoints(int V, List<List<Integer>> adj){
        int[] visited = new int[V];
        int[] insertionTime = new int[V];
        int[] lowTime = new int[V];
        int[] mark = new int[V];
        for(int node=0;node<V;node++){
            if(visited[node]==0) dfs(node,-1,visited,insertionTime,lowTime,mark,adj);
        }

        List<Integer> ans = new ArrayList<>();
        for(int node=0;node<V;node++){
            if(mark[node]==1){ ans.add(node); }
        }

        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        articulationPoints(timer, null);
    }
}
