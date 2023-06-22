public class Bit_13_Flip_Bits {

    // Logic Building 
    // Note that we have to convert 1-->0  and 0-->1 which can be done by xor as 
    // (1 ^ 1 --> 0) ans (0 ^ 1 --> 1)

    public static int flipBits(int n){
        int count = (int)Math.floor((Math.log10(n)/Math.log10(2))+1);
        // Now a number with all set bits 
        int num = (1 << count) - 1;
        return n ^ num;
    }
    // But sometime this may give IntegerOverFlow
    
    public static int flipBits_(int n){
        int count = (int)Math.floor((Math.log10(n)/Math.log10(2))+1);
        int m = (1 << (count-1));
        m = m | m-1;
        return n ^ m;
    }
    public static void main(String[] args) {
        int num = 10;
        System.out.println(flipBits(num));
        System.out.println(flipBits_(num));
    }
}
