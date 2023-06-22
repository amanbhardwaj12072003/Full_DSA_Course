import java.util.LinkedList;
import java.util.Queue;

public class Queue_02_Generating_Binary_Numbers_Using_Queue {

    public static String[] GenerateBinary(int n){
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for(int i=0;i<n;i++){
            result[i] = queue.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            queue.offer(n1);
            queue.offer(n2);

        }
        return result;
    }

    public static void main(String[] args) {
        
        String[] demo = GenerateBinary(10);
        for(String s : demo){
            System.out.print(s + " , ");
        }
    }
}
