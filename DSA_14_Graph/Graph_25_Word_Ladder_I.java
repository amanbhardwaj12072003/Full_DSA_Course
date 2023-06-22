import java.util.*;
class Pair{
    String word;
    int step;
    Pair(String word,int step){
        this.word = word;
        this.step = step;
    }
}
public class Graph_25_Word_Ladder_I {

    public static int countSteps(String startWord,String targetWord,String[] wordList){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startWord,0));
        HashSet<String> wordSet = new HashSet<>();
        for(int put=0;put<wordList.length;put++){wordSet.add(wordList[put]);}
        wordSet.remove(startWord);
        while(!queue.isEmpty()){
            Pair curPair = queue.poll();
            String curWord = curPair.word;
            int curStep = curPair.step;

            // Check 
            if(curWord == targetWord) return curStep;

            // Update 
            for(int index=0;index<curWord.length();index++){
                for(char ch='a';ch<'z';ch++){
                    char[] replaceArray = curWord.toCharArray();
                    replaceArray[index] = ch;
                    String updatedWord = new String(replaceArray);

                    // Verify the existance in the set
                    if(wordSet.contains(updatedWord)){
                        wordSet.remove(updatedWord);
                        queue.offer(new Pair(updatedWord, curStep+1));
                    }
                }
            }
        }
        return -1; // Not Possible 
    }

    public static void main(String[] args) {
        
    }   
}
