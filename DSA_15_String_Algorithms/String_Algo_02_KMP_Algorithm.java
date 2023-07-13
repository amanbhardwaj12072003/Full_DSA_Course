import java.util.*;

// LPS -> Length Of Longest Proper Prefix And Suffix 
// Proper Prefix Have The Maximum Possible Length Of len-1 And Always Start From The Beginning
// Suffix Have The Maximum Possible Length Of len And Always Start From The End   

class FillLPS{
    public String string;
    public int[] LPS;

    FillLPS(String string, int[] LPS){
        this.string = string;
        this.LPS = LPS;
    }

    // Time Complexity : O(N^3)
    public void inefficientFill(){
        for(int index=0;index<string.length();index++){
            LPS[index] = find(string,index+1); // index+1 --> signifies Length 
        }
    }

    public int find(String string, int n){
        for(int len=n-1;len>0;len--){
            boolean flag = true;
            for(int index=0;index<len;index++){
                if(string.charAt(index)!=string.charAt(n-len+index)){ flag = false; }
            }
            if(flag){
                return len;
            }
        }
        return 0;
    }

    // Time Complexity : O(N)
    public void efficientFill(){
        int n = string.length();
        int len = 0, index = 1;
        LPS[0] = 0;
        while(index<n){
            if(string.charAt(index)==string.charAt(len)){
                len++;
                LPS[index] = len;
                index++;
            }else{
                if(len==0){
                    LPS[index] = 0;
                    index++;
                }else{
                    len = LPS[len-1];
                }
            }
        }
    }
}


public class String_Algo_02_KMP_Algorithm {

    // Naive Approach 
    private static int findOccurence(String string, String pattern){
        int stringLen = string.length(), patternLen = pattern.length();
        int stringPointer = 0, patternPointer = 0;

        // Edge Case 
        if(string.equals(pattern)) return 0;

        // Code 
        while(stringPointer<stringLen){
            if(string.charAt(stringPointer)==pattern.charAt(patternPointer)){
                int index = stringPointer;
                String temp = "";
                while(stringPointer<stringLen && patternPointer<patternLen && 
                string.charAt(stringPointer)==pattern.charAt(patternPointer)){
                    temp += string.charAt(stringPointer);
                    stringPointer++;
                    patternPointer++;
                }
                if(temp.equals(pattern)){
                    return index;
                }else{
                    stringPointer = index+1;
                    patternPointer = 0;
                }
            }else{
                stringPointer++;
            }
        }
        return -1;
    }

    // In-Efficient Knuth-Morris-Pratt Algorithm 
    private static ArrayList<Integer> inefficentKMP(String string, String pattern){
        int stringLen = string.length(), patternLen = pattern.length();
        ArrayList<Integer> storeAllOccurences = new ArrayList<>();
        // Filling The LPS
        int[] LPS = new int[patternLen];
        FillLPS fillLPS = new FillLPS(pattern, LPS);
        fillLPS.inefficientFill();

        int stringPointer = 0, patternPointer = 0;
        while(stringPointer<stringLen){
            if(string.charAt(stringPointer)==pattern.charAt(patternPointer)){
                stringPointer++;
                patternPointer++;
                if(patternPointer==patternLen){
                    storeAllOccurences.add(stringPointer-patternPointer);
                    patternPointer = LPS[patternPointer-1];
                }
            }else if(stringPointer<stringLen && string.charAt(stringPointer)!=pattern.charAt(patternPointer)){
                if(patternPointer==0){
                    stringPointer++;
                }else{
                    patternPointer = LPS[patternPointer-1];
                }
            }
        }
        return storeAllOccurences;
    }

    // Efficient Knuth-Morris-Pratt Algorithm 
    private static ArrayList<Integer> efficentKMP(String string, String pattern){
        int stringLen = string.length(), patternLen = pattern.length();
        ArrayList<Integer> storeAllOccurences = new ArrayList<>();
        // Filling The LPS
        int[] LPS = new int[patternLen];
        FillLPS fillLPS = new FillLPS(pattern, LPS);
        fillLPS.efficientFill();

        int stringPointer = 0, patternPointer = 0;
        while(stringPointer<stringLen){
            if(string.charAt(stringPointer)==pattern.charAt(patternPointer)){
                stringPointer++;
                patternPointer++;
                if(patternPointer==patternLen){
                    storeAllOccurences.add(stringPointer-patternPointer);
                    patternPointer = LPS[patternPointer-1];
                }
            }else if(stringPointer<stringLen && string.charAt(stringPointer)!=pattern.charAt(patternPointer)){
                if(patternPointer==0){
                    stringPointer++;
                }else{
                    patternPointer = LPS[patternPointer-1];
                }
            }
        }
        return storeAllOccurences;
    }

    public static void main(String[] args) {
        String string = "ababcababaad", pattern = "ababa";
        System.out.println("First Occurence Of pattern in string : " + findOccurence(string, pattern));
        System.out.println("First Occurence Of pattern in string : " + inefficentKMP(string, pattern));
        System.out.println("First Occurence Of pattern in string : " + efficentKMP(string, pattern));
    }
}
