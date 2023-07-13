import java.util.*; 

class HashCode{
    String string;
    int HashSize, MOD;

    // Constructor 
    HashCode(String string, int HashSize, int MOD){
        this.string = string;
        this.HashSize = HashSize;
        this.MOD = MOD;
    }

    // Compute Hash Of The Given String And HashSize
    public int compute_hash(){
        int HashValue = 0, HashIndex = 1;
        for(char ch : string.toCharArray()){
            HashValue = (HashValue + (ch - 'a' + 1)*HashIndex)%MOD;
            HashIndex = (HashIndex*HashSize)%MOD;
        }
        return HashValue;
    }

    public int getRollingHashFactor(){
        int factor = 1;
        for(int temp=1;temp<=string.length()-1;temp++) factor*=HashSize;
        return factor;
    }
}

public class String_Algo_01_Rabin_Karp_Algorithm {

    private static List<Integer> Rabin_Karp(String string, String pattern){
        // Initiate Values 
        int stringLen = string.length(), patternLen = pattern.length();
        int HashSize = 31, MOD = (int)(1e9)+7;;
        List<Integer> ans = new ArrayList<>();
        HashCode patternHash = new HashCode(pattern,HashSize,MOD);
        int patternHashCode = patternHash.compute_hash();

        // Edge Case 
        if(stringLen<patternLen) return ans;

        // Code
        String _string = string.substring(0,patternLen);
        HashCode stringHash = new HashCode(_string,HashSize,MOD);
        int stringHashCode = stringHash.compute_hash();

        // Check Matches 
        for(int stringPointer=0;stringPointer<=stringLen-patternLen;stringPointer++){
            if(stringHashCode==patternHashCode){
                int patternPointer = 0;
                for(patternPointer=0;patternPointer<patternLen;patternPointer++){
                    if(string.charAt(stringPointer+patternPointer)!=pattern.charAt(patternPointer)){ break;}
                }
                if(patternPointer==patternLen){
                    ans.add(stringPointer+1);
                }
            }
            else{
                if(stringPointer<stringLen-patternLen){
                    stringHashCode = (stringHashCode - (string.charAt(stringPointer)-'a'+1))/HashSize + 
                    (string.charAt(stringPointer+patternLen)-'a'+1)*stringHash.getRollingHashFactor();
                    stringHashCode %= MOD;
                    if(stringHashCode<0) stringHashCode += MOD;
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String string = "ababcababaad", pattern = "ababa";
        System.out.println(Rabin_Karp(string, pattern));
    }
}
