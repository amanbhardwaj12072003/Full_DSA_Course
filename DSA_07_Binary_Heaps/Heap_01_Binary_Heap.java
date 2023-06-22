class MaxPQ{
    private Integer[] heap;  // Integer storing the values of Max-Heap
    private int n; // Size of the Max-Heap

    public MaxPQ(int capacity){
        heap = new Integer[capacity+1];  
        n = 0; // Initial size of array storing node values in the heap is 0
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }
}

public class Heap_01_Binary_Heap {
    public static void main(String[] args) {
        
        MaxPQ pq = new MaxPQ(3);  // Initiating a heap of size 3
        System.out.println(pq.size());     // Will return 0
        System.out.println(pq.isEmpty());  // Will return true

    }
}
