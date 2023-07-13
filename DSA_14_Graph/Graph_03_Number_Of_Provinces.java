/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, 
and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly 
connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
*/

import java.util.*;
public class Graph_03_Number_Of_Provinces {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(int it : adj.get(node)){
            dfs(it,adj,visited);
        }
    }

    public static int countProvinces(int[][] adjMatrix,int V){
        // First Make adjecency list 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adjMatrix[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[V];
        int counOfProvinces = 0;
        for(int node=0;node<V;node++){
            if(!visited[node]){
                counOfProvinces++;
                dfs(node,adj,visited);
            }
        }
        return counOfProvinces;
    }
    public static void main(String[] args) {
        int[][] adjMatrix = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1},
        };
        System.out.println("Number Of Provinces In The Give Graph Are : " + countProvinces(adjMatrix,adjMatrix.length));

    }
}
