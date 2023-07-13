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
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u, int v){
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        if(ultimateParent_u==ultimateParent_v) return;
        
        if(rank.get(ultimateParent_u)<rank.get(ultimateParent_v)){
            parent.set(ultimateParent_u,ultimateParent_v);
        }else if(rank.get(ultimateParent_u)>ultimateParent_v){
            parent.set(ultimateParent_v,ultimateParent_u);
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

        if(size.get(ultimateParent_u)<size.get(ultimateParent_v)){
            parent.set(ultimateParent_u,ultimateParent_v);
            size.set(ultimateParent_v,size.get(ultimateParent_u)+size.get(ultimateParent_v));
        }else{
            parent.set(ultimateParent_u,ultimateParent_v);
            size.set(ultimateParent_u,size.get(ultimateParent_u)+size.get(ultimateParent_v));
        }
    }

}

public class Graph_43_Accounts_Merge {

    private static List<List<String>> accountsMerge(List<List<String>> details){
        int V = details.size();
        DisjointSet disjointSet = new DisjointSet(V);
        Map<String,Integer> mapMailNode = new HashMap<>();
        for(int node=0;node<V;node++){
            for(int index=1;index<details.get(node).size();index++){
                String mail = details.get(node).get(index);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail,node);
                }else{
                    int prevNode = mapMailNode.get(mail);
                    disjointSet.unionBySize(node,prevNode);
                }
            }
        }

        List<String>[] mergedMail = new ArrayList[V];
        for(int node=0;node<V;node++) mergedMail[node] = new ArrayList<>();

        for(Map.Entry<String,Integer> e : mapMailNode.entrySet()){
            String mail = e.getKey();
            int parentNode = disjointSet.findUltimateParent(e.getValue());
            mergedMail[parentNode].add(mail);
        }

        List<List<String>> mergedAcounts = new ArrayList<>();
        for(int node=0;node<V;node++){
            if(mergedMail[node].size()==0) continue;
            else{
                List<String> mails = mergedMail[node];
                Collections.sort(mails);
                List<String> temp = new ArrayList<>();
                temp.add(details.get(node).get(0));
                for(String mail : mails) temp.add(mail);
                mergedAcounts.add(temp);
            }
        }
        return mergedAcounts;
    }

    public static void main(String[] args) {
        accountsMerge(null);
    }
}
