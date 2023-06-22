import java.util.*;
public class Graph_26_Word_Ladder_II {
    public static ArrayList<ArrayList<String>> bfs(String startWord,String endWord,String[] wordList){
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList) {wordSet.add(word);}
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> currentLevel = new ArrayList<>();
        currentLevel.add(startWord);
        queue.offer(currentLevel);
        ArrayList<String> usedInLevel = new ArrayList<>();
        usedInLevel.add(startWord);
        int level = 0;
        ArrayList<ArrayList<String>> shortestPath = new ArrayList<>();
        while(!queue.isEmpty()){
            ArrayList<String> levelList = queue.poll();

            // Check for level update 
            if(levelList.size() > level){
                level++;
                for(String wordOnCurrentLevel : usedInLevel) {wordSet.remove(wordOnCurrentLevel);}
            }

            // Check for the end 
            String lastWord = levelList.get(levelList.size()-1);
            if(lastWord.equals(endWord)){
                if(shortestPath.size()==0) shortestPath.add(levelList);
                else if(shortestPath.get(0).size()==levelList.size()) shortestPath.add(levelList);
            
            }

            // Operation 
            for(int index=0;index<lastWord.length();index++){
                for(char ch='a';ch<'z';ch++){
                    char[] replaceArray = lastWord.toCharArray();
                    replaceArray[index] = ch;
                    String replacedWord = new String(replaceArray);
                    if(wordSet.contains(replacedWord)){
                        levelList.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(levelList);
                        queue.offer(temp);
                        usedInLevel.add(replacedWord);
                        levelList.remove(levelList.size()-1);
                    }
                }
            }
        }

        return shortestPath;
    } 
    public static void main(String[] args) {

    }
}
